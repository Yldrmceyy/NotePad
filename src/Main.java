import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a File object for the file named "data.txt"
            File file = new File("src/notepad.txt");

            // Check if the file exists
            if (!file.exists()) {
                file.createNewFile();
                System.out.println(file.getName() + " file created.");
            } else {
                System.out.println(file.getName() + " file already exists!");
            }

            // Create a FileWriter to write to the file, and a BufferedWriter for efficiency
            FileWriter fWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Bir Metin Giriniz: ");
            String text = scanner.nextLine();
            bWriter.write(text);bWriter.newLine();
            System.out.println("Your text has been added successfully");
            bWriter.close();

            // Create a FileReader to read from the file, and a BufferedReader for efficiency
            FileReader fReader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(fReader);
            String yourText;
            while ((yourText = bReader.readLine()) != null){
                System.out.println(yourText);
            }
            bReader.close();


        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
