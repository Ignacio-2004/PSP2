import java.io.*;
import java.net.*;

public class TCPClientSocket2  {
  public static void main(String[] args) throws Exception {

	InetAddress host = InetAddress.getByName("192.168.114.111");
	int Puerto = 7777;//puerto remoto	
	
	System.out.println("PROGRAMA CLIENTE INICIADO....");
	Socket Cliente = new Socket("192.168.1.243", Puerto);

	// Creación flujo de salida hacia el servidor
	DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

	
	flujoSalida.writeUTF("Nacho y Fancesco");

	// Creación flujo de entrada desde el servidor
	DataInputStream flujoEntrada = new  DataInputStream(Cliente.getInputStream());

	// 
	System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF());
	




	// CERRAR STREAMS Y SOCKETS	
	flujoEntrada.close();	
	flujoSalida.close();	
	Cliente.close();	
  }// main
}// 
