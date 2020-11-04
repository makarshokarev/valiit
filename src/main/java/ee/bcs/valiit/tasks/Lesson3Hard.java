package ee.bcs.valiit.tasks;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

// Enne kui seda tegema hakkad tee ära Lesson 2 (välja arvatud ülesanded 6, 8, 9)
public class Lesson3Hard {
    public static void main(String[] args) {
        //System.out.println(evenFibonacci(10));
        //randomGame();

        morseCode("Hello World!");
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x

        int n0 = 0;
        int n1 = 1;
        int fib = 0;
        int paar = 0;

        for (int i = 0; i < x; i++) {
            fib = n0 + n1;
            n0 = n1;
            n1 = fib;
            //System.out.print(fib + " ");

            if (fib % 2 == 0) {
                paar += fib;
            }
        }

        return paar;
    }

    public static void randomGame() {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
        Random random = new Random();
        int i = random.nextInt(100);
        //System.out.println(i);

        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("You need to guess the number from 0 to 100. \nPlease insert the number: ");

        while(true) {
            int n = scanner.nextInt();
            if (n == i) {
                System.out.println("You guessed the number and spent for it " + count + " tries:");
                break;
            } else if (n < i) {
                System.out.println("The number is greater. Try again.\nInsert the number: ");
                count++;
            } else if (n > i) {
                System.out.println("The number is less. Try again.\nInsert the number: ");
                count++;
            }
        }
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -


        return "";
    }
}
