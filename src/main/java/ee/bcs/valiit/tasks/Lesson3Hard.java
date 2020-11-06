package ee.bcs.valiit.tasks;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

// Enne kui seda tegema hakkad tee ära Lesson 2 (välja arvatud ülesanded 6, 8, 9)
public class Lesson3Hard {
    public static void main(String[] args) {
        //System.out.println(evenFibonacci(10));
        //randomGame();

        //System.out.println(morseCode("hello world"));


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

        while (true) {
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

        Map<String, String> morse = new HashMap<String, String>();
        morse.put("a", ".-");
        morse.put("b", "-...");
        morse.put("c", "-.-.");
        morse.put("d", "-..");
        morse.put("e", ".");
        morse.put("f", "..-.");
        morse.put("g", "--.");
        morse.put("h", "....");
        morse.put("i", "..");
        morse.put("j", ".---");
        morse.put("k", "-.-");
        morse.put("l", ".-..");
        morse.put("m", "--");
        morse.put("n", "-.");
        morse.put("o", "---");
        morse.put("p", ".--.");
        morse.put("q", "--.-");
        morse.put("r", ".-.");
        morse.put("s", "...");
        morse.put("t", "-");
        morse.put("u", "..-");
        morse.put("v", "...-");
        morse.put("w", ".--");
        morse.put("x", "-..-");
        morse.put("y", "-.--");
        morse.put("z", "--..");

        morse.put("1", ".----");
        morse.put("2", "..---");
        morse.put("3", "...--");
        morse.put("4", "....-");
        morse.put("5", ".....");
        morse.put("6", "-....");
        morse.put("7", "--...");
        morse.put("8", "---..");
        morse.put("9", "----.");
        morse.put("0", "-----");

        StringBuilder code = new StringBuilder();

        String[] words = text.split(" ");
        for (String word : words) {
            String[] letters = word.split("");
            for (String letter : letters) {
                code.append(morse.get(letter));
                code.append(" ");
            }
            code.append("||");
        }

        String s = code.toString();

        return s;
    }
}
