package model;
import util.UDPConnection;

public class Peer2 {
    String name;
    int myPort;

    public Peer2(String name, int myPort){
        this.name = name;
        this.myPort = myPort;

    }

    public void send(String msj , String ipDest, int portDest){
        System.out.println(this.name + " sending");
        UDPConnection connection = UDPConnection.getInstance();
        connection.sendDatagram(msj, ipDest, portDest);

    }
    public void hear(){

        System.out.println(this.name + " hearing");
        UDPConnection connection = UDPConnection.getInstance();
        connection.setPort(myPort);
        connection.start();

    }

    public static void main(String[]args){

        Peer2 peer2 = new Peer2("gab",5001);
        peer2.hear();

    }

}
