package com.eyo.roman.numerals.vo;

import java.io.Serializable;

public class RangeOfRomanNumeralsVO implements Serializable{

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 3554064724171308866L;
    
    private String ten;
    
    private String five;
    
    private String one;

    
    public RangeOfRomanNumeralsVO(String ten, String five, String one) {
        super();
        this.setTen( ten );
        this.setFive( five );
        this.setOne( one );
    }


    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    
    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    
    /**
     * @return the five
     */
    public String getFive() {
        return five;
    }

    
    /**
     * @param five the five to set
     */
    public void setFive(String five) {
        this.five = five;
    }

    
    /**
     * @return the one
     */
    public String getOne() {
        return one;
    }

    
    /**
     * @param one the one to set
     */
    public void setOne(String one) {
        this.one = one;
    }
    
}
