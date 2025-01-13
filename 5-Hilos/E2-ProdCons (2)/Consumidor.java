public class Consumidor extends Thread{

    private int id;
    private Cola cola;
    private final int nv = 3;

    public Consumidor(Cola cola,int id){
        
        this.id=id;
        this.cola = cola;
    }

    @Override
    public void run(){

        for(int i =0; i<nv; i++){

            try {
                sleep(10000);
            } catch (InterruptedException e) {}

            cola.getNum(id,true);

        }

    }

    public int getIdThread() {
        return id;
    }

    public Cola getCola() {
        return cola;
    }

    public int getNv() {
        return nv;
    }

}
