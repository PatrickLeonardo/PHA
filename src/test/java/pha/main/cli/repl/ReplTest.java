package pha.main.cli.repl;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import pha.cli.repl.Repl;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class ReplTest {
    
    @Test
    public void ExecutReplTest() {
        
        String[] voidStringArray = new String[1];
        assertDoesNotThrow(() -> {Repl.main(voidStringArray);});

    }

}
