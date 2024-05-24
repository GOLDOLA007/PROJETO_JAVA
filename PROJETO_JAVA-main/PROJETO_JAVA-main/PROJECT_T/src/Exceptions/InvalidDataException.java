package Exceptions;

public class InvalidDataException extends Exception{
    private String message, invalidString;
    private int invalidInt;
    private double invalidDouble;

    public InvalidDataException(String message, String invalidData){
        super(message);
        this.invalidString = invalidData;
    }

    public InvalidDataException(String message, int invalidInt){
        super(message);
        this.invalidInt = invalidInt;
    }

    public InvalidDataException(String message, double invalidDouble){
        super(message);
        this.invalidDouble = invalidDouble;
    }


}
