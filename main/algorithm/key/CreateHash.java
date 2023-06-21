package main.algorithm.key;

import java.util.Random;

import main.unicode.Unicode;

public class CreateHash {
    
    public static String mountUnicodeInPHAKey(String PHAKey){
    
        String[] stringArray = PHAKey.split(" ");
        char[] characters = Unicode.CharacteresUnicode();
        String PHAKeyHash = "";
        for(int index = 0; index < stringArray.length; index++) {
            stringArray[index] = String.valueOf(characters[new Random().nextInt(45)]);
            PHAKeyHash += stringArray[index];
        }
        
        return PHAKeyHash;
    }
    
}