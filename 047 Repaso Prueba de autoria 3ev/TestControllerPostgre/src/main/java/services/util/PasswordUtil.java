package services.util;

import org.mindrot.jbcrypt.BCrypt;

import java.security.SecureRandom;

public class PasswordUtil {

    // Generar hash con salt aleatorio
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Verificar si coincide la contraseña en texto plano con el hash
    public static boolean checkPassword(String passwordPlano, String hashedPassword) {
        return BCrypt.checkpw(passwordPlano, hashedPassword);
    }

    public static String generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return bytesToHex(salt);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

