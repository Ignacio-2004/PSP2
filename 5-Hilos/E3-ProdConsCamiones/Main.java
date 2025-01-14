import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Deposito dep = new Deposito();

        Camion c = new Camion("01", dep);
        Camion c2 = new Camion("02", dep);
        Camion c3 = new Camion("03", dep);
        Camion c4 = new Camion("04", dep);
        Camion c5 = new Camion("05", dep);
        Camion c6 = new Camion("06", dep);
        Camion c7 = new Camion("07", dep);
        Camion c8 = new Camion("08", dep);
        Camion c9 = new Camion("09", dep);
        Camion c10 = new Camion("10", dep);
        Camion c11 = new Camion("11", dep);
        Camion c12 = new Camion("12", dep);
        Camion c13 = new Camion("13", dep);
        Camion c14 = new Camion("14", dep);
        Camion c15 = new Camion("15", dep);
        Productor p = new Productor("11", dep);

        c.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
        c10.start();
        c11.start();
        c12.start();
        c13.start();
        c14.start();
        c15.start();
        p.start();
    }
}
