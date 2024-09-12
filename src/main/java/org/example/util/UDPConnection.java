package org.example.util;

import java.io.IOException;
import java.net.*;

public class UDPConnection extends Thread {

    public UDPConnection() {}

    public static UDPConnection instance;

    private DatagramSocket socket;

    public static synchronized UDPConnection getInstance() {
        if (instance == null) {
            instance = new UDPConnection();
        }

        return instance;
    }

    public void setPort(int port) {

        try {

            socket = new DatagramSocket(port);

        } catch (SocketException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public synchronized void run() {

        try {
            //Empaquetar la información
            DatagramPacket packet = new DatagramPacket(new byte[16],16);
            System.out.println("Waiting...");

            // recibir la informacion
            this.socket.receive(packet);
            String msj = new String(packet.getData()).trim();
            System.out.println(msj);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        socket.close();


    }

    public void sendDatagram(String msj,String ipDest, int portDest){

        new Thread(() -> {
            try{
                socket = new DatagramSocket();

                InetAddress ipAddress = InetAddress.getByName(ipDest);
                DatagramPacket packet = new DatagramPacket(msj.getBytes(),msj.length(),ipAddress,portDest);
                socket.send(packet);


            }catch(SocketException | UnknownHostException e){
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();





    }


}