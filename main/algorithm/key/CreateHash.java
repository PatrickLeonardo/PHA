package main.algorithm.key;

import java.util.Random;
import main.unicode.Unicode;

public class CreateHash {
    
    public static String mountUnicodeInPHAKey(String PHAKey){
    
        String[] stringArray = PHAKey.split(" ");
        char[] characters = Unicode.CharactersUnicode();
        StringBuilder PHAKeyHash = new StringBuilder();

        for(int index = 0; index < stringArray.length; index++) {
            stringArray[index] = String.valueOf(characters[new Random().nextInt(45)]);
            PHAKeyHash.append(stringArray[index]);
        }
        
        return PHAKeyHash.toString();
    }
    
}