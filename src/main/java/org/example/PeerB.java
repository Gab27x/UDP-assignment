package org.example;
import org.example.interfaces.Receiver;
import org.example.interfaces.Sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PeerB implements Receiver, Sender {

    public static void main(String[] args) {
        PeerB peerB = new PeerB();
        peerB.send("Hola desde PeerB", "127.0.0.1", 5000);

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
