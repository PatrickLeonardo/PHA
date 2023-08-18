package main.algorithm.key;

import java.util.Random;
import main.unicode.Unicode;

public class CreateHash {
    
    public static String replaceCharAtIndex(String original, int byteIndex, char newChar) {
        char[] chars = original.toCharArray();
        chars[byteIndex] = newChar;
        return new String(chars);
    }

    public static String mountUnicodeInPHAKey(String PHAKey){
    
        String PHAKeyArray[] = PHAKey.split(" ");
        char[] characters = Unicode.CharactersUnicode();
        StringBuilder PHAKeyHash = new StringBuilder();

        for(int byteIndex = 0; byteIndex < PHAKeyArray.length; byteIndex++) {

            for(int bitIndex = 0; bitIndex < PHAKeyArray[byteIndex].length(); bitIndex++){

                // if the bit is 0, that bit in the hash is a random character between 0 and 21 from the unicode table (Unicode class)
                if(PHAKeyArray[byteIndex].charAt(bitIndex) == '0'){
                    PHAKeyArray[byteIndex] = replaceCharAtIndex(PHAKeyArray[byteIndex], bitIndex, characters[new Random().nextInt(0, 21)]);
                } 
                // else if the bit is 0, that bit in the hash is a random character between 22 and 43 from the unicode table (Unicode class)
                else if(PHAKeyArray[byteIndex].charAt(bitIndex) == '1'){
                    PHAKeyArray[byteIndex] = replaceCharAtIndex(PHAKeyArray[byteIndex], bitIndex, characters[new Random().nextInt(22, 43)]);
                }
            }
            
            PHAKeyHash.append(PHAKeyArray[byteIndex]);
        }
        
        return PHAKeyHash.toString();
    }
    
}