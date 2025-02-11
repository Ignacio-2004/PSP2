import java.io.*;
import java.net.*;

public class UDPObjetoServidor11 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            
          
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                ByteArrayInputStream byteStream = new ByteArrayInputStream(receivePacket.getData());
                ObjectInputStream objectStream = new ObjectInputStream(byteStream);
                Object receivedObject = objectStream.readObject();
                
          	  Persona personaRecibida = (Persona) receivedObject;
          	   
                
                // Procesar el objeto recibido
                System.out.println("Mensaje recibido del cliente: " + receivedObject.toString());
                System.out.println("Recibido: " + personaRecibida.getNombre() + "*" + personaRecibida.getEdad());
                
                  } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

