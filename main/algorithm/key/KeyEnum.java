package main.algorithm.key;

public enum KeyEnum {

    MATRIX(new byte[][][] {
        { {0x00}, {0x00}, {0x00}, {0x00} },
        { {0x00}, {0x00}, {0x0}, {0x00} },
        { {0x00}, {0x00}, {0x00}, {0x00} },
        { {0x00}, {0x00}, {0x00}, {0x00} }        
    });
    
    private byte value[][][];
    
    KeyEnum(byte[][][] value){
        this.value = value;
    }

    public byte[][][] getValue() {
        return value;
    }

}