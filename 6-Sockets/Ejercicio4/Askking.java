import java.net.Socket;
import java.util.Scanner;

public class Askking {
    public static synchronized boolean intent(int id, TCP tcp, Scanner scanner) throws Exception{
        Socket s = tcp.createSocket();

        tcp.UpdateInputs(s);
        tcp.UpdateOutputs(s);

        tcp.write("Permission");

        if (tcp.read().equals("Accept")) {
            
            System.out.print("Introduzca un número: ");
            int num = scanner.nextInt();

            tcp.write(String.valueOf(num));

            switch (tcp.read()) {
                case "Upper":
                    System.out.println("El numero es mas bajo");
                    break;
                case "Lower":
                    System.out.println("El numero es mas alto");
                    break;
                default:
                System.out.println("Has acertado");
                s.close();
                return false;
                    
            }
            s.close();
            return true;

        }else{
            System.out.println("El juego a terminado.");
            s.close();
            return false;
        }
    }
}
