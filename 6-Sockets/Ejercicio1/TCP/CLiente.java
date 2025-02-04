import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class CLiente {

    private final static int PUERTO = 55555;
    private final static int NUM = 5;

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost",PUERTO);
        InputStream in = null;
        DataInputStream inData = null;
        OutputStream out = null;
        DataOutputStream outData = null;

        out= socket.getOutputStream();
        outData = new DataOutputStream(out);

        outData.writeInt(NUM);

        System.out.println("Esperando al cliente");
        inData = new DataInputStream(socket.getInputStream());

        System.out.println(inData.readInt());

        socket.close();
    }
}
