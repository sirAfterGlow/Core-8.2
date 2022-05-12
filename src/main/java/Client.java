import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        final String host = "netology.homework";
        final int port = 8989;

        System.out.println("Клиент запущен");
        System.out.println("Для начала взаимодействия с сервером введите try");
        System.out.println("Для завершения end");
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out =
                     new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in =
                     new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            while (true) {

                String input = scanner.nextLine();

                out.println(input);

                String responce = in.readLine();
                System.out.println(responce);

            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}