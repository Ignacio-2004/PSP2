import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP {
    private int puerto;
    private String ip;

    private InputStream ips;
    private DataInputStream dips;
    private ObjectInputStream perEnt;

    private OutputStream ops;
    private DataOutputStream dops;
    private ObjectOutputStream perSal;


    private ServerSocket ss;

    /**
     * Default Builder conect to localhost through the gate 55555
     */
    public TCP(){
        this("localhost", 12345);
    }

    /**
     * Builder where you can put the ip an the gate you want
     * @param ip Ip of the server you want to conect
     * @param puerto The gate through you want to conect to the server
     */
    public TCP(String ip, int puerto){

        this.puerto = puerto;
        this.ip= ip;
        ss=null;
        ips=null;
        dips=null;
        ops=null;
        dops=null;
        perEnt=null;
        perSal = null;

    }

    /**
     * Method that create a server and wait until a client conect
     * @return the shocket conected qith the client
     */
    public void createServer() throws IOException{
        
        if (ss == null) {

            ss = new ServerSocket(puerto);

        }
        
    }

    /**
     * Method that close the server
    */
    public void closeServer() throws IOException{
        
        ss.close();
        ss = null;

    }

    /**
     * The server wait to a client
     * @return the connection
     */
    public Socket waitConnection() throws IOException{
        return ss.accept();
    }


    /**
     * Method that create a server whith the gate and ip that is in the class
     * @return the socket
     */
    public Socket createSocket() throws UnknownHostException, IOException{

        return new Socket(ip,puerto);

    }

    /**
     * Update the inputs to be raedy for reading
     * @param socket socket you want to read
     */
    public void UpdateInputs(Socket socket) throws IOException{

        ips = socket.getInputStream();
        dips = new DataInputStream(ips);

    }

    /**
     * Update the outputs to be rady for writing
     * @param socket the spcket you want to write
     */
    public void UpdateOutputs(Socket socket) throws IOException{

        ops = socket.getOutputStream();
        dops = new DataOutputStream(ops);

    }

    /**
     * Update the outpùt to be reafy for reviving an Object
     * @param socket socket you want to read
     */
    public void updateObjectInput(Socket socket) throws IOException{
        perEnt = new ObjectInputStream(socket.getInputStream());
    }
    
    /**
     * Update the output to be ready for sending an object
     * @param socket the spcket you want to write
     */
    public void updateObjectOutput(Socket socket) throws IOException{
        perSal = new ObjectOutputStream(socket.getOutputStream());
    }

    /**
     * Method that read from a socket
     * @return the content as a String
     */
    public String read() throws IOException{
        return dips.readUTF();
    }

    /**
     * Write an object into a socket
     * @param obj the object you want to send
     */
    public void writeObject(Object obj) throws IOException{
        perSal.writeObject(obj);
    }

    /**
     * Read s shocket to recive an Object
     * @return the Object 
     */
    public Object readObject() throws ClassNotFoundException, IOException{
        return perEnt.readObject();
    }

    /**
     * Method that write the msg you want in a socket
     * @param msg the info you want to send
     */
    public void write(String msg) throws IOException{
        
        dops.writeUTF(msg);
    }

    public String getIp(){
        return ip;
    }
    public int getGate(){
        return puerto;
    }
    public void setIp(String ip){
        this.ip=ip;
    }
    public void setGate(int gate){
        this.puerto=gate;
    }
    

}
