/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.draeger.fibonacci.model;

import java.math.BigInteger;

/**
 *
 * @author draeg
 */
public class FibonacciRequest {
    private BigInteger suchNummer;
    private int anzahlFibonaccis;
    private boolean laufzeitTest;

    public boolean isLaufzeitTest() {
        return laufzeitTest;
    }

    public void setLaufzeitTest(boolean laufzeitTest) {
        this.laufzeitTest = laufzeitTest;
    }
    

    public BigInteger getSuchNummer() {
        return suchNummer;
    }

    public void setSuchNummer(BigInteger suchNummer) {
        this.suchNummer = suchNummer;
    }

    public int getAnzahlFibonaccis() {
        return anzahlFibonaccis;
    }

    public void setAnzahlFibonaccis(int anzahlFibonaccis) {
        this.anzahlFibonaccis = anzahlFibonaccis;
    }    
}


