package main.unicode;

import java.nio.charset.Charset;

public class Unicode {

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    
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