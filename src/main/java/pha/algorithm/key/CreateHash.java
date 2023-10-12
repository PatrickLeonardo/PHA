package pha.algorithm.key;

public class CreateHash {

    public static String mountUnicodeInPHAKey(String PHAKey){
    
        String PHAKeyArray[] = PHAKey.split(" ");

        StringBuilder PHAKeyHash = new StringBuilder();

        for(int byteIndex = 0; byteIndex < PHAKeyArray.length; byteIndex++) {

            int intValue = Integer.parseInt(PHAKeyArray[byteIndex], 2);
            String hexValue = "0x" + Integer.toHexString(intValue);
            
            PHAKeyHash.append(hexValue);
        }
        System.out.println(PHAKeyHash);
       
        return PHAKeyHash.toString();
    }
    
}
