package com.eyo.roman.numerals.vo;

public enum RomanNumbers {
    
    I ("I"),
    V ("V"),
    X ("X"), 
    L ("L"), 
    C ("C"), 
    D ("D"), 
    M ("M");
    
    private final String name;
    
    private RomanNumbers(String s) {
        name = s;
    }
    
    public boolean equalsName(String otherName) {
        return name.equals( otherName );
    }
    
    public String toString() {
        return this.name;
    }
    
}
