public class Camion extends Thread{
    
    String id;
    Deposito dep;

    public Camion(String id, Deposito dep){

        this.dep=dep;
        this.id=id;

    }

    @Override
    public void run(){

        for(int i=0; i<5;i++){
            dep.getFuel(id);
        }

    }

}
