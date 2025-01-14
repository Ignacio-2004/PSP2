public class Main {

    public static void main(String[] args) {
        
        Gestor g = new Gestor();

        Caja c = new Caja(01, g);
        Caja c2 = new Caja(02, g);
        Caja c3 = new Caja(03, g);

        CreadorClientes cc = new CreadorClientes(g);

        cc.start();
        c.start();
        c2.start();
        c3.start();


        try {
            cc.join();
            c.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {}

        System.out.println("Supermercado cerrado.");
    }
}