import java.io.*;

public class ReadFile {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("sample.txt");
            int ch;

            System.out.println("File Content:");

            while((ch = fis.read()) != -1) {
                System.out.print((char)ch);
            }

            fis.close();
        }

        catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }
}