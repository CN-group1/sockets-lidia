import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPClient {
    public static void main(String[] args) {
        String serverHost = "100.122.92.96";
        int serverPort = 5005;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(serverHost);

            for (int i = 1; i <= 100; i++) {
                String message = "Mesaj UDP #" + i;
                byte[] buffer = message.getBytes(StandardCharsets.UTF_8);

                DatagramPacket packet = new DatagramPacket(
                        buffer,
                        buffer.length,
                        serverAddress,
                        serverPort
                );

                socket.send(packet);
                System.out.println("Sent: " + message);
            }

            System.out.println("Finished sending 100 UDP messages to " + serverHost + ":" + serverPort);
        } catch (IOException e) {
            System.err.println("UDP transmission failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
