package kchcinemas;

public class Main {
    public static void main(String[] args) {
        HTTPServer objServer = new HTTPServer(22222);
		objServer.start();
    }
}
