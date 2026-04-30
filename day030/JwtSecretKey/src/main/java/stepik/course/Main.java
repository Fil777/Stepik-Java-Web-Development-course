package stepik.course;

import java.security.SecureRandom;
import java.util.Base64;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//  for Spring Boot projects:
        Package pkg = Main.class.getPackage();
        String springBootVersion = pkg.getImplementationVersion();
        System.out.println("Версия Spring Boot: " + springBootVersion);

//  JWT secret key generation for Spring Boot version 4.*
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[256 / 8];
        secureRandom.nextBytes(keyBytes);
        String secret3 = Base64
                .getEncoder()
                .encodeToString(keyBytes);
        String secret4 = Base64
                .getUrlEncoder()
                .withoutPadding()
                .encodeToString(keyBytes);
        System.out.printf("\nSecret Key for Spring Boot version 3.*:\n%s\n", secret3);
        System.out.printf("\nSecret Key for Spring Boot version 4.*:\n%s\n", secret4);

    }
}