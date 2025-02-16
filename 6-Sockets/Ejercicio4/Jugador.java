import java.util.Scanner;

public class Jugador extends Thread{
    int id;
    TCP tcp;
    Scanner scanner;

    public Jugador(int id){
        this.id =  id;
        tcp = new TCP();
        scanner = new Scanner(System.in);
    }

    public void run(){
        try {
            do{
                sleep(2000);
            }while(Askking.intent(id, tcp, scanner));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
