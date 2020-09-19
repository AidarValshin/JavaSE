package ru.Aidar.exceptions;

import java.io.PrintWriter;

public class ArrayListIndexOutOfBoundsException extends  IndexOutOfBoundsException {
    private static final long serialVersionUID = -4322682019827188634L;

    public  ArrayListIndexOutOfBoundsException(){
    };

    public  ArrayListIndexOutOfBoundsException(String message){
        super(message);
    };
    @Override
    public String getMessage(){
        return " You can not add more than 10 elements to this array list";
    }


    @Override
    public void printStackTrace(PrintWriter s){
        super.printStackTrace(s);

    }


}
