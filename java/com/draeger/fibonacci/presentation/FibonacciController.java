/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.draeger.fibonacci.presentation;

import com.draeger.fibonacci.model.FibonacciRequest;
import com.draeger.fibonacci.model.FibonacciResponse;
import com.draeger.fibonacci.service.FibonacciService;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author draeg
 */
@RestController
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping("/fibonacci/allNumbers")
    @CrossOrigin("*")
    public FibonacciResponse getFibonacci() {
        FibonacciResponse response = new FibonacciResponse();
        try {
            response.setFibonaccis(fibonacciService.fibboCalc(BigInteger.ZERO, 100, false, false));
            response.setLaufzeit(fibonacciService.getTimeNeeded());
        } catch (Exception e) {
            response.setStatus(-1);
            response.setMessage(e.getMessage());
        }

        return response;
    }

    @PostMapping("/fibonacci/search")
    public FibonacciResponse search(@RequestBody FibonacciRequest request) {
        FibonacciResponse response = new FibonacciResponse();

        try {
            response.setFibonaccis(fibonacciService.fibboCalc(request.getSuchNummer(), request.getAnzahlFibonaccis(), false, request.isLaufzeitTest()));
            response.setSearchNumberFound(fibonacciService.getSearchNumberFound());
            response.setLaufzeit(fibonacciService.getTimeNeeded());
        } catch (Exception e) {
            response.setStatus(-1);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @GetMapping("/fibonacci/compare/{searchNmbr}")
    public FibonacciResponse compare(@PathVariable(value = "searchNmbr") BigInteger nextBestNumber) {
        FibonacciResponse response = new FibonacciResponse();
        try {
            response.setFibonaccis(fibonacciService.fibboCalc(nextBestNumber, 100, true, false));
            response.setSearchNumberFound(fibonacciService.getSearchNumberFound());
            response.setLaufzeit(fibonacciService.getTimeNeeded());
        } catch (Exception e) {
            response.setStatus(-1);
            response.setMessage(e.getMessage());
        }

        return response;
    }
}
