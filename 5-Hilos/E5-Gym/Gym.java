public class Gym {

    private int aforoMaximo;
    private int contador;

    public Gym (int aforo){
        this.aforoMaximo = aforo;
        this.contador=0;
    }

    public synchronized void entrar(int id) throws Exception{

        while (contador==aforoMaximo) {
            System.out.println("W: Cola llena, cliente("+id+") esperando.");
            wait();
        }

        System.out.println("E: cliente("+id+") ha entado.");
        contador+=1;

    }

    public synchronized void salir(int id){

        System.out.println("S: cliente("+id+") ha terminado de entrenar y ha salido.");
                notify();
                contador-=1;
    }
}
