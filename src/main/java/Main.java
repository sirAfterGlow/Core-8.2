import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        final int port = 8989;

        String clientName = "defaultName";

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("Сервер запущен");
            while (true) {

                final String intputMessage = in.readLine();

                if (intputMessage.equals("try")) {
                    System.out.println("Установленно новое соединение");
                    out.println("Введите Ваше имя в формате \"name:имя\"");
                } else if (intputMessage.startsWith("name:")) {
                    System.out.println("Получено имя");
                    clientName = intputMessage.substring(5);
                    out.println("Вам исполнилось 18 лет? (yes/no)");
                } else if (intputMessage.equals("yes")) {
                    System.out.println("Отправлено приглашение взрослому");
                    out.println("Добро пожаловать в пристанище взрослых, " + clientName + "! Хорошего отдыха!");
                } else if (intputMessage.equals("no")) {
                    System.out.println("Отправлено приглашение ребенку");
                    out.println("Привет, " + clientName + "! Рады видеть тебя на секретной базе, пошли играть!");
                }

            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
