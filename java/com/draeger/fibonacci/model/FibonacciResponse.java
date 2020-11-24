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
public class FibonacciResponse {

    private BigInteger[] fibonaccis;
    private int status = 0;
    private String message = "";
    private String searchNumberFound = "";
        private String laufzeit = "";

    public String getLaufzeit() {
        return laufzeit;
    }

    public void setLaufzeit(String laufzeit) {
        this.laufzeit = laufzeit;
    }

    public String getSearchNumberFound() {
        return searchNumberFound;
    }

    public void setSearchNumberFound(String searchNumberFound) {
        this.searchNumberFound = searchNumberFound;
    }

    public BigInteger[] getFibonaccis() {
        return fibonaccis;
    }

    public void setFibonaccis(BigInteger[] fibonaccis) {
        this.fibonaccis = fibonaccis;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String errormessage) {
        this.message = errormessage;
    }
}
