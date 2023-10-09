package pha.main.algorithm.key;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import pha.algorithm.key.KeyEnum;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class KeyEnumTest {

    @Test
    public void MatrixEnumTest(){

        byte[][][] matrix = KeyEnum.MATRIX.getValue();
        assertEquals(0, matrix[0][0][0]);

    }
}
