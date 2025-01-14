public class Caja extends Thread{

    private final int NUM = 5;
    Cliente cliente;
    Gestor gest;
    int id;

    public Caja(int id,Gestor gest){
        this.id = id;
        this.gest = gest;
        cliente = null;
    }

    @Override
    public void run(){

        for (int i = 0; i < NUM; i++){
            cliente = gest.siguienteCliente(id,cliente);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
        }

    }
    
}
