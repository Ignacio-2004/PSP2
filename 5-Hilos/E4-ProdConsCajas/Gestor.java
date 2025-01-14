public class Gestor {

    Cliente cliente;

    public Gestor(){
        cliente=null;
    }

    public synchronized void generarCLiente(int i){

        while (cliente != null) {
            
            try {
                wait();
            } catch (InterruptedException e) {}

        }

        cliente = new Cliente(i);

        notifyAll();

    }

    public synchronized Cliente siguienteCliente(int id,Cliente cli){

        if (cli!=null) {
            System.out.println("Caja("+id+") termino de atender al cliente:"+cli.id);
        }

        while(cliente==null){

            try {
                wait();
            } catch (InterruptedException e) {}

        }

        System.out.println("Caja("+id+") atendiendo al cliente:"+cliente.id);

        cli = cliente;

        cliente = null;
        notifyAll();

        return cli;

    }

}
