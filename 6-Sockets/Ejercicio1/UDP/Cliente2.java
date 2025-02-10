import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;


public class Cliente2 {
    public static void main(String[] args) throws IOException {
        UDPClass udpClass = new UDPClass(12346, InetAddress.getLocalHost());
        udpClass.createServer();

        DatagramPacket dp = udpClass.readDatagram();
        System.out.println("Recived: "+new String(dp.getData()));
        int num = factorial(Integer.parseInt(new String(dp.getData()).trim()));

        udpClass.write(udpClass.getSs(),dp,String.valueOf(num));
        System.out.println("Send");

        udpClass.closeServer();

    }
    private static int factorial(int num){
        if (num == 1){
            return 1;
        }else{
            return num * factorial(num - 1);
        }
    }
}
