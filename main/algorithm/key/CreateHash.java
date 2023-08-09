package main.algorithm.key;

import java.util.Random;
import main.unicode.Unicode;

public class CreateHash {
    
    public static String replaceCharAtIndex(String original, int index, char newChar) {
        char[] chars = original.toCharArray();
        chars[index] = newChar;
        return new String(chars);
    }

    public static String mountUnicodeInPHAKey(String PHAKey){
    
        String[] stringArray = PHAKey.split(" ");
        char[] characters = Unicode.CharactersUnicode();
        StringBuilder PHAKeyHash = new StringBuilder();

        for(int index = 0; index < stringArray.length; index++) {

            for(int i = 0; i < stringArray[index].length(); i++){
                if(stringArray[index].charAt(i) == '0'){
                    stringArray[index] = replaceCharAtIndex(stringArray[index], i, characters[new Random().nextInt(0, 5)]);
                } else if(stringArray[index].charAt(i) == '1'){
                    stringArray[index] = replaceCharAtIndex(stringArray[index], i, characters[new Random().nextInt(30, 35)]);
                }
            }
            
            PHAKeyHash.append(stringArray[index]);
        }
        
        return PHAKeyHash.toString();
    }
    
}