public class Consumidor extends Thread{

    private int id;
    private Cola cola;
    private final int nv = 10;

    public Consumidor(Cola cola,int id){
        
        this.id=id;
        this.cola = cola;
    }

    @Override
    public void run(){

        for(int i =0; i<nv; i++){

            cola.getNum(id);

        }

    }
    
}
