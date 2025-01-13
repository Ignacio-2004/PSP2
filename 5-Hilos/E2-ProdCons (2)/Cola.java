import java.util.LinkedList;

public class Cola {

    private LinkedList<Integer> nums;
    private final int  MAXSIZE = 1;
    private boolean isFull;
    private int sum;
    private int mult;
    private boolean isRead;

    public Cola(){
        
        nums =new LinkedList<>();
        isFull=false;
        sum = 0;
        mult=1;
        isRead = false;

    }

    public synchronized void addNum(int id){
        
        while (nums.size()==MAXSIZE) {

            try {
                wait();
            } catch (InterruptedException e) {}
            
        }

        int rn = random(1, 10);

        nums.add(rn);

        notifyAll(); //Para que spiert a toos

        System.out.println("Productor: "+id+" he escrito: "+rn);
        
    }

    public synchronized void getNum(int id,boolean isSum){
        
        while (nums.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        if (isSum){
            
            sum += nums.get(0);
            System.out.println("Consumidor: "+id+" he leido: "+nums.get(0)+" la suma es: "+sum);

        }else{

            mult *= nums.get(0);
            System.out.println("Consumidor: "+id+" he leido: "+nums.get(0)+" la multiplicacion es: "+mult);

        }

        if (!isRead) {
        
            isRead = true;
            try {
                notifyAll();
                wait();
            } catch (InterruptedException e) {}
        
        }else{
            notifyAll();
            nums.remove(0);
            isRead = false;
        }

    }

    private static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    
}
