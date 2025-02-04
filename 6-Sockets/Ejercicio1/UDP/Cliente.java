import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    
    private final static int PUERTO = 5555;
    private final static String IP = "localhost";
    private static InputStream ips = null;
    private static DataInputStream dips = null;
    private static OutputStream ops = null;
    private static DataOutputStream dops = null;
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket(IP,PUERTO);

        ops=socket.getOutputStream();
        dops = new DataOutputStream(ops);
        dops.writeInt(5);

        ips = socket.getInputStream();
        dips = new DataInputStream(ips);

        System.out.println(dips.readInt());


    }

}