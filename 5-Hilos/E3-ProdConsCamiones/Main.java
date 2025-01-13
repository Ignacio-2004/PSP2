import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Deposito dep = new Deposito();

        Camion c = new Camion("01", dep);
        Camion c2 = new Camion("02", dep);
        Camion c3 = new Camion("03", dep);
        Productor p = new Productor("11", dep);

        c.start();
        c2.start();
        c3.start();
        p.start();
    }
}
