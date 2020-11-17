package fibonacciv2;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciV2 {

    private static boolean isNotFibboNmbr = false;
    private static long start;
    private static long finish;
    private static long timeElapsed;
    private static int schritte;

    public static void fibboCalc(BigInteger nextBestNumber) {
        boolean compare = true, fibboInit = false;
        BigInteger f1;
        BigInteger f2;
        BigInteger result;
        
        BigInteger[] fibboArray = new BigInteger[101];
        
        fibboArray[100] = nextBestNumber;
        int start, median, last;

        if (nextBestNumber.compareTo(BigInteger.ZERO) == 0) {
            compare = false;
        }
        for (int x = 0; x < 100; x++) {
            f1 = BigInteger.ZERO;
            f2 = BigInteger.ONE;
            result = BigInteger.ONE;
            start = 0;
            last = 100;
            fibboInit = false;
            schritte = 0;

            for (int i = 0; i < 100; i++) {

                if (compare == false) {
                    System.out.println(i + 1 + ": " + result);
                }
                fibboArray[i] = result;
                result = f1.add(f2);
                if (i == 99) {
                    fibboInit = true;
                }
                if (f1.compareTo(f2) == -1) {

                    f1 = result;
                } else {

                    f2 = result;
                }
                if (fibboInit == true && compare == true) {
                    quicksort(fibboArray, start, last);
                    isNotFibboNmbr = false;
                }

            }
        }

    }

    public static int quicksort(BigInteger fibboArray[], int first, int last) {
        int result = 0;
        int median = (first + last) / 2;
        int distance = last - first;

        if (isNotFibboNmbr == false) {
            if (distance == 1) {
                isNotFibboNmbr = true;

                BigInteger firstDistance = fibboArray[first];
                BigInteger lastDistance = fibboArray[last];
                firstDistance = fibboArray[100].subtract(firstDistance);
                System.out.println("first: " + firstDistance);
                lastDistance = lastDistance.subtract(fibboArray[100]);
                System.out.println("last: " + lastDistance);

                if (firstDistance.compareTo(lastDistance) == 1) {
                    schritte++;
                    System.out.println("Index: " + last + " Fibbonummer: " + fibboArray[last] + " ist näher an " + fibboArray[100] + " hat " + schritte + " schritte gebraucht.");
                } else {
                    schritte++;
                    System.out.println("Index: " + first + " Fibbonummer: " + fibboArray[first] + " ist näher an " + fibboArray[100] + " hat " + schritte + " schritte gebraucht.");

                }

            }
            if (fibboArray[100].compareTo(fibboArray[median]) == 1) {
                schritte++;
                result = quicksort(fibboArray, median, last);

            }
            if (fibboArray[100].compareTo(fibboArray[median]) == -1) {
                schritte++;
                result = quicksort(fibboArray, first, median);

            }
            if (fibboArray[100].compareTo(fibboArray[median]) == 0) {
                schritte++;
                System.out.println(fibboArray[100] + " steht gleich mit Index: " + median + " Fibbonummer: " + fibboArray[median] + " hat " + schritte + " schritte gebraucht.");

            }

        }

        return result;
    }

    public static BigInteger nextBestNumber() {

        boolean inputSuccess = false;
        BigInteger nextBestNumber = null;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Wenn sie die gesammte Fibonacci Reihe ausgegeben haben wollen, drücken sie bitte F.");
        System.out.println("Wenn sie nach der nächstgelegenen Fibonacci-Zahl suchen, drücken sie bitte N");
        String menu = userInput.nextLine();
        while (inputSuccess == false) {
            if (menu.equals("F")) {
                inputSuccess = true;
                nextBestNumber = BigInteger.ZERO;
                start = System.nanoTime();
            }
            if (menu.equals("N")) {
                System.out.println("Bitte geben sie eine Zahl ein.");
                nextBestNumber = new BigInteger(userInput.nextLine());
                start = System.nanoTime();
                inputSuccess = true;
            }
            if (inputSuccess == false) {
                System.out.println("Bitte geben sie entweder F oder N ein.");
                menu = userInput.nextLine();
            }
        }
        return nextBestNumber;
    }

    public static void main(String[] args) {

        fibboCalc(nextBestNumber());
        finish = System.nanoTime();
        timeElapsed = finish - start;
        double seconds = (double) timeElapsed / 1_000_000_000.0;
        double milliseconds = (double) timeElapsed / 1_000_000.0;

        System.out.println(milliseconds + " Millisekunden oder " + seconds + " Sekunden");
    }

}
