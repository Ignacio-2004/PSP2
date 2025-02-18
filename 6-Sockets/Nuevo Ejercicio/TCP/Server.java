import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        TCP tcp = new TCP();

        tcp.createServer();

        do{

            Socket s = tcp.waitConnection();
            tcp.UpdateInputs(s);
            tcp.UpdateOutputs(s);
            System.out.println("Conexion Realizada.");

            String msgip = tcp.read();
            if (!isCorrect(msgip)) {
                System.out.println("IP is not correct");
                tcp.write("Incorrect");
                s.close();
            }else{
                System.out.println("IP is correct.");
            }
            

            s.close();

        }while(true);
    }
    private static boolean isCorrect(String ip){
        
        String[] ipSplit = ip.split("\\.");

        if (ipSplit.length !=4) {
            return false;
        }

        try{
            for (int i = 0; i< ipSplit.length;i++){

                if (Integer.parseInt(ipSplit[i])>255||Integer.parseInt(ipSplit[i])<0){
                    return false;
                }
    
            }
        }catch(Exception e){
            return false;
        }

        return true;

    }
}