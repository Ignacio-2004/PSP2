import java.io.IOException;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Cliente {

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        UDPClass udpClass = new UDPClass();

        DatagramSocket ds = udpClass.createSocket();

        System.out.print("Introduzca el numero: ");
        udpClass.write(ds,String.valueOf(keyboard.nextInt()));

        System.out.println(new String(udpClass.readDatagram(ds).getData()));
        ds.close();
    }
}
