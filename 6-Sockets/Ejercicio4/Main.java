import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {

        TCP tcp = new TCP();

        Jugador j1 = new Jugador(1);
        Jugador j2 = new Jugador(2);
        Jugador j3 = new Jugador(3);
        Jugador j4 = new Jugador(4);

        j1.start();
        j2.start();
        j3.start();
        j4.start();

        j1.join();
        j2.join();
        j3.join();
        j4.join();

        Socket s = tcp.createSocket();

        tcp.UpdateOutputs(s);
        tcp.write("finishGame");

        s.close();

    }
}
