package model;
import util.UDPConnection;
public class Peer {
    String name;
    int myPort;

    public Peer(String name,int myPort){
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
        Peer peer1 = new Peer("gab",5000);
        peer1.send("holi","127.0.0.1",5001);
        peer1.hear();







    }

}
