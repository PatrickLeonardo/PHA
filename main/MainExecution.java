package main;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

import org.bouncycastle.operator.OperatorCreationException;

import main.algorithm.key.PHAKeyCipher;

public class MainExecution {
    public static void main(String[] args) throws
    KeyStoreException, OperatorCreationException, NoSuchAlgorithmException, InvalidKeySpecException, CertificateException, IOException
    
    { PHAKeyCipher.createPHAKey(9); }

}