public class Main {

    public static void main(String[] args) {
        Cola cola = new Cola();

        Consumidor consumidor = new Consumidor(cola, 001);
        Productor productor = new Productor(cola, 101);

        productor.start();
        consumidor.start();
        
    }
    
}
