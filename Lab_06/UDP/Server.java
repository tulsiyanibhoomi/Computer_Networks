import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException{
        DatagramSocket datagramSocket = new DatagramSocket(4000);
        byte[] received = new byte[10000];

        DatagramPacket dpReceive = null;

        while(true){
            dpReceive = new DatagramPacket(received, received.length);
            datagramSocket.receive(dpReceive);

            if(byteToString(received).toString().equals("Exit")){
                System.out.println("Client said Exit");
                break;
            }

            System.out.println("Client says: "+byteToString(received));
            
            received = new byte[10000];
        }

        datagramSocket.close();
    }

    public static StringBuilder byteToString(byte[] a)
    {
        if (a == null){
            return null;
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ans.append((char) a[i]);
            i++;
        }
        return ans;
    }
}
