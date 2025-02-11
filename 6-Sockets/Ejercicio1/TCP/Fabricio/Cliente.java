import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {

        Scanner s = new Scanner(System.in);

        TCPClass sm = new TCPClass("192.168.114.107",5555);
        Socket socket = sm.creaSocket();
        System.out.print("Introduce el numero: ");
        sm.write(socket, s.nextLine());
        System.out.println();

        System.out.println(sm.read(socket));

        socket.close();
        s.close();
    }

}