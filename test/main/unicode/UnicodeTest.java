package test.main.unicode;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import main.unicode.Unicode;

import static org.junit.Assert.assertEquals;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class UnicodeTest {

    @Test
    public void CharsetTest(){

        String myString = new String("ã, á, â");
        byte[] myByte = myString.getBytes(Unicode.UTF_8);
        String UTF_8_String = new String(myByte);
        char[] characters = Unicode.CharactersUnicode();

        assertEquals('a', characters[0]);
        assertEquals("ã, á, â", UTF_8_String);
        
    }

}