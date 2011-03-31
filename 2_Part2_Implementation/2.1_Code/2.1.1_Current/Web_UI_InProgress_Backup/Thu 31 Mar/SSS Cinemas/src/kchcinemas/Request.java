package kchcinemas;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kchcinemas.pages.handlers.*;

public class Request extends Thread {
	private static final RequestHandler objDefaultRequestHandler = new RequestHandler() {
		@Override
		public Response getResponse(Session objSession, PropertyList plProperties, Matcher objMatcher) {
			return null;
		}

		@Override
		public boolean needsUser() {
			return false;
		}

		@Override
		public boolean needsSession() {
			return false;
		}
		
	};
	private static final Map<Pattern,RequestHandler> mapRequestHandlers = new HashMap<Pattern,RequestHandler>();
	static {
//		mapRequestHandlers.put(Pattern.compile("^book"), new BookingHandler());
		mapRequestHandlers.put(Pattern.compile("login"), new LoginHandler());
		mapRequestHandlers.put(Pattern.compile("resource(?:s?)/(.+)"),new ResourceHandler());
		mapRequestHandlers.put(Pattern.compile("^$"), new IndexHandler());
	}

	private Socket objSocket = null;

	public Request(Socket objClientSocket) {
		this.objSocket = objClientSocket;
	}

	@Override
	public void run() {
		SessionManager.suspendPruner();

		BufferedReader objInput = null;
		BufferedOutputStream objOutput = null;
		try {
			objInput = new BufferedReader(new InputStreamReader(this.objSocket.getInputStream()));
			objOutput = new BufferedOutputStream(this.objSocket.getOutputStream());

			Response objResponse = null;

			String strRequest = objInput.readLine();
			if (strRequest == null || !(strRequest.startsWith("GET ") || strRequest.startsWith("POST ")) || !(strRequest.endsWith(" HTTP/1.0") || strRequest.endsWith("HTTP/1.1"))) {
				objResponse = ResponseFactory.create500Response();
			}
			else {
				PropertyList plParameters = new PropertyList();
				char[] chrRequestData = new char[2];
				if (strRequest.startsWith("POST")) {
					String strLine;
					int intContentLength = -1;
					while ((strLine = objInput.readLine().toUpperCase()) != null) {
						if (strLine.startsWith("CONTENT-TYPE:")) {
							if (!strLine.substring(13).trim().startsWith("APPLICATION/X-WWW-FORM-URLENCODED")) {
								objResponse = ResponseFactory.create500Response();
								break;
							}
						}
						if (intContentLength < 0) {
							if (strLine.startsWith("CONTENT-LENGTH:")) {
								intContentLength = Integer.parseInt(strLine.substring(15).trim());
								chrRequestData = new char[intContentLength+2];
							}
						}
						else {
							if (intContentLength < 1) {
								break;
							}
							else if (strLine.trim().isEmpty()) {
								while (true) {
									char chrRead = (char)objInput.read();
									if (!(chrRead == '\n' || chrRead == '\r')) {
										chrRequestData[0] = chrRead;
										break;
									}
								}
								break;
							}
						}
					}
					if (objResponse == null) {
						objInput.read(chrRequestData,1,intContentLength);
						String strRequestData = new String(chrRequestData);
						for (String strParameter : strRequestData.split("&")) {
							String[] arrNameValuePair = strParameter.split("=",2);
							plParameters.put(URLDecoder.decode(arrNameValuePair[0],"utf-8").trim(), URLDecoder.decode(arrNameValuePair[1],"utf-8").trim());
						}
					}
				}

				if (objResponse == null) {
					strRequest = URLDecoder.decode(strRequest.substring(4, strRequest.length() - 9), "UTF-8").toLowerCase().trim();

					while (strRequest.startsWith("/")) {
						strRequest = strRequest.substring(1,strRequest.length());
					}
					while (strRequest.endsWith("/")) {
						strRequest = strRequest.substring(0, strRequest.length() - 1);
					}

					RequestHandler objHandler = objDefaultRequestHandler;
					Matcher objMatcher = null;
					for (Map.Entry<Pattern,RequestHandler> objEntry : mapRequestHandlers.entrySet()) {
						if ((objMatcher=objEntry.getKey().matcher(strRequest)).matches()) {
							objHandler = objEntry.getValue();
							break;
						}
					}

					Session objSession = null;
					if (plParameters.containsKey("sessionid")) {
						objSession = SessionManager.getSession(plParameters.get("sessionid"));
					}
					if (objSession == null && objHandler.needsSession()) {
						objSession = SessionManager.createSession();
					}

					if (objHandler.needsUser() && !objSession.isLoggedIn()) {
						objResponse = ResponseFactory.createSessionResponse();
					}

					objResponse = objHandler.getResponse(objSession,plParameters,objMatcher);
					if (objResponse == null) {
						objResponse = ResponseFactory.create404Response(strRequest);
					}
				}
			}

			objResponse.output(objOutput);
		}
		catch (IOException objException) {}
		finally {
			try {
				objInput.close();
			}
			catch (Exception objException) {}
			try {
				objOutput.close();
			}
			catch (Exception objException) {}
		}

		SessionManager.restartPruner();
	}
}

