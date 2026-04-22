import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient {
    public static void main(String[] args) {

        String serverHost = "100.122.92.96";
        int serverPort = 5005;

        String message = "Salut de la clientul Java!";

        try (Socket socket = new Socket(serverHost, serverPort);
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {

            writer.write(message);
            writer.newLine();
            writer.flush();

            System.out.println("Connected to " + serverHost + ":" + serverPort);
            System.out.println("Message sent: " + message);

        } catch (IOException e) {
            System.err.println("TCP connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}