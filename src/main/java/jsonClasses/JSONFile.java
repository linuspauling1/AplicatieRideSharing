package jsonClasses;

import dataStructures.User;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.io.*;
import java.security.spec.KeySpec;
import java.util.Iterator;

public class JSONFile {
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private static Cipher cipher;
    byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    private static SecretKey key;

    public JSONFile()throws Exception{
        myEncryptionKey = "PROIECT-FIS--FIS-PROIECT";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        ks = new DESedeKeySpec(arrayBytes);
        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = skf.generateSecret(ks);
    }

    public static JSONArray readFromFiles(String fileName){
        JSONParser parser=new JSONParser();
        JSONArray list=new JSONArray();
        try{
            Reader reader=new FileReader(fileName);
            list=(JSONArray)parser.parse(reader);
        }catch(IOException e){
            System.out.println();
        }catch(ParseException e){
            e.printStackTrace();
        }
        return list;
    }
    public static String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }


    public static String decrypt(String encryptedString) {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }

    public static boolean verificaCredentiale(String fileName, User u){
        JSONArray list=JSONFile.readFromFiles(fileName);
        Iterator<JSONObject> it=list.iterator();
        while(it.hasNext()){
            JSONObject obj=it.next();
            JSONObject objInt=(JSONObject)obj.get("customer :");
            if(objInt.get("username").equals(u.getUsername())&&decrypt((String)objInt.get("password")).equals(u.getPassword()))
                return true;
        }
        return false;
    }

}


