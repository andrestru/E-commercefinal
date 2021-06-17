package co.com.mini.ecommerce.Common;

import java.util.UUID;

public class Generator {

    public static int GeneratorId(){
        String a = UUID.randomUUID().toString().replaceAll("[^0-9]", "");
        return Integer.parseInt(a.substring(0, 9));
    }

    public static String Generator(){
        return UUID.randomUUID().toString().toUpperCase().substring(0, 18);
    }

}
