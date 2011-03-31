package kchcinemas;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Response {
	// Todo: Response Code with proper name

	private Map<String,String> mapHeaders = null;
	private byte[] bytContents = new byte[0];
	private int intCode = 200;

	public Response() {
		this.mapHeaders = new HashMap<String,String>();

		/* Begin Default Headers */
		this.mapHeaders.put("Date"         ,	new Date().toString());
		this.mapHeaders.put("Server"       ,	"SSSCinemas/Custom-WS");
		this.mapHeaders.put("Expires"      ,	"Thu, 01 Dec 1994 16:00:00 GMT");
		this.mapHeaders.put("Last-modified",	new Date(System.currentTimeMillis()).toString());
		/* End Default Headers */
	}

	public void addHeader(String strHeaderName, String strHeaderValue) {
		this.mapHeaders.put(strHeaderName, strHeaderValue);
	}

	public void setContents(String strContents) {
		this.bytContents = strContents.getBytes();
	}

	public void setContents(byte[] bytContents) {
		this.bytContents = bytContents;
	}

	public void setCode(int intCode) {
		this.intCode = intCode;
	}

	public void output(BufferedOutputStream objStream) throws IOException {
		String strHeaders = "HTTP/1.0 " + this.intCode + " OK";
		for (Map.Entry<String,String> objHeader : this.mapHeaders.entrySet()) {
			strHeaders += "\r\n" + objHeader.getKey() + ": " + objHeader.getValue();
		}
		strHeaders += "\r\n\r\n";

		objStream.write(strHeaders.getBytes());
		objStream.flush();
		objStream.write(this.bytContents);
		objStream.flush();
		objStream.close();
	}
}
