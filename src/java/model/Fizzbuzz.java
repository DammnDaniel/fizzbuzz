/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author daniy
 */
public class Fizzbuzz {
    //atributtes
    private int initNumber;
    private int endNumber;
    private int resultString;

    //Constructor
    public Fizzbuzz() {
        
    }

    //getters && setters
    public int getInitNumber() {
        return initNumber;
    }

    public void setInitNumber(int initNumber) {
        this.initNumber = initNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(int endNumber) {
        this.endNumber = endNumber;
    }

    public int getResultString() {
        return resultString;
    }

    public void setResultString(int resultString) {
        this.resultString = resultString;
    }

    //HashCode && equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.initNumber;
        hash = 37 * hash + this.endNumber;
        hash = 37 * hash + this.resultString;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fizzbuzz other = (Fizzbuzz) obj;
        if (this.initNumber != other.initNumber) {
            return false;
        }
        if (this.endNumber != other.endNumber) {
            return false;
        }
        if (this.resultString != other.resultString) {
            return false;
        }
        return true;
    }
    
    
}
