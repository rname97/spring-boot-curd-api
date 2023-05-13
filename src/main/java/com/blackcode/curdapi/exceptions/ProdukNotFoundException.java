package com.blackcode.curdapi.exceptions;

public class ProdukNotFoundException extends RuntimeException{
    public ProdukNotFoundException(String message){
        super(message);
    }
}
