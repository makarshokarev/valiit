package ee.bcs.valiit.tasks.lessons;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) throws FileNotFoundException {
        /*
        System.out.println("Input two numbers: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        exercise5(n, m);
        System.out.print(n + " " + m + " " + exercise5(n, m));

         */
        exercise3(7,7);

    }

    public static void exercise1() {
        // TODO loo 10 elemendile täisarvude massiv
        // TODO loe sisse konsoolist 10 täisarvu
        // TODO trüki arvud välja vastupidises järiekorras

        int[] array = new int[10];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            int x = scanner.nextInt();
            array[i] = x;
        }

        for (int i = 10; i > 0; i--) {
            System.out.println(array[i - 1]);
        }

    }

    public static void exercise2(int x) {
        // TODO prindi välja x esimest paaris arvu
        // Näide:
        // Sisend 5
        // Väljund 2 4 6 8 10
        int y = 0;

        for (int i = 0; i < x; i++) {
            y = y + 2;
            System.out.println(y);
        }
    }

    public static void exercise3(int x, int y) {
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
        // TODO näiteks x = 3 y = 3
        // TODO väljund
        // 1 2 3
        // 2 4 6
        // 3 6 9
        int[][] array = new int[x][y];

        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                System.out.print((array[row][column] = (row + 1) * (column + 1)) + " ");
            }
            System.out.println("");
        }
    }

    public static int fibonacci(int n) {
        // TODO
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element

        int n0 = 0;
        int n1 = 1;
        int fib = 0;

        for (int i = 0; i < n; i++) {
            fib = n0 + n1;
            n0 = n1;
            n1 = fib;
        }
        return n1;
    }

    public static int exercise5(int i, int j) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        int max = 0;

        for (int n = i; n <= j; n++) {
            int count = problem(n);
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static int problem(int n) {
        int count = 1;
        while (n != 1) {
            if ((n % 2) != 0) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
            count++;
        }
        return count;
    }


    public static void exercise6() throws FileNotFoundException {
        /*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.
         */
        List<Line> visits = new ArrayList<>();
        File file = new File("visits.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().split(", ");
            Line newLine = new Line(tokens[0], Integer.parseInt(tokens[1]));
            visits.add(newLine);
        }

        visits.sort(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.visits - o2.visits;
            }
        });

        for (Line line :visits){
            System.out.println(line.date + " " + line.visits);
        }
    }

    public static class Line {
        private String date;
        private int visits;

        public Line(String date, int visits){
            this.date = date;
            this.visits = visits;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getVisits() {
            return visits;
        }

        public void setVisits(int visits) {
            this.visits = visits;
        }
    }


    public static void exercise7() {
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820340 / 15 ) - 4 )
        BigDecimal a = new BigDecimal("1.89");
        BigDecimal b = new BigDecimal("394486820340");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");

        BigDecimal x = b.divide(c);
        BigDecimal y = x.subtract(d);
        BigDecimal z = a.multiply(y);

        System.out.println(z);

        System.out.println(b.divide(c, 4, RoundingMode.HALF_UP));
    }

    public static void exercise8() throws FileNotFoundException {
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.

        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.

        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */
        List<String> list = new ArrayList<>();
        File file = new File("nums.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            list.add(s);
        }

        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < list.size(); i++){
            BigDecimal x = new BigDecimal(list.get(i));
            sum = sum.add(x);
        }

        System.out.println(sum);
    }

    public static void exercise9() throws FileNotFoundException {
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
        List <String> nums= new ArrayList<>();
        File file = new File("nums.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            nums.add(s);
        }

        for (String list : nums){
            System.out.println(list);
        }

    }

}
