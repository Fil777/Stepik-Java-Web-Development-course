package stepik.course;

import java.security.SecureRandom;
import java.util.Base64;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        jwt secret key generation
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[256 / 8];
        secureRandom.nextBytes(keyBytes);
//        String secret = Base64.getEncoder().encodeToString(keyBytes);
        String secret = Base64
                .getUrlEncoder()
                .withoutPadding()
                .encodeToString(keyBytes);
        System.out.println("\nSecret Key:\n" + secret);

    }
}