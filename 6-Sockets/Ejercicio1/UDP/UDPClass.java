import java.io.IOException;
import java.net.*;

public class UDPClass {

    private int gate;
    private InetAddress ip;
    private DatagramSocket ss;

    /**
     * Default builder that use the gate 12345 and connect to localhost
     */
    public UDPClass() throws UnknownHostException {
        this(12350,InetAddress.getLocalHost());
    }

    /**
     * Builder where you can put the gate and ip that you want
     * @param gate the gate trough you are going to connect
     * @param ip the place you want to connect
     */
    public UDPClass(int gate, InetAddress ip) {
        this.gate = gate;
        this.ip = ip;
        this.ss = null;
    }

    /**
     * Create a server
     * @return true if the server was created   false if the server was already created
     */
    public boolean createServer() throws SocketException {
        if (ss == null){
            ss = new DatagramSocket(gate);
            return true;
        }
        return false;
    }

    /**
     * Close the actual server
     */
    public void closeServer(){
        if (ss != null){
            ss.close();
        }
        ss=null;
    }

    /**
     * Read through the server
     * @return the package the server received
     */
    public DatagramPacket readDatagram() throws IOException {
        byte[] bufer = new byte[1024];
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
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
        byte[] bufer = new byte[1024];
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        ds.receive(recibo);
        return recibo;
    }

    /**
     * Read through the server
     * @return the content the server received as a String
     */
    public String readString(DatagramSocket ds) throws IOException {
        DatagramPacket dp = this.readDatagram(ds);
        return new String(dp.getData());
    }

    /**
     * Create a socket
     * @return the DatagramSocket
     */
    public DatagramSocket createSocket() throws SocketException {
        return new DatagramSocket();
    }

    /**
     * Write in the socket the message
     * @param ds DatagramSocket
     * @param msg message
     */
    public void write(DatagramSocket ds,String msg) throws IOException {
        DatagramPacket sendMsg = new DatagramPacket(msg.getBytes(),msg.length(),ip,gate);
        ds.send(sendMsg);
    }
    /**
     * Write in the socket the message
     * @param ds DatagramSocket
     * @param msg message
     */
    public void write(DatagramSocket ds,DatagramPacket dp,String msg) throws IOException {
        DatagramPacket sendMsg = new DatagramPacket(msg.getBytes(),msg.length(),dp.getAddress(),dp.getPort());
        ds.send(sendMsg);
    }

    /**
     * Write the msg in a temporal socket
     * @param gate the gate of the destination
     * @param ip the ip of the destination
     * @param msg the message
     */
    public void write(int gate,InetAddress ip,String msg) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        DatagramPacket sendMsg = new DatagramPacket(msg.getBytes(),msg.length(),ip,gate);
        ds.send(sendMsg);
        ds.close();
    }

    public void setData(int gate,InetAddress ip){
        this.gate = gate;
        this.ip =ip;
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
}
