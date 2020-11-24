/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.draeger.fibonacci.service;

import java.math.BigInteger;

/**
 *
 * @author draeg
 */
public interface FibonacciService {

    BigInteger[] fibboCalc(BigInteger nextBestNumber, int anzahlFibonaccis, boolean isComparingQuicksortAndLinearSearch, boolean laufzeitTest);

    int quicksort(BigInteger fibboArray[], BigInteger nextBestNumber, int first, int last);

    int linearSearch(BigInteger fibboArray[], BigInteger nextBestNumber);

    void setSearchNumberFound(String searchNumberFound);

    public String getTimeNeeded();

    public void setTimeNeeded(String timeNeeded);
    
    String getSearchNumberFound();
}
