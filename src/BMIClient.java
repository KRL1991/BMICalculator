import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BMIClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost",8000);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);


            while (true) {
                System.out.println("Enter weight: ");
                outputStream.writeUTF(scanner.nextLine());
                System.out.println("Enter height: ");
                outputStream.writeUTF(scanner.nextLine());

                outputStream.flush();
                System.out.println(inputStream.readUTF());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

