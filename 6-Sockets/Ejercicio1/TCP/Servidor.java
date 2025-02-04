import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private final static int PUERTO = 55555;

    public static void main(String[] args) throws IOException {

        final  ServerSocket SERVER = new ServerSocket(PUERTO);
        InputStream in = null;
        DataInputStream inData = null;
        OutputStream out = null;
        DataOutputStream outData = null;

        do{
            System.out.println("Esperando al cliente");

            Socket client = SERVER.accept();
            in = client.getInputStream();
            inData = new DataInputStream(in);


            int num = factorial(inData.readInt());


            out = client.getOutputStream();
            outData = new DataOutputStream(out);

            outData.writeInt(num);
        }while(true);
    }

    private static int factorial(int num){
        if (num==0) {
            return 1;
        }else{
            return num*factorial(num-1);
        }
    }
}