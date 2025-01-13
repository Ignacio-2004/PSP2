public class Deposito {

    int tanque;
    boolean runOutOf;

    public Deposito(){
        this.tanque=0;
        runOutOf = true;
    }

    public synchronized void setFuel(String id){

        while (tanque!=0) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        int fuel = random(100, 1000);
        System.out.println("Productor("+id+") llena el depósito con => "+fuel+" Litros");

        tanque += fuel;
        runOutOf= false;

        notifyAll();

    }

    public synchronized int getFuel(String id){

        while (runOutOf) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        int fuel;
        
        fuel=tanque;
        tanque=0;
        runOutOf=true;

        System.out.println("Camion("+id+") carga: "+fuel+" litros");

        notifyAll();

        return fuel;

    }


    private static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

}