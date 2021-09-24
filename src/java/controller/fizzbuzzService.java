/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.Properties;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Fizzbuzz;

import java.util.logging.Logger;

/**
 *
 * @author daniy
 */
@WebService(serviceName = "fizzbuzzService")
public class fizzbuzzService {

    private final static Logger log = Logger.getLogger(fizzbuzzService.class.getName());

    @WebMethod(operationName = "fizzbuzz")
    public String fizzbuzz(@WebParam(name = "init_number") int init_number) {
        String resultString = "";
            int LastNumber;
            Fizzbuzz fizzbuzz = new Fizzbuzz();
            fizzbuzz.setInitNumber(init_number);
            log.info("Min number: " + init_number);
            LastNumber = getLastNumber();
            fizzbuzz.setEndNumber(LastNumber);
            log.info("Max number: " + LastNumber);

            if (init_number > LastNumber) {
                //We return an error message if the initial number is greater than the maximum
                log.warning("init number (" + init_number + ") is greater than the max number (" + LastNumber + ")");
                resultString = "init number (" + init_number + ") is greater than the max number (" + LastNumber + ")";
            } else {
                //return the correct list of the strings
                for (int i = fizzbuzz.getInitNumber(); i <= fizzbuzz.getEndNumber(); i++) {
                    if (i % 3 == 0 && i % 5 == 0) {
                        resultString += "Fizzbuzz, ";
                    } else if (i % 3 == 0) {
                        resultString += "Fizz, ";
                    } else if (i % 5 == 0) {
                        resultString += "Buzz, ";
                    } else {
                        resultString += i + ", ";
                    }
                }
                resultString = resultString.substring(0, resultString.length() - 2);

            }
       
        return resultString;
    }

    private int getLastNumber() {
        int endNumber = -1;
        try {
            Properties propiedades = new Properties();
            propiedades.load(getClass().getResourceAsStream("/resources/configuration.properties"));
            endNumber = Integer.parseInt(propiedades.getProperty("lastNumber"));
        } catch (IOException ex) {
        }
        return endNumber;
    }
}
