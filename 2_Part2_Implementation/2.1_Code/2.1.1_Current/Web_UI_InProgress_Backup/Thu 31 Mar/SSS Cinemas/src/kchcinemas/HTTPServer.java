package kchcinemas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class HTTPServer extends Thread {
	private int intPort = 0;
	private ServerSocket objServerSocket = null;

    public HTTPServer(int intPreferredPort) {
        intPort = intPreferredPort;
    }

	@Override
	public void run() {
		try {
			intPort = PortManager.getAvailablePort(intPort,true);
			objServerSocket = new ServerSocket(intPort);
			objServerSocket.setReuseAddress(true);
			SessionManager.initialize();
			while (true) {
				Socket objClientSocket = objServerSocket.accept();
				Request objRequest = new Request(objClientSocket);
				objRequest.start();
			}
		}
		catch (IOException objException) {
			return;
		}
	}

	public static InputStream getResource(String strPath) {
		ClassLoader objLoader = HTTPServer.class.getClassLoader();
		return objLoader.getResourceAsStream(strPath);
	}

	public static String getResourceAsString(String strPath) throws IOException {
		InputStream objStream = getResource(strPath);
		if (objStream == null) {
			return null;
		}
		else {
			StringBuffer strData = new StringBuffer();
			char[] chrBuffer = new char[1024];
			int intNumRead = 0;
			BufferedReader objReader = new BufferedReader(new InputStreamReader(objStream,Charset.forName("US-ASCII")));
			while ((intNumRead=objReader.read(chrBuffer)) != -1) {
				strData.append(chrBuffer, 0, intNumRead);
			}
			objReader.close();
			objStream.close();
			return strData.toString();
		}
	}
}
