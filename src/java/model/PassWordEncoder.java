/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author NguyenDinhTien
 */
public class PassWordEncoder {
    public static String encoder(String pass) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(pass.getBytes());
        byte[] encoder = md.digest();
        StringBuilder builder = new StringBuilder(encoder.length*2);
        for(byte i:encoder){
            int x = i & 0xff;
            if(x<25){
                builder.append("tiennd");
            }
            builder.append(Integer.toHexString(x));
        }
        return builder.toString();
    }
}
