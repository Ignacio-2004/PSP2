public class Camion extends Thread{
    
    String id;
    Deposito dep;
    int litrosTotales;

    public Camion(String id, Deposito dep){

        this.dep=dep;
        this.id=id;
        this.litrosTotales = 0;

    }

    @Override
    public void run(){

        for(int i=0; i<1;i++){
            litrosTotales+=dep.getFuel(id);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }

        System.out.println("Camion("+id+") ha termiando de reostar y se retira. Carga total: "+litrosTotales);

    }

}
