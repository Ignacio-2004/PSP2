import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClass {
    
    private int puerto;
    private String ip;

    private ServerSocket ss;

    /**
     * Default Builder conect to localhost through the gate 55555
     */
    public TCPClass(){
        puerto = 55556;
        ip = "localhost";
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
    */
    public void closeServer() throws IOException{
        
        ss.close();
        ss = null;

    }

    /**
     * Method that create a server whith the gate and ip that is in the class
     * @return the socket
     */
    public Socket creaSocket() throws UnknownHostException, IOException{

        return new Socket(ip,puerto);

    }

    /**
     * Method that read from a socket
     * @param socket the socket you want to read
     * @return the content as a String
     */
    public String read(Socket socket) throws IOException{

        InputStream ips;
        DataInputStream dips;

        ips = socket.getInputStream();
        dips = new DataInputStream(ips);

        return dips.readUTF();

    }

    /**
     * Method that write the msg you want in a socket
     * @param socket the socket in wich you want to send the info
     * @param msg the info you want to send
     */
    public void write(Socket socket,String msg) throws IOException{

        OutputStream ops;
        DataOutputStream dops;

        ops = socket.getOutputStream();
        dops = new DataOutputStream(ops);
        
        dops.writeUTF(msg);
    }

    public String getIp(){return ip;}
    public int getGate(){return puerto;}
    public void setData(String ip, int puerto){
        this.puerto = puerto;
        this.ip = ip;
    }

}
