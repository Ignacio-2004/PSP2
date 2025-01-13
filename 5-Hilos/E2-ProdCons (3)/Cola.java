import java.util.LinkedList;

public class Cola {

    private LinkedList<Integer> nums;
    private final int  MAXSIZE = 5;
    private boolean isFull;
    private int sumP;
    private int sumI;

    public Cola(){
        
        nums =new LinkedList<>();
        isFull=false;
        sumI = 0;
        sumP = 0 ;

    }

    public synchronized void addNum(int id){
        
        while (isFull) {

            try {
                wait();
            } catch (InterruptedException e) {}
            
        }

        int rn = random(1, 10);

        nums.add(rn);

        notify();

        if (nums.size()==MAXSIZE) {
            isFull=true;
        }

        System.out.println("Productor: "+id+" he escrito: "+rn);
        
    }

    public synchronized void getNum(int id,boolean rPar){
        
        while (nums.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        if (nums.size()!=MAXSIZE) {
            isFull=false;
        }

        if (nums.get(0)%2==0 && rPar) {
            sumP+=nums.get(0);
            System.out.println("Consumidor: "+id+" he leido: "+nums.get(0)+" la suma es: "+sumP);
            nums.remove(0);
        } else if (nums.get(0) % 2 != 0 && !rPar){
            sumI+=nums.get(0);
            System.out.println("Consumidor: "+id+" he leido: "+nums.get(0)+" la suma es: "+sumI);
            nums.remove(0);
        }

        notify();
        
    }

    private static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    
}
