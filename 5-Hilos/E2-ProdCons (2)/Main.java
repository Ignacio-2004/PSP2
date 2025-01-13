public class Main {

    public static void main(String[] args) {
        Cola cola = new Cola();

        Consumidor consumidor = new Consumidor(cola, 001);
        Consumidor2 consumidor2 = new Consumidor2(cola, 002);
        Productor productor = new Productor(cola, 101);

        productor.start();
        consumidor.start();
        consumidor2.start();
        
    }
    
}
