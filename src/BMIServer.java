import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BMIServer {

    public static void main(String[] args) {

        double bmi;

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Accepting connection on port: 8000");

            Socket socket = serverSocket.accept();

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());


            while (true) {

                String weight = inputStream.readUTF();
                String height = inputStream.readUTF();
                System.out.println("Weight data from client: " + weight);
                System.out.println("Height data from client: " + height);

                bmi = Double.parseDouble(weight) / Math.pow(Double.parseDouble(height), 2);
                outputStream.writeUTF("The BMI is: " + bmi);
                outputStream.flush();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


