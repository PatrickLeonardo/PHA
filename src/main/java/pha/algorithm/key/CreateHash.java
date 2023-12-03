package pha.algorithm.key;

import java.util.Random;

public class CreateHash {

    public static String mountHexPHAKey(final String PHAKey){
    
        final String PHAKeyArray[] = PHAKey.split(" ");

        final StringBuilder PHAKeyHash = new StringBuilder();

        for(int byteIndex = 0; byteIndex < PHAKeyArray.length; byteIndex++) {

            final int intValue = Integer.parseInt(PHAKeyArray[byteIndex], 2);
            
            final String[] randomValue = generatePseudoNumberRamdom(1 ,intValue, 1000, new Random().nextInt(intValue + 1), 1);
            
            final String hexValue = "0x" + Integer.toHexString(Integer.valueOf(randomValue[0]));
            
            PHAKeyHash.append(hexValue);
        }
        
        return PHAKeyHash.toString();
    }

    public static String[] generatePseudoNumberRamdom(final int inital, int modulas, final int multiplier, final int random, final int total) {
        
        modulas ++;

        final StringBuilder resultBuilder = new StringBuilder();

        for(int index = 0; index < total; index++) {
            
            int pre_index = 0;

            try {
                pre_index = ((inital * multiplier) * random) % modulas;
            } catch(final ArithmeticException exception) {
                exception.printStackTrace();
            } finally {
                resultBuilder.append(pre_index);
                resultBuilder.append(" ");
            }

        }
         
        return resultBuilder.toString().split(" ");
        
    }
    
}
