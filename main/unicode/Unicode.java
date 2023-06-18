package main.unicode;

import java.nio.charset.Charset;

/**
 * <p>Unicode class is used to get some characters from unicode table.
 * Any modification can affect malfunctions, such as errors and failures, so don't modify it if you don't know what you're doing.
 */
public class Unicode {

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    
    /**
     * <p>This method is used to get an array of chars, containing some characters from the unicode table.
     * These characters are used to encode the key and the corresponding messages.
     * @return char[] Containg the characters.
     */
    public static char[] CharacteresUnicode(){

        final char[] CHARACTERS = {

            'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y',
            'z', 'ç', '!', '?', '@',
            '&', '#', '$', '%', '/',
            '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9'

        };

        return CHARACTERS;

    }

}