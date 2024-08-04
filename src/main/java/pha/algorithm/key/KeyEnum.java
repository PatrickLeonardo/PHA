package pha.algorithm.key;

public enum KeyEnum {

    MATRIX(new byte[][][] {
        { {0x00}, {0x00}, {0x00}, {0x00} },
        { {0x00}, {0x00}, {0x00}, {0x00} },
        { {0x00}, {0x00}, {0x00}, {0x00} },
        { {0x00}, {0x00}, {0x00}, {0x00} }        
    });
    
    private final byte[][][] value;
    
    KeyEnum(final byte[][][] value){
        this.value = value;
    }

    public byte[][][] getValue() {
        return value;
    }

}
