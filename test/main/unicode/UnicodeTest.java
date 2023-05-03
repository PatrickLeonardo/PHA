package test.main.unicode;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import static org.junit.Assert.assertEquals;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class UnicodeTest {

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

    @Test
    public void CharsetTest(){

        String myString = new String("ã, á, â");
        byte[] myByte = myString.getBytes(UTF_8);
        String UTF_8_String = new String(myByte);
        char[] characters = CharacteresUnicode();

        assertEquals('a', characters[0]);
        assertEquals("ã, á, â", UTF_8_String);
        
    }

}