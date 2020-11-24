/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.draeger.fibonacci.service.impl;

import com.draeger.fibonacci.service.FibonacciService;
import java.math.BigInteger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class FibonacciServiceImpl implements FibonacciService {

    private static boolean isNotFibboNmbr = false;

    private static long startTimerForEverything;
    private static long finishTimerForEverything;
    private static long timeElapsedForEverything;

    private static long startTimerForQuicksort;
    private static long finishTimerForQuicksort;
    private static long timeElapsedForQuicksort;
    private static double secondsForQuicksortTotal;
    private static double millisecondsForQuicksortTotal;

    private static long startTimerForLinearSearch;
    private static long finishTimerForLinearSearch;
    private static long timeElapsedForLinearSearch;
    private static double secondsForLinearSearchTotal;
    private static double millisecondsForLinearSearchTotal;

    private static int schritte;

    private static String searchNumberFound = "";
    private static String timeNeeded = "";

    @Override
    public String getTimeNeeded() {
        return timeNeeded;
    }

    @Override
    public void setTimeNeeded(String timeNeeded) {
        FibonacciServiceImpl.timeNeeded = timeNeeded;
    }

    @Override
    public String getSearchNumberFound() {
        return searchNumberFound;
    }

    @Override
    public void setSearchNumberFound(String searchNumberFound) {
        FibonacciServiceImpl.searchNumberFound = searchNumberFound;
    }

    @Override
    public BigInteger[] fibboCalc(BigInteger nextBestNumber, int anzahlFibonaccis, boolean isComparingQuicksortAndLinearSearch, boolean laufzeitTest) {
        boolean compare = true;
        BigInteger f1 = BigInteger.ZERO;
        BigInteger f2 = BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        BigInteger[] fibboArray = new BigInteger[anzahlFibonaccis];
        setTimeNeeded("");
        /*        for (int y = 0; y < 3; ++y) {
        if (isComparingQuicksortAndLinearSearch == false) {
        fibboArray = new BigInteger[100];
        
        arrayLength = fibboArray.length;
        y = 4;
        }
        if (y == 0) {
        fibboArray = new BigInteger[100];
        
        arrayLength = fibboArray.length;
        }
        if (y == 1) {
        fibboArray = null;
        fibboArray = new BigInteger[1000];
        
        arrayLength = fibboArray.length;
        
        }
        if (y == 2) {
        fibboArray = null;
        fibboArray = new BigInteger[10000];
        
        arrayLength = fibboArray.length;
        
        }*/
        int start = 0, median, last = anzahlFibonaccis;

        if (nextBestNumber.compareTo(BigInteger.ZERO) == 0) {
            compare = false;
        }
        for (int x = 0; x < 100; x++) {
            if (laufzeitTest == true) {

                f1 = BigInteger.ZERO;
                f2 = BigInteger.ONE;
                result = BigInteger.ONE;
                schritte = 0;
            } else {
                x = 100;
            }
            for (int i = 0; i < anzahlFibonaccis; i++) {

                if (compare == false && isComparingQuicksortAndLinearSearch == false) {
                    System.out.println(i + 1 + ": " + result);
                }
                fibboArray[i] = result;
                result = f1.add(f2);

                if (f1.compareTo(f2) == -1) {

                    f1 = result;
                } else {

                    f2 = result;
                }

            }
            if (compare == true) {
                startTimerForQuicksort = System.nanoTime();
                quicksort(fibboArray, nextBestNumber, start, last);
                finishTimerForQuicksort = System.nanoTime();
                timeElapsedForQuicksort = finishTimerForQuicksort - startTimerForQuicksort;
                secondsForQuicksortTotal = secondsForQuicksortTotal + (double) timeElapsedForQuicksort;
                millisecondsForQuicksortTotal = millisecondsForQuicksortTotal + (double) timeElapsedForQuicksort;

                isNotFibboNmbr = false;
            }
            if (isComparingQuicksortAndLinearSearch == true) {
                int random = (int) (Math.random() * anzahlFibonaccis);
                nextBestNumber = fibboArray[random];

                startTimerForQuicksort = System.nanoTime();
                quicksort(fibboArray, nextBestNumber, start, last);
                finishTimerForQuicksort = System.nanoTime();
                timeElapsedForQuicksort = finishTimerForQuicksort - startTimerForQuicksort;
                secondsForQuicksortTotal = secondsForQuicksortTotal + (double) timeElapsedForQuicksort;
                millisecondsForQuicksortTotal = millisecondsForQuicksortTotal + (double) timeElapsedForQuicksort;

                secondsForQuicksortTotal = secondsForQuicksortTotal / 1_000_000_000.0;
                millisecondsForQuicksortTotal = millisecondsForQuicksortTotal / 1_000_000.0;

                startTimerForLinearSearch = System.nanoTime();
                linearSearch(fibboArray, nextBestNumber);
                finishTimerForLinearSearch = System.nanoTime();
                timeElapsedForLinearSearch = finishTimerForLinearSearch - startTimerForLinearSearch;
                secondsForLinearSearchTotal = secondsForLinearSearchTotal + (double) timeElapsedForLinearSearch;
                millisecondsForLinearSearchTotal = millisecondsForLinearSearchTotal + (double) timeElapsedForLinearSearch;

                secondsForLinearSearchTotal = secondsForLinearSearchTotal / 1_000_000_000.0;
                millisecondsForLinearSearchTotal = millisecondsForLinearSearchTotal / 1_000_000.0;
                setTimeNeeded(timeNeeded + " Linear: " + millisecondsForLinearSearchTotal + " Millisekunden oder " + secondsForLinearSearchTotal + " Sekunden \n");

            }

        }

        millisecondsForQuicksortTotal = millisecondsForQuicksortTotal / 1_000_000.0;
        setTimeNeeded(timeNeeded + "Quicksort: " + millisecondsForQuicksortTotal + " Millisekunden \n");
        return fibboArray;
    }

    @Override
    public int linearSearch(BigInteger fibboArray[], BigInteger nextBestNumber) {
        int index = 0;
        BigInteger intervallInfront, intervallBehind;

        for (int i = 0; i < fibboArray.length; i++) {
            if (fibboArray[i] == nextBestNumber) {
                System.out.println(nextBestNumber + " steht gleich mit Index: " + i + " Fibbonummer: " + fibboArray[i] + " hat " + schritte + " schritte gebraucht.");
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int quicksort(BigInteger fibboArray[], BigInteger nextBestNumber,
            int first, int last
    ) {
        int result = 0;
        int median = (first + last) / 2;
        int distance = last - first;

        if (isNotFibboNmbr == false) {
            if (distance == 1) {
                isNotFibboNmbr = true;

                BigInteger firstDistance = fibboArray[first];
                BigInteger lastDistance = fibboArray[last];
                firstDistance = nextBestNumber.subtract(firstDistance);
                //System.out.println("first: " + firstDistance);
                lastDistance = lastDistance.subtract(nextBestNumber);
                //System.out.println("last: " + lastDistance);

                if (firstDistance.compareTo(lastDistance) == 1) {
                    schritte++;
                    System.out.println("Index: " + last + " Fibbonummer: " + fibboArray[last] + " ist naeher an " + nextBestNumber + " hat " + schritte + " schritte gebraucht.");
                    setSearchNumberFound("Index: " + last + " Fibbonummer: " + fibboArray[last] + " ist naeher an " + nextBestNumber + " hat " + schritte + " schritte gebraucht.");
                    schritte = 0;
                } else {
                    schritte++;
                    System.out.println("Index: " + first + " Fibbonummer: " + fibboArray[first] + " ist naeher an " + nextBestNumber + " hat " + schritte + " schritte gebraucht.");
                    setSearchNumberFound("Index: " + first + " Fibbonummer: " + fibboArray[first] + " ist naeher an " + nextBestNumber + " hat " + schritte + " schritte gebraucht.");
                    schritte = 0;

                }

            }
            if (nextBestNumber.compareTo(fibboArray[median]) == 1) {
                schritte++;
                result = quicksort(fibboArray, nextBestNumber, median, last);

            }
            if (nextBestNumber.compareTo(fibboArray[median]) == -1) {
                schritte++;
                result = quicksort(fibboArray, nextBestNumber, first, median);

            }
            if (nextBestNumber.compareTo(fibboArray[median]) == 0) {
                schritte++;
                System.out.println(nextBestNumber + " steht gleich mit Index: " + median + " Fibbonummer: " + fibboArray[median] + " hat " + schritte + " schritte gebraucht.");
                setSearchNumberFound(nextBestNumber + " steht gleich mit Index: " + median + " Fibbonummer: " + fibboArray[median] + " hat " + schritte + " schritte gebraucht.");

            }

        }

        return result;
    }
}
