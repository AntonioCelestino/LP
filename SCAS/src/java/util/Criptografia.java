package util;

import controller.ManterUsuarioController;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Criptografia {

    public static String criptografar(String senha) {
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("MD5");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            senha = hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return senha;
    }

}
