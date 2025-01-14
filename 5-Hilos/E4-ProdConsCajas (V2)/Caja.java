public class Caja extends Thread{

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

        for (int i = 0; i < 1; ){
            cliente = gest.siguienteCliente(id,cliente);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}

            if (cliente == null) {
                i=1;
            }

        }

    }
    
}
