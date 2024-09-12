package org.example;

import org.example.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Objects;
import java.util.Scanner;


public class PeerA implements Receiver, Sender {


    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PeerA peerA = new PeerA();
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
        System.out.println("Primero escuchas y despues envias");

        peerA.hear(port);


        try {
            msj = reader.readLine();
            peerA.send(msj, ipDest, portDest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }














    }


}