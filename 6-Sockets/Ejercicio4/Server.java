import java.io.IOException;
import java.net.Socket;

public class Server{
    public static void main(String[] args) throws Exception {
        TCP tcp = new TCP();

        boolean finish = false;
        boolean exit = false;
        long pid = ProcessHandle.current().pid();
        System.out.println("Current pid: "+pid);

        tcp.createServer();

        do{
            System.out.println("\n\n");

            Socket s = tcp.waitConnection();
            tcp.UpdateInputs(s);
            tcp.UpdateOutputs(s);

            String msg = tcp.read();

            switch (msg) {
                case "Permission":
                    System.out.println("Jugador conectado");

                    if (finish) {
                        System.out.println("Permiso denegado.");
                        tcp.write("Denied");
                    }else{
                        System.out.println("Permiso concedido");
                        tcp.write("Accept");

                        System.out.println("\n\n");

                        msg=tcp.read();
                        System.out.println("El jugador ha escrito el numero"+msg);
                        if (Integer.parseInt(msg)>pid) {
                            System.out.println("Upper");
                            tcp.write("Upper");
                        }else if (Integer.parseInt(msg)<pid) {
                            System.out.println("Lower");
                            tcp.write("Lower");
                        }else{
                            System.out.println("Achieve");
                            tcp.write("Winner");
                            finish = true;
                        } 

                    }
                    s.close();

                    break;
                case "finishGame":
                    System.out.println("Todos los jugadores han sido notificados.");
                    exit = true;
                    s.close();
                break;
                default:
                    System.out.println("Error de conexion");
                    s.close();
                    break;
            }

        }while(!exit);

        tcp.closeServer();
    }
}