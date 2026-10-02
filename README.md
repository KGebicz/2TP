# 2TP


```
// Napisz program, który:
// Pobiera od użytkownika liczbę ocen n.
// Tworzy tablicę int[] o rozmiarze n.
// Pobiera od użytkownika wszystkie oceny z zakresu 1–6.
// Oblicza:
// średnią ocen,
// sumę ocen,
// najwyższą ocenę,
// najniższą ocenę.
// Oblicza, ile razy wystąpiła każda ocena.
// Wyświetla wszystkie oceny w kolejności wprowadzenia.
// Wyświetla oceny od najwyższej do najniższej bez używania gotowych metod sortowania.
// Sprawdza, czy średnia jest większa lub równa 4.0.


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę ocen: ");
        int n = scanner.nextInt();

        int[] oceny = new int[n];

        int[] licznik = new int[7];

        int suma = 0;
        int najwyzsza = 1;
        int najnizsza = 6;

        for (int i = 0; i < n; i++) {
            int ocena;

            do {
                System.out.print("Podaj ocenę " + (i + 1) + " (1-6): ");
                ocena = scanner.nextInt();

                if (ocena < 1 || ocena > 6) {
                    System.out.println("Błąd! Ocena musi być z zakresu 1-6.");
                }

            } while (ocena < 1 || ocena > 6);

            oceny[i] = ocena;

            suma += ocena;

            if (ocena > najwyzsza) {
                najwyzsza = ocena;
            }

            if (ocena < najnizsza) {
                najnizsza = ocena;
            }

            licznik[ocena]++;
        }

        double srednia = (double) suma / n;

        System.out.println("\n--- WYNIKI ---");
        System.out.println("Suma ocen: " + suma);
        System.out.println("Średnia ocen: " + srednia);
        System.out.println("Najwyższa ocena: " + najwyzsza);
        System.out.println("Najniższa ocena: " + najnizsza);

        System.out.println("\nLiczba wystąpień ocen:");

        for (int i = 1; i <= 6; i++) {
            System.out.println("Ocena " + i + ": " + licznik[i] + " razy");
        }

        System.out.println("\nOceny w kolejności wprowadzenia:");

        for (int i = 0; i < n; i++) {
            System.out.print(oceny[i] + " ");
        }

        int[] posortowane = new int[n];

        for (int i = 0; i < n; i++) {
            posortowane[i] = oceny[i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {

                if (posortowane[j] < posortowane[j + 1]) {
                    int temp = posortowane[j];
                    posortowane[j] = posortowane[j + 1];
                    posortowane[j + 1] = temp;
                }
            }
        }

        System.out.println("\n\nOceny od najwyższej do najniższej:");

        for (int i = 0; i < n; i++) {
            System.out.print(posortowane[i] + " ");
        }

        System.out.println("\n\nSprawdzenie średniej:");

        if (srednia >= 4.0) {
            System.out.println("Średnia jest większa lub równa 4.0.");
        } else {
            System.out.println("Średnia jest mniejsza niż 4.0.");
        }

        scanner.close();
    }
}```
