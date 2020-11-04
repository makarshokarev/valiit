package ee.bcs.valiit.tasks;

import java.util.Scanner;

public class Lesson1MathUtil {
    private String test;

    public Lesson1MathUtil(String test) {
        this.test = test;
    }

    public static void main(String[] args) {
        /* java.util.Scanner scanner = new java.util.Scanner(System.in);
        Lesson1MathUtil lesson1MathUtil1 = new Lesson1MathUtil("test");
        Lesson1MathUtil lesson1MathUtil2 = new Lesson1MathUtil("test2");
        lesson1MathUtil1.test();
        lesson1MathUtil2.test();

        int[][] twoArray = new int[3][4];
        */

         /*
         System.out.println(min(6, 3));
         System.out.println(max(6, 3));
         System.out.println(abs(-9));
         System.out.println(isEven(8));
         System.out.println(min(3, 5, 1));
         System.out.println(max(3, 5, 1));
          */

        /*
        System.out.println("Sisesta kaks täisarvu ja tagasta nendest väiksema");
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Esimene arv: ");
        int x = scanner1.nextInt();
        System.out.print("Teine arv: ");
        int y = scanner1.nextInt();
        int min;
        if (x<y){
            min = x;
        } else {
            min = y;
        }
        System.out.println("Väiksem arv: " + min);
         */

        /*
        System.out.println("Vali mis meetodi tahad käivitada: \n min2 \n max2 \n abs \n isEven \n min3 \n min3");
        Scanner scanner3 = new Scanner(System.in);
        String s = scanner3.nextLine();
        int a = 0;
        int b = 0;
        int c = 0;

        if (s.equals("min1") || s.equals("min2")){
            System.out.println("Sisesta kaks arvu: ");
            System.out.print("Esimene arv: ");
            a = scanner3.nextInt();
            System.out.print("Teine arv: ");
            b = scanner3.nextInt();
        } else if(s.equals("abs") || s.equals("isEven")){
            System.out.print("Sisesta suvaline arv: ");
            a = scanner3.nextInt();
        } else if (s.equals("min3") || s.equals("max3")){
            System.out.println("Sisesta kolm arvu: ");
            System.out.print("Esimene arv: ");
            a = scanner3.nextInt();
            System.out.print("Teine arv: ");
            b = scanner3.nextInt();
            System.out.print("Kolmas arv: ");
            c = scanner3.nextInt();
        }

        switch (s){
            case "min2":
                System.out.println("Väiksem arv on: " + min(a, b));
                break;

            case "max2":
                System.out.println("Suurim arv on: " + max(a, b));
                break;

            case "abs":
                System.out.println("Absoluut arv on: " + abs(a));
                break;

            case "isEven":
                if (isEven(a)){
                    System.out.println("Arv " + a + " on paaris arv");
                } else {
                    System.out.println("Arv " + b + " on paaritu arv");
                }
                break;

            case "min3":
                System.out.println("Väiksem arv on: " + min(a, b, c));
                break;

            case "max3":
                System.out.println("Väiksem arv on: " + max(a, b, c));
                break;

            default:
                System.out.println("Oooops, something wrong !");
        }
         */
    }

    public void test(){
        System.out.println(test);
    }

    public static int min(int a, int b) {
        // TODO tagasta a ja b väikseim väärtus

        return Math.min(a, b);
    }

    public static int max(int a, int b) {
        // TODO tagasta a ja b suurim väärtus

        return Math.max(a, b);

    }

    public static int abs(int a) {
        // TODO tagasta a absoluut arv

        return Math.abs(a);
    }

    public static boolean isEven(int a) {
        // TODO tagasta true, kui a on paaris arv
        // tagasta false kui a on paaritu arv
        int x = a % 2;

        if (x == 0){
            return true; }
        else
            return false;
    }

    public static int min(int a, int b, int c) {
        // TODO tagasta a, b ja c väikseim väärtus
        int min = 0;

        if (a < b && a < c){
            min = a;
        } else if (b < a && b < c){
            min = b;
        } else if (c < a && c < b)
            min = c;
        return min;
    }

    public static int max(int a, int b, int c) {
        // TODO tagasta a, b ja c suurim väärtus
        int max = 0;

        if (a > b && a > c){
            max = a;
        } else if (b > a && b > c){
            max = b;
        } else if (c > a && c > b)
            max = c;
        return max;

    }

}
