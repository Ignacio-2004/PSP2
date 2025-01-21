import java.util.ArrayList;

public class Cola {

    private ArrayList<Integer> clientList;
    private boolean cerrado;

    public Cola(){
        clientList = new ArrayList<>();
        cerrado = false;
    }

    public synchronized void pedirTicket(int id){
        
        System.out.println("Cliente nº: "+id+" esperando en la cola.");
        clientList.add(id);

        notifyAll();

    }

    public synchronized Integer siguiente(int id){

        while (clientList.isEmpty()) {

            if (cerrado) {
                return null;
            }
            try {
                wait();
            } catch (InterruptedException e) {}

        }

        int vitId = clientList.get(0);
        clientList.remove(0);

        System.out.println("El cliente nº: "+vitId+" pasa por la caja: "+id);

        return vitId;
    }

    public synchronized void pagoFinalizado(int id){

        System.out.println("El cliente de la caja: "+id+" a terminado la compra.");

    }

    public void cerrar(){
        cerrado = true;
    }
}
