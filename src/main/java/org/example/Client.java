package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connecté au serveur.");

            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[37];

            while (true) {
                int bytesRead = inputStream.read(buffer);
                if (bytesRead == -1) {
                    break;
                }

                Packet receivedPacket = PacketFromByte.deserialize(buffer);
                System.out.println("Packet reçu : " + receivedPacket.toString());

            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
