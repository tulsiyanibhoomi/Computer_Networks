import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);

        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress address = InetAddress.getLocalHost();
        byte[] input = null;

        while(true){
            String line = sc.nextLine();
            input = line.getBytes();

            DatagramPacket datagramPacket = new DatagramPacket(input, input.length, address, 4000);

            datagramSocket.send(datagramPacket);

            if(line.equals("Exit")){
                break;
            }
        }
        datagramSocket.close();
        sc.close();
    }
}
