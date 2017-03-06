package com.eyo.roman.numerals.vo;

import java.io.Serializable;

public class NumberConverted implements Serializable {
    
    
    /**
     * serial version UID
     */
    private static final long serialVersionUID = -2648620583727417964L;
    
    private int number;
    private boolean skipNextValue;
    
    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }
    
    /**
     * @param number the numberConverted to set
     */
    public void setNumber(int number) {
        this.number = number;
    }
    
    /**
     * @return the skipNextValue
     */
    public boolean isSkipNextValue() {
        return skipNextValue;
    }
    
    /**
     * @param skipNextValue the skipNextValue to set
     */
    public void setSkipNextValue(boolean skipNextValue) {
        this.skipNextValue = skipNextValue;
    }
    
}