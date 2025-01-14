import java.util.ArrayList;

public class Gestor {

    ArrayList<Cliente> clienteCola;
    private int cc;

    public Gestor(){
       clienteCola = new ArrayList<>();
       cc=0;
    }

    public synchronized void generarCLiente(int i){

        while (clienteCola.size()>=5) {
            
            try {
                wait();
            } catch (InterruptedException e) {}

        }

        clienteCola.add(new Cliente(i)) ;
        System.out.println("Nuevo cliente en la cola.");
        cc++;

        notifyAll();

    }

    public synchronized Cliente siguienteCliente(int id,Cliente cli){

        if (cli!=null) {
            System.out.println("Caja("+id+") termino de atender al cliente:"+cli.id);
        }

        while(clienteCola.isEmpty()){

            if (cc ==15) {
                return null;
            }

            try {
                wait();
            } catch (InterruptedException e) {}

        }

        System.out.println("Caja("+id+") atendiendo al cliente:"+clienteCola.get(0).id);

        cli = clienteCola.get(0);
        clienteCola.remove(0);

        notifyAll();

        return cli;

    }

}
