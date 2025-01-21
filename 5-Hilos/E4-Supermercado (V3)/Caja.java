public class Caja extends Thread{
    
    private int id;
    private Cola cola;
    private Integer idCLiente;
    private int c;

    public Caja(int id, Cola cola){

        this.id = id;
        this.cola = cola;
        this.idCLiente = null;
        this.c = 0;
    }

    @Override
    public void run(){
        do{
            idCLiente = cola.siguiente(id);
            
            if (idCLiente != null) {

                try {
                    sleep(id*1000);
                } catch (InterruptedException e) {}

                cola.pagoFinalizado(id);
                c+=1;
            }
        }while (idCLiente!=null);

        System.out.println("Han pasado por la caja("+id+") "+c+" clientes.");

    }

}
