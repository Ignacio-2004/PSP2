public class Consumidor extends Thread{

    private int id;
    private Cola cola;
    private boolean rPar;

    public Consumidor(Cola cola,int id,boolean rPar){
        
        this.id=id;
        this.cola = cola;
        this.rPar=rPar;
    }

    @Override
    public void run(){

        while (true) {
            cola.getNum(id,rPar);
        }

    }

    public int getIdThread() {
        return id;
    }

    public Cola getCola() {
        return cola;
    }

}
