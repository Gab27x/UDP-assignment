package org.example.interfaces;

import org.example.util.UDPConnection;

public interface Receiver {
    default void hear(int port) {
        UDPConnection connection = UDPConnection.getInstance();
        connection.setPort(port);
        connection.start();
    }


}