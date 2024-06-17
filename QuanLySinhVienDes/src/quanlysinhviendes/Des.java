/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhviendes;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author datph
 */
public class Des {
   // Method to generate a DES key
     public static SecretKey generateDESKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56); // DES key size
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
     
    public static String keyToHexString(SecretKey secretKey) {
        byte[] keyBytes = secretKey.getEncoded();
        StringBuilder sb = new StringBuilder();
        for (byte b : keyBytes) {
            // Chuyển đổi mỗi byte thành hai ký tự hexa và nối vào chuỗi kết quả
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
    
    
    // Phương thức để chuyển đổi chuỗi hexa thành SecretKey
    public static SecretKey hexStringToSecretKey(String hexString) {
        try {
            // Chuyển đổi chuỗi hexa thành mảng byte
            byte[] keyBytes = hexStringToByteArray(hexString);

            // Tạo một đối tượng SecretKey từ mảng byte
            return new SecretKeySpec(keyBytes, "DES");
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid hex string: " + e.getMessage());
            return null;
        }
    }

    // Phương thức chuyển đổi chuỗi hexa thành mảng byte
    public static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }

    // Method to encrypt a file
    public static void encrypt(File inputFile, File outputFile, SecretKey key) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            try (FileInputStream fis = new FileInputStream(inputFile);
                 FileOutputStream fos = new FileOutputStream(outputFile);
                 CipherInputStream cis = new CipherInputStream(fis, cipher)) {
                write(cis, fos);
            }
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IOException e) {
            e.printStackTrace();
        }
    }

    // Method to decrypt a file
    public static void decrypt(File inputFile, File outputFile, SecretKey key) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);

            try (FileInputStream fis = new FileInputStream(inputFile);
                 FileOutputStream fos = new FileOutputStream(outputFile);
                 CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
                write(fis, cos);
            }
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IOException e) {
            e.printStackTrace();
        }
    }

    // Method to write data from input stream to output stream
    private static void write(InputStream in, OutputStream out) {
        byte[] buffer = new byte[64];
        int numBytesRead;
        try {
            while ((numBytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
