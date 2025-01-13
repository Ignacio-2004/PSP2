public class Consumidor2 extends Consumidor{

    public  Consumidor2(Cola cola,int id){
        super(cola,id);
    }

    @Override
    public void run(){

        for(int i =0; i<getNv(); i++){

            try {
                sleep(10000);
            } catch (InterruptedException e) {}

            getCola().getNum(getIdThread(),false);

        }

    }
    
}
