package com.eyo.roman.numerals.vo;

public enum RomanNumbers {
    
    I ("I", 1),
    V ("V", 5),
    X ("X", 10), 
    L ("L", 50), 
    C ("C", 100), 
    D ("D", 500), 
    M ("M", 1000);
    
    private final String name;
    private final int value;
    
    private RomanNumbers(String s, int val) {
        name = s;
        value = val;
    }
    
    public boolean equalsName(String otherName) {
        return name.equals( otherName );
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public int getValue(){
        return this.value;
    }
    
}
