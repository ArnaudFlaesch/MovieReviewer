package com.esgi.model;

/**
 * Created by Arnaud on 17/04/2016.
 */
public class SessionUser {
    private static Long iduser = new Long(0);
    private static String name = "";
    private static String firstName = "";
    private static String pseudo = "";
    private static String token = "";

    public static Long getIduser() {
        return iduser;
    }

    public static String getName() {
        return name;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getPseudo() {
        return pseudo;
    }

    public static String getToken() {
        return token;
    }

    public static void setIduser(Long iduser) {
        SessionUser.iduser = iduser;
    }

    public static void setName(String name) {
        SessionUser.name = name;
    }

    public static void setFirstName(String firstName) {
        SessionUser.firstName = firstName;
    }

    public static void setPseudo(String pseudo) {
        SessionUser.pseudo = pseudo;
    }

    public static void setToken(String token) {
        SessionUser.token = token;
    }
}
