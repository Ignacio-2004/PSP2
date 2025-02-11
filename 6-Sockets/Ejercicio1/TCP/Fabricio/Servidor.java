import java.io.*;
import java.net.*;

public class Servidor {    

    public static void main(String[] args) throws IOException, InterruptedException {
        
        TCPClass sm = new TCPClass();
            
        Socket socket = sm.createServer();
        int num  = Integer.parseInt(sm.read(socket));

        sm.setData("localhost", 55558);

        Socket socket2 = sm.creaSocket();

        sm.write(socket2, String.valueOf(num));

        num = Integer.parseInt(sm.read(socket2));
        
        sm.write(socket, String.valueOf(num));
        sm.closeServer();
        socket2.close();
    }



}
