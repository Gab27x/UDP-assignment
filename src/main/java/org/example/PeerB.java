package org.example;
import org.example.interfaces.Receiver;
import org.example.interfaces.Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PeerB implements Receiver, Sender {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PeerB peerB = new PeerB();
        int port, portDest;
        String ipDest;

        System.out.println("Ingrese el puerto de escucha");
        try {
            port = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Ingrese el puerto de destino");
        try {
            portDest = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ingrese la dirección IP de destino");
        try {
            ipDest = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String msj;
        System.out.println("Envias y despues escuchas");

        try {
            msj = reader.readLine();
            peerB.send(msj, ipDest, portDest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        peerB.hear(port);




    }
    /*public static void main(String[] args)throws IOException {
        var socket = new DatagramSocket(6002);
        var msg = "Hola mundo";
        var datagram = new DatagramPacket(
                msg.getBytes(),
                msg.getBytes().length,
                InetAddress.getByName("127.0.0.1"),
                6001);
        socket.send(datagram);
    }*/
}
