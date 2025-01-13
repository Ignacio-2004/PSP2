public class Productor extends Thread{
    
    String id;
    Deposito dep;

    public Productor(String id,Deposito dep){
        this.id=id; 
        this.dep=dep;
    }

    @Override
    public void run(){
        for (int i=0; i< 15;i++){
            dep.setFuel(id);
        }
    }

}
