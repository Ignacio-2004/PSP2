public class CreadorClientes extends Thread{
    
    private final int NUM = 15;
    private Gestor gest;

    public CreadorClientes (Gestor gestor){
        gest=gestor;
    }

    @Override
    public void run (){

        for (int i = 1; i <= NUM ; i++){

            gest.generarCLiente(i);

        }

    }

}
