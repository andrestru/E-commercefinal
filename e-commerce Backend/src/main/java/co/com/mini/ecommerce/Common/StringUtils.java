package co.com.mini.ecommerce.Common;

public class StringUtils {

    public static boolean nonBlank(String value){
        String trimmed = value.trim();
        return trimmed.length()>0;
    }

    public static void character100(String value, String message){
        if(value.length()>100) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void character280(String value, String message){
        if(value.length()>280){
            throw new IllegalArgumentException(message);
        }
    }

    public static boolean rangeId(int value){
        if(value>1){
            return true;
        }else{
            return false;
        }
    }

    public static boolean rangeTax(double value){
        if(value>=0 && value<=1){
            return true;
        }else{
            return false;
        }
    }



}
