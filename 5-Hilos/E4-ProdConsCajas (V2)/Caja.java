public class Caja extends Thread{

    Cliente cliente;
    Gestor gest;
    int id;
    private int c;

    public Caja(int id,Gestor gest){
        this.id = id;
        this.gest = gest;
        cliente = null;
        c=0;
    }

    @Override
    public void run(){

        do{
            cliente = gest.siguienteCliente(id,cliente);
            try {
                Thread.sleep(id*1000);
            } catch (InterruptedException e) {}
            c++;
        }while(cliente != null);
        System.out.println("La caja ("+id+") ha antendido a "+(c-1)+" clientes");
    }
    
}
