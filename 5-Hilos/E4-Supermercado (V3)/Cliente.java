public class Cliente extends Thread{

    private int id;
    private Cola cola;

    public Cliente(int id, Cola cola){
        this.id = id;
        this.cola = cola;
    }

    @Override
    public void run(){
        cola.pedirTicket(id);
    }

}