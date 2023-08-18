package main.algorithm.utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import main.algorithm.key.CreateHash;

/**
 * <p>
 * The {@code savePHAKey} class is a class for save the PHAKey in a text file with the encoded key.
 * This class is used only to handle with the encoded key file creation.
 * </p>
 */
public class savePHAKey {
    
    protected static String encodeKey(String PHAKey){
        return CreateHash.mountUnicodeInPHAKey(PHAKey);
    }

    /**
     * These method is used for write encoded key automatic in a text file. Example:
     * <blockquote><pre>
     *      savePHAKey.writeEncodedKey(encodedKey);
     * </blockquote></pre>
     * @param Key String The encoded key object.
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws OperatorCreationException
     * @throws IOException
     */
    public static boolean writeEncodedKey(String Key) throws KeyStoreException, OperatorCreationException, NoSuchAlgorithmException, InvalidKeySpecException, CertificateException, IOException {

        String stringKey = new String(Key);
        String encodedKey = encodeKey(stringKey);
    
        byte[] key = new byte[encodedKey.length() * 2];
        for (int index = 0; index < encodedKey.length(); index++){
            char c = encodedKey.charAt(index);
            key[index * 2] = (byte) (c >> 8);
            key[index * 2 + 1] = (byte) c;
        }

        System.out.println(new String(key, StandardCharsets.UTF_16BE));

        SecretKey secretKey = new SecretKeySpec(key, "PHA-256");
        char[] password = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        X509Certificate certificate = generateCertificate(key);        

        String alias = new String("KeyStorePassoword");
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, alias.toCharArray());
        keyStore.setKeyEntry(alias, secretKey, password, new X509Certificate[] {certificate});

        try (FileOutputStream FileOutputStream = new FileOutputStream("encodedKey.jks")){
            keyStore.store(FileOutputStream, password);
        }
        
        return true;
    }

    public static PrivateKey generatePrivateKey(byte[] Key) throws NoSuchAlgorithmException, InvalidKeySpecException{
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Key);
        KeyFactory keyFactory = KeyFactory.getInstance("PHA-256");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public static X509Certificate generateCertificate(byte[] Key) throws OperatorCreationException, NoSuchAlgorithmException, InvalidKeySpecException, CertificateException{
        
        X500Name subjectName = new X500Name("CN=Me");
        
        Date startDate = Date.from(Instant.now());
        Date endDate = Date.from(Instant.now().plus(365, ChronoUnit.DAYS));
        BigInteger serialNumber = BigInteger.valueOf(System.currentTimeMillis());
        SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(Key);
    
        X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(subjectName, serialNumber, startDate, endDate, subjectName, subjectPublicKeyInfo);
        JcaContentSignerBuilder contentSignerBuilder = new JcaContentSignerBuilder("PHA-256");
        ContentSigner contentSigner = contentSignerBuilder.build(generatePrivateKey(Key));

        X509Certificate cert = new JcaX509CertificateConverter().getCertificate(certBuilder.build(contentSigner));

        return cert;
    }

}