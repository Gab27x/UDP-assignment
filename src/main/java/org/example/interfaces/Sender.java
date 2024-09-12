package org.example.interfaces;
import org.example.util.UDPConnection;
public interface Sender {
    default void send(String msj, String ipDest, int portDest) {
        UDPConnection connection = UDPConnection.getInstance();
        connection.sendDatagram(msj, ipDest, portDest);


    }
}