package stepik.contactsApp.service.authentification;

import stepik.contactsApp.model.enums.AppRole;

public interface UserAuthentificationInteface {
    static String getNewUserName(String fullName) { return null; }
    static String getNewUserEmail(String fullName){ return null; }
    static String getNewUserId(){ return null; }
    static String getNewUserPassword(){ return null; }
    static AppRole getNewUserRole(String username){ return null; }
    static AppRole getNewUserRole(){ return null; }
}
