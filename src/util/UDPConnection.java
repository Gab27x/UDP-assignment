package util;

import java.io.IOException;
import java.net.*;


public class  UDPConnection extends Thread {

    private UDPConnection(){

    }

    private DatagramSocket socket;

    private static UDPConnection instance;

    public static UDPConnection getInstance(){
        if(instance == null){
            instance = new UDPConnection();
        }

        return  instance;
    }

    public void setPort(int port) {
        try{
            this.socket = new DatagramSocket(port);
        }catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run(){

        //reception
        try {
            // soket habilita el poder establecer conexiones con el puerto
            // Empaquetador de la informacion
            DatagramPacket packet = new DatagramPacket(new byte[16],16);
            System.out.println("Waiting ...");
            // recibir la informacion y almacenarla en el paquete
            this.socket.receive(packet);

            //
            String msj = new String(packet.getData()).trim();
            System.out.println(msj);
        }catch (IOException e){
            System.out.println(e.toString());
	} 
    }
}
