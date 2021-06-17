package co.com.mini.ecommerce.Common;


public class Validate {

    public static void NotNull(Object value, String message){
        if (value == null){
            throw new NullPointerException(message);
        }
    }

    public static void isTrue(boolean condition, String message){
        if(!condition){
            throw new IllegalArgumentException(message);
        }
    }








}
