import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) throws IOException {
        UDPClass udpClass = new UDPClass();
        udpClass.createServer();

        DatagramPacket dp = udpClass.readDatagram();

        udpClass.setData(12346, InetAddress.getLocalHost());
        DatagramSocket ds = udpClass.createSocket();
        udpClass.write(ds,new String(dp.getData()));
        
        String num = udpClass.readString(ds);
        System.out.println("Recived: "+num);
        udpClass.write(udpClass.getSs(),dp,num);
        System.out.println("Send");

        ds.close();
        udpClass.closeServer();
    }
}
