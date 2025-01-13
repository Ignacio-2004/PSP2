import java.util.ArrayList;

public class Cola {

    private ArrayList<Integer>nums;
    private final int  MAXSIZE = 5;
    private boolean isFull;
    private int sum; 

    public Cola(){
        
        nums =new ArrayList<Integer>();
        isFull=false;
        sum = 0;

    }

    public synchronized void addNum(int id){
        
        while (isFull) {

            try {
                wait();
            } catch (InterruptedException e) {}
            
        }

        int rn = random(0, 100);

        nums.add(rn);

        notify();

        if (nums.size()==MAXSIZE) {
            isFull=true;
        }

        System.out.println("Productor: "+id+" he escrito: "+rn);
        
    }

    public synchronized void getNum(int id){
        
        while (nums.isEmpty()) {
            try {
                notify();
                wait();
            } catch (InterruptedException e) {}
        }

        if (nums.size()!=MAXSIZE) {
            isFull=false;
        }

        sum += nums.get(0);

        System.out.println("Consumidor: "+id+" he leido: "+nums.get(0)+" la suma es: "+sum);

        nums.remove(0);

    }

    private static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    
}
