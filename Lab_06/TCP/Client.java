import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost",4000);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter.println("Hello from Client");
        
        String response = bufferedReader.readLine();
        System.out.println("Server Response: "+response);

        socket.close();
    }
}
