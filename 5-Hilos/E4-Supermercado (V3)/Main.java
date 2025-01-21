public class Main {
    public static void main(String[] args) {
        
        Cola cola = new Cola();
        
        Caja caja11 = new Caja(1, cola);
        Caja caja12 = new Caja(2, cola);
        Caja caja13 = new Caja(13, cola);

        Cliente cliente1 = new Cliente(1, cola);
        Cliente cliente2 = new Cliente(2, cola);
        Cliente cliente3 = new Cliente(3, cola);
        Cliente cliente4 = new Cliente(4, cola);
        Cliente cliente5 = new Cliente(5, cola);
        Cliente cliente6 = new Cliente(6, cola);
        Cliente cliente7 = new Cliente(7, cola);
        Cliente cliente8 = new Cliente(8, cola);
        Cliente cliente9 = new Cliente(9, cola);
        Cliente cliente10 = new Cliente(10, cola);
        Cliente cliente11 = new Cliente(11, cola);
        Cliente cliente12 = new Cliente(12, cola);
        Cliente cliente13 = new Cliente(13, cola);
        Cliente cliente14 = new Cliente(14, cola);
        Cliente cliente15 = new Cliente(15, cola);

        caja11.start();
        caja12.start();
        caja13.start();

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();
        cliente7.start();
        cliente8.start();
        cliente9.start();
        cliente10.start();
        cliente11.start();
        cliente12.start();
        cliente13.start();
        cliente14.start();
        cliente15.start();

        try {

            cliente1.join();
            cliente2.join();
            cliente3.join();
            cliente4.join();
            cliente5.join();
            cliente6.join();
            cliente7.join();
            cliente8.join();
            cliente9.join();
            cliente10.join();
            cliente11.join();
            cliente12.join();
            cliente13.join();
            cliente14.join();
            cliente15.join();

            cola.cerrar();

            caja11.join();
            caja12.join();
            caja13.join();

            System.out.println("Supermecado cerrado");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
