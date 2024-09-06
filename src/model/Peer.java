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
        System.out.println(System.identityHashCode(connection));
        connection.sendDatagram(msj, ipDest, portDest);

    }
    public void hear(){

        System.out.println(this.name + " hearing");
        UDPConnection connection = UDPConnection.getInstance();
        System.out.println(System.identityHashCode(connection));
        connection.setPort(myPort);
        connection.start();

    }

    public static void main(String[]args){
        Peer peer1 = new Peer("gab",5000);
        // si o si debe escuchar primero
        //peer1.hear();

        peer1.send("holi","127.0.0.1",5001);







    }

}
