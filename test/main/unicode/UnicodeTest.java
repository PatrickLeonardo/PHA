package test.main.unicode;

import static org.junit.Assert.assertEquals;

import java.nio.charset.Charset;

import org.junit.Test;

public class UnicodeTest {

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static void main(String[] args) {

        CharacteresUnicodeTest();
        CharsetTest();

    }

    @Test
    public static char[] CharacteresUnicodeTest(){

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

        assertEquals('a', CHARACTERS[0]);
        return CHARACTERS;

    }

    @Test
    public static String CharsetTest(){

        String myString = new String("ã, á, â");
        byte[] myByte = myString.getBytes(UTF_8);
        String UTF_8_String = new String(myByte);

        assertEquals("ã, á, â", UTF_8_String);
        return UTF_8_String;
        
    }

}