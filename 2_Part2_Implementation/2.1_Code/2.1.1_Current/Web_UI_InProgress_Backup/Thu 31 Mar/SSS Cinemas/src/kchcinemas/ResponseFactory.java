package kchcinemas;

public class ResponseFactory {
	public static Response createOutputResponse(String strContents, String strContentType) {
		return createOutputResponse(strContents, strContentType, 200);
	}

	public static Response createOutputResponse(String strContents, String strContentType, int intCode) {
		if (strContents == null || strContentType == null) {
			return null;
		}
		else {
			byte[] bytContents = strContents.getBytes();

			Response objResponse = new Response();
			objResponse.setCode(intCode);
			objResponse.addHeader("Content-Type"  ,	strContentType);
			objResponse.addHeader("Content-Length",	Integer.toString(bytContents.length));
			objResponse.setContents(bytContents);

			return objResponse;
		}
	}

	public static Response createRedirectResponse(String strURL) {
		if (strURL == null) {
			return null;
		}
		else {
			Response objResponse = new Response();
			objResponse.setCode(302);
			objResponse.addHeader("Location",	strURL);

			return objResponse;
		}
	}

	public static Response createRedirectResponse(String strURL, Session objSession) {
		if (objSession == null) {
			return createRedirectResponse(strURL);
		}
		else if (strURL == null) {
			return null;
		}
		else {
			Response objResponse = new Response();
			objResponse.setCode(302);
			objResponse.setContents("<html><head><title>Redirect Page</title></head><body onload=\"document.forms[0].submit()\">Please click the button below if you are not redirected within 5 seconds<form action=\"" + strURL + "\" method=\"post\"><input type=\"hidden\"  name=\"sessionid\" id=\"sessionid\" value=\"" + objSession.getKey() + "\" /><button type=\"submit\">Continue...</button></form></body></html>");

			return objResponse;
		}
	}

	public static Response create500Response() {
		return createErrorResponse(500,"Invalid Method","");
	}

	public static Response create404Response(String strPath) {
		return createErrorResponse(404,"Path Not Found",strPath);
	}

	public static Response createSessionResponse() {
		return createErrorResponse(302,"Session Error","An invalid session ID was provided, or your session has timed out.<br /><a href=\"/login\" style=\"color:blue\">Please Login Again</a>");
	}

	public static Response createErrorResponse(int intCode, String strLine1, String strLine2) {
		return createOutputResponse("<div style=\"font-weight:bold; font-family:Verdana; color:red;\">" + strLine1 + "</div><div style=\"font-style:italic;\">" + strLine2 + "</div>","text/html",intCode);
	}
}
