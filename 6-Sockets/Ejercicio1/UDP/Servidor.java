import java.io.*;
import java.net.*;

public class Servidor {
    
    private final static int PUERTO = 5555;
    private static Socket socket = null;
    private static InputStream ips = null;
    private static DataInputStream dips = null;
    private static OutputStream ops = null;
    private static DataOutputStream dops = null;
    

    public static void main(String[] args) throws IOException {
        
        ServerSocket ss = new ServerSocket(PUERTO);
        do{
            
            socket = ss.accept();
            
            ips = socket.getInputStream();
            dips = new DataInputStream(ips);

            int num  = dips.readInt();
            num = num*3;

            ops = socket.getOutputStream();
            dops = new DataOutputStream(ops);

            dops.writeInt(num);

        }while(true);

    }

}
