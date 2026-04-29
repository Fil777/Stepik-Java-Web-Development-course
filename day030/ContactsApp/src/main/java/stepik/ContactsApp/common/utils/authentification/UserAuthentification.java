package stepik.ContactsApp.common.utils.authentification;

import stepik.ContactsApp.model.enums.AppRole;
import com.github.javafaker.Faker;
import stepik.ContactsApp.common.utils.transliterator.CyrillicToLatin;

import java.util.Locale;
import java.util.UUID;

public class UserAuthentification implements UserAuthentificationInteface {

    public static String getNewUserName(String fullName) {
        String[] parts = fullName.trim().split(" ");
        if (parts.length == 0) {
            return "Anonymus";
        } else if (parts.length == 1) {
            return CyrillicToLatin.transliterate(parts[0]);
        }
        return CyrillicToLatin.transliterate(parts[0] + parts[1]);
    }

    public static String getNewUserEmail(String fullName) {
        String[] parts = fullName.trim().toLowerCase().split(" ");
        String result = "@mail.ru";
        if (parts.length == 0) {
            result = "anonymus" + result;
        } else if (parts.length == 1) {
            result = CyrillicToLatin.transliterate(parts[0]) + result;
        } else {
            result = CyrillicToLatin.transliterate((parts[0] + "." + parts[1]).toLowerCase()) + result;
        }
        return result;
    }

    public static String getNewUserId() {
        return UUID.randomUUID().toString();
    }

    public static String getNewUserPassword() {
        Faker faker = new Faker(Locale.of("ru"));
        return faker.internet().password(6, 20, true, false, true);
    }

    public static AppRole getNewUserRole(String username) {
        if (username.equalsIgnoreCase("Admin")) {
            return AppRole.ADMIN;
        }
        return AppRole.USER;
    }

    public static AppRole getNewUserRole() {
        return AppRole.USER;
    }

}
