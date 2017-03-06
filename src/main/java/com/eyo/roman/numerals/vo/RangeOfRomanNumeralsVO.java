package com.eyo.roman.numerals.vo;

import java.io.Serializable;

public class RangeOfRomanNumeralsVO implements Serializable{

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 3554064724171308866L;
    
    private RomanNumbers ten;
    
    private RomanNumbers five;
    
    private RomanNumbers one;

    
    public RangeOfRomanNumeralsVO(RomanNumbers ten, RomanNumbers five, RomanNumbers one) {
        super();
        this.setTen( ten );
        this.setFive( five );
        this.setOne( one );
    }


    /**
     * @return the ten
     */
    public RomanNumbers getTen() {
        return ten;
    }

    
    /**
     * @param ten the ten to set
     */
    public void setTen(RomanNumbers ten) {
        this.ten = ten;
    }

    
    /**
     * @return the five
     */
    public RomanNumbers getFive() {
        return five;
    }

    
    /**
     * @param five the five to set
     */
    public void setFive(RomanNumbers five) {
        this.five = five;
    }

    
    /**
     * @return the one
     */
    public RomanNumbers getOne() {
        return one;
    }

    
    /**
     * @param one the one to set
     */
    public void setOne(RomanNumbers one) {
        this.one = one;
    }
    
}
