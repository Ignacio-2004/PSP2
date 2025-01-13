import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Deposito dep = new Deposito();

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(new Camion("01", dep));
        objects.add(new Camion("02", dep));
        objects.add(new Camion("03", dep));
        objects.add(new Productor("11", dep));

        for(Object o: objects){
            if (o instanceof Camion) {
                Camion c = (Camion) o;
                c.start();
            }else{
               Productor p = (Productor) o;
               p.start(); 
            }
        }
    }
}
