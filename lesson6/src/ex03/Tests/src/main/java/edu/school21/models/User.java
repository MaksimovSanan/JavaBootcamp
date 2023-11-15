package edu.school21.models;

import java.util.Objects;

public class User {
    private final Long identifier;
    private final String login;
    private final String password;
    private Boolean authenticationSuccessStatus = false;

    public User(Long identifier, String login, String password) {
        this.identifier = identifier;
        this.login = login;
        this.password = password;
    }

    public User(Long identifier, String login, String password, Boolean authenticationSuccessStatus) {
        this.identifier = identifier;
        this.login = login;
        this.password = password;
        this.authenticationSuccessStatus = authenticationSuccessStatus;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAuthenticationSuccessStatus() {
        return authenticationSuccessStatus;
    }

    public void setAuthenticationSuccessStatus(Boolean authenticationSuccessStatus) {
        this.authenticationSuccessStatus = authenticationSuccessStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "identifier=" + identifier +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", authenticationSuccessStatus=" + authenticationSuccessStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getIdentifier(), user.getIdentifier()) && Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getAuthenticationSuccessStatus(), user.getAuthenticationSuccessStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentifier(), getLogin(), getPassword(), getAuthenticationSuccessStatus());
    }
}
