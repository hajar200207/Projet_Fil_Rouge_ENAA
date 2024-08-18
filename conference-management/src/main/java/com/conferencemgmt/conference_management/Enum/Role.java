package com.conferencemgmt.conference_management.Enum;


public enum Role {
    ROLE_ADMIN,
    ROLE_INVITE,
    ROLE_CONFERENCIER,
    ROLE_COMMIT_SCIENTIFIQUE,
    ROLE_COMMIT_ORGANISATION;

    public static Role fromString(String role) {
        switch (role.toUpperCase()) {
            case "ADMIN":
                return ROLE_ADMIN;
            case "INVITE":
                return ROLE_INVITE;
            case "CONFERENCIER":
                return ROLE_CONFERENCIER;
            case "COMMIT_SCIENTIFIQUE":
                return ROLE_COMMIT_SCIENTIFIQUE;
            case "COMMIT_ORGANISATION":
                return ROLE_COMMIT_ORGANISATION;
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}
