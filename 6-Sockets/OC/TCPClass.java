import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClass {
    
    private int puerto;
    private String ip;

    private  InputStream ips;
    private  DataInputStream dips;
    private  OutputStream ops;
    private  DataOutputStream dops;

    private ServerSocket ss;

    /**
     * Default Builder conect to localhost through the gate 55555
     */
    public TCPClass(){
        puerto = 55555;
        ip = "localhost";
        ips = null;
        dips = null;
        ops = null;
        dops = null;
        ss = null;
    }

    /**
     * Builder where you can put the ip an the gate you want
     * @param ip Ip of the server you want to conect
     * @param puerto The gate through you want to conect to the server
     */
    public TCPClass(String ip, int puerto){

        this();
        this.puerto = puerto;
        this.ip= ip;

    }

    /**
     * Method that create a server and wait until a client conect
     * @return the shocket conected qith the client
     */
    public Socket createServer() throws IOException{
        
        if (ss == null) {

            ss = new ServerSocket(puerto);

        }
        return ss.accept();
    }

    /**
     * Method that close the server
     * @throws IOException
     */
    public void closeServer() throws IOException{

        ss.close();
        ss = null;

    }

    public Socket creaSocket(){

        return 

    }

    public String getIp(){return ip;}
    public int getGate(){return puerto;}
    public void setData(String ip, int puerto){
        this.puerto = puerto;
        this.ip = ip;
    }

}
