package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Port du serveur
            System.out.println("Serveur démarré. Attente de connexions...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouvelle connexion depuis " + clientSocket.getInetAddress());

                // Générer un paquet aléatoire et l'envoyer au client
                PacketGenerator generator = new PacketGenerator();
                Packet randomPacket;
                randomPacket = generator.generateRandomPacket();
                System.out.println(randomPacket.toString());
                sendPacketToClient(clientSocket, randomPacket);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendPacketToClient(Socket clientSocket, Packet packet) {
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            byte[] packetBytes = PacketToByte.serialize(packet);
            outputStream.write(packetBytes);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
