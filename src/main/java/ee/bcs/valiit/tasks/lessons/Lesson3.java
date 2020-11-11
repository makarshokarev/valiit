package ee.bcs.valiit.tasks.lessons;

import java.util.*;

public class Lesson3 {

    public static void main(String[] args) {

//        List<Integer> testList = new ArrayList<>();
//        testList.add(4);
//        testList.add(5);
//        testList.add(6);
//        Arrays.toString(new int[0]);
//        for (Integer i : testList) {
//            System.out.println(i);
//        }
//
//        System.out.print(testList);
//
//        System.out.println(reverseString("Test1 Test2"));
//        Map<String, String> testMap = new HashMap<>();
//        test(testMap);
//        Object a;
        //int[] array = {2, 6, 8, 1, 3, 9, 10, 21, 45, 1};
        //System.out.println(sum(array));
        //System.out.println(factorial(4));
        //System.out.println(Arrays.toString(sort(array)));

        System.out.println(isPrime(6));
        System.out.println(11 / 2);

    }

    private static void test(Map<String, String> testMap) {
        testMap.put("test", "test");
    }

    public static int uusSumma(int x, int y) {
        // TODO liida kokku ja tagasta x ja y väärtus
        int sum = x + y;
        return sum;
    }

    public static int sum(int[] x) {
        // Todo liida kokku kõik numbrid massivis x
//        System.out.println("Tere");
//        Scanner scanner = new Scanner(System.in);
//        scanner.hasNext();
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 4;
        // return 4*3*2*1 = 24

        int fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi
        // Näiteks {2, 6, 8, 1}
        // Väljund {1, 2, 6, 8}

        int n = a.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[j - 1] < a[j]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        // Näiteks:
        // a = "Test";
        // return tseT";
//        System.out.println(a.substring(0, 1));
//        System.out.println(a.substring(1, 2));
//        System.out.println(a.substring(2, 3));
//        System.out.println(a.substring(3, 4));
//        System.out.println(a.substring(2, 4));
//        System.out.println(a.substring(2));
//        System.out.println(array[0]);
//        System.out.println(array[1]);
//        System.out.println(a.indexOf("2"));

        String[] array = a.split("");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);
        }
        return "";
    }

    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)

        int temp = 0;
        boolean prime = true;

        for (int i = 2; i <= x / 2; i++) {
            temp = x % i;
            if (temp == 0) {
                prime = false;
                break;
            }
        }

        return prime;
    }

}
