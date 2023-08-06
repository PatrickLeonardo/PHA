package test.main.algorithm.key;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import main.algorithm.key.KeyEnum;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class KeyEnumTest {

    @Test
    public void MatrixEnumTest(){

        byte[][][] matrix = KeyEnum.MATRIX.getValue();
        assertEquals(0, matrix[0][0][0]);

    }
}