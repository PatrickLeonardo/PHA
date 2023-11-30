package pha.algorithm.key;

import java.util.Random;

public class CreateHash {

    public static String mountHexPHAKey(String PHAKey){
    
        String PHAKeyArray[] = PHAKey.split(" ");

        StringBuilder PHAKeyHash = new StringBuilder();

        for(int byteIndex = 0; byteIndex < PHAKeyArray.length; byteIndex++) {

            int intValue = Integer.parseInt(PHAKeyArray[byteIndex], 2);
            
            String[] randomValue = generatePseudoNumberRamdom(1 ,intValue, 1000, new Random().nextInt(intValue + 1), 1);
            
            String hexValue = "0x" + Integer.toHexString(Integer.valueOf(randomValue[0]));
            
            PHAKeyHash.append(hexValue);
        }
       
        return PHAKeyHash.toString();
    }

    public static String[] generatePseudoNumberRamdom(int inital, int modulas, int multiplier, int random, int total) {
        
        modulas ++;

        StringBuilder resultBuilder = new StringBuilder();

        for(int index = 0; index < total; index++) {
            
            int pre_index = 0;

            try {
                pre_index = ((inital * multiplier) * random) % modulas;
            } catch(ArithmeticException exception) {
                exception.printStackTrace();
            } finally {
                resultBuilder.append(pre_index);
                resultBuilder.append(" ");
            }

        }
       
        return resultBuilder.toString().split(" ");
        
    }
    
}
