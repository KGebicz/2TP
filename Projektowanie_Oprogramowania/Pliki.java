import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pliki {

    public static void main(String[] args) throws IOException {

        String nazwaPliku = "przyklad.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPliku, false));
        writer.write("To jest pierwsza linia tekstu.");
        writer.newLine();
        writer.write("To jest druga linia tekstu.");
        writer.newLine();
        writer.close();
        
        writer = new BufferedWriter(new FileWriter(nazwaPliku, true));
        writer.write("To jest linia dopisana na końcu pliku.");
        writer.newLine();
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader(nazwaPliku));
        String linia;

        System.out.println("Zawartość pliku:");

        while ((linia = reader.readLine()) != null) {
            System.out.println(linia);
        }

        reader.close();
        
    }
}
