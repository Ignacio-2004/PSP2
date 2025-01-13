public class Main {

    public static void main(String[] args) {
        Cola cola = new Cola();

        Consumidor consumidor = new Consumidor(cola, 201);
        Consumidor consumidor2 = new Consumidor(cola, 202);
        Consumidor consumidor3 = new Consumidor(cola, 203);


        Productor productor = new Productor(cola, 101);
        Productor productor2 = new Productor(cola, 102);
        Productor productor3 = new Productor(cola, 103);
        

        productor.start();
        productor2.start();
        productor3.start();

        consumidor.start();
        consumidor2.start();
        consumidor3.start();
        
    }
    
}
