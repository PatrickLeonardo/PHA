package pha.algorithm.crypto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;

public class ValidKey {

    File keyFile;
    String keyHash;

    ValidKey(final File keyFIle) { this.keyFile = keyFIle; }

    public Boolean validator() throws FileNotFoundException, IOException, InvalidKeyException {
        
        try {
            
            final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(this.keyFile)
                )
            );
            
            this.keyHash = bufferedReader.readLine();
            bufferedReader.close();

        } catch (final FileNotFoundException exception) {
            throw exception;
        }
        
        //System.out.println(this.keyHash);

        if (this.keyFile == null) {
            throw new InvalidKeyException();
        }
        
        return true;

    } 

}
