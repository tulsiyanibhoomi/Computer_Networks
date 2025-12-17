import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(4000);
        System.out.println("Server is running");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client Accepted");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(),true);

        String msg = bufferedReader.readLine();
        System.out.println("Client says: "+msg);

        printWriter.println("Message Received");

        clientSocket.close();
        serverSocket.close();
    }
}
