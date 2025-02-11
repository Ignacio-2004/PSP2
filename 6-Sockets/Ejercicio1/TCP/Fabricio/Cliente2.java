import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente2 {
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        
        TCPClass socketManager = new TCPClass("localhost",55558);

        Socket socket = socketManager.createServer();

        int num = factorial(Integer.parseInt(socketManager.read(socket)));

        socketManager.write(socket,String.valueOf(num));

        socketManager.closeServer();

    }
    private static int factorial(int num){
        if (num==0) {
            return 1;
        }else{
            return num*factorial(num-1);
        }
    }
}
