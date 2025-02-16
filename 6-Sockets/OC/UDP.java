import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class UDP {

    private int gate;
    private InetAddress ip;
    private DatagramSocket ss;
    private DatagramPacket recibo;
    private DatagramPacket sendMsg;
    private byte[] bufer;
    private ByteArrayOutputStream byteStream;
    private ObjectOutputStream objectStream;
    private byte[] sendData;

    /**
     * Default builder that use the gate 12345 and connect to localhost
     */
    public UDP() throws IOException {
        this(12350,InetAddress.getLocalHost());
    }

    /**
     * Builder where you can put the gate and ip that you want
     * @param gate the gate trough you are going to connect
     * @param ip the place you want to connect
    */
    public UDP(int gate, InetAddress ip) throws IOException {
        this.gate = gate;
        this.ip = ip;
        this.ss = null;
        this.bufer= new byte[1024];
        recibo=null;
        sendMsg=null;
        byteStream = new ByteArrayOutputStream();
        objectStream = new ObjectOutputStream(byteStream);
    }

    /**
     * Create a server
     * @return true if the server was created   false if the server was already created
     */
    public void createServer() throws SocketException {
        if (ss == null){
            ss = new DatagramSocket(gate);
        }
    }

     /**
     * Close the actual server
     */
    public void closeServer(){
        ss.close();
        ss=null;
    }

    /**
     * Create a socket
     * @return the DatagramSocket
     */
    public DatagramSocket createSocket() throws SocketException {
        return new DatagramSocket();
    }

    /**
     * Prepare a Package for reciving
     */
    public void preparePackage(){
        recibo = new DatagramPacket(bufer, bufer.length);
    }

    /**
     * Prepare a Package for send
     * @param msg message
     * @param ip the ip of the destinatary
     * @param gate the gate of the destnatary
     */
    public void preparePackage(String msg,InetAddress ip,int gate){
        sendMsg = new DatagramPacket(msg.getBytes(),msg.length(),ip,gate);
    }

    /**
     * Prepare a Package for answering 
     * @param msg message
     * @param dp the DatagramPacake you want to answer
     */
    public void preparePackage(String msg,DatagramPacket dp){
        sendMsg = new DatagramPacket(msg.getBytes(),msg.length(),dp.getAddress(),dp.getPort());
    }

        /**
     * Prepare an Object for answering
     * @param obj The obj
     * @param dp the DatagramPackage to answer
     */
    public void preparePackage(Object obj,DatagramPacket dp) throws IOException{
        objectStream.writeObject(obj);
        sendData = byteStream.toByteArray();
        sendMsg = new DatagramPacket(sendData, sendData.length, dp.getAddress, dp.getGate);

    }

    /**
     * * Prepare a Package to send an object
     * @param obj the object
     * @param ip the ip to send
     * @param gate the gate to send
     * @throws IOException
     */
    public void preparePackage(Object obj,InetAddress ip, int gate) throws IOException{
        objectStream.writeObject(obj);
        sendData = byteStream.toByteArray();
        sendMsg = new DatagramPacket(sendData, sendData.length, ip, gate);
    }

    /**
     * Write in the socket the message
     * @param ds DatagramSocket
     */
    public void write(DatagramSocket ds) throws IOException {
        ds.send(sendMsg);
    }

    /**
     * Read through the server
     * @return the package the server received
     */
    public DatagramPacket readDatagram() throws IOException {
        ss.receive(recibo);
        return recibo;
    }

    /**
     * Read through the server
     * @return the content the server received as a String
     */
    public String readString() throws IOException {
        DatagramPacket dp = this.readDatagram();
        return new String(dp.getData()).trim();
    }

    /**
     * Read through the server
     * @return the package the server received
     */
    public DatagramPacket readDatagram(DatagramSocket ds) throws IOException {
        ds.receive(recibo);
        return recibo;
    }

    /**
     * Read an Object of the socket
     * @return Object
     */
    public Object readObject() throws IOException, ClassNotFoundException{
        DatagramPacket dp = this.readDatagram();
        ByteArrayInputStream byteStream = new ByteArrayInputStream(dp.getData());
        ObjectInputStream objectStream = new ObjectInputStream(byteStream);

        return objectStream.readObject();
    }

    public Object readObject(DatagramSocket ds) throws IOException, ClassNotFoundException{
        DatagramPacket dp = this.readDatagram(ds);
        ByteArrayInputStream byteStream = new ByteArrayInputStream(dp.getData());
        ObjectInputStream objectStream = new ObjectInputStream(byteStream);

        return objectStream.readObject();
    }

    /**
     * Read through the server
     * @return the content the server received as a String
     */
    public String readString(DatagramSocket ds) throws IOException {
        DatagramPacket dp = this.readDatagram(ds);
        return new String(dp.getData());
    }

    public int getGate() {
        return gate;
    }
    public InetAddress getIp() {
        return ip;
    }
    public DatagramSocket getSs() {
        return ss;
    }
    public void setGate(int gate){
        this.gate = gate;
    }
    public void setIp(InetAddress ip){
        this.ip = ip;
    }
}
