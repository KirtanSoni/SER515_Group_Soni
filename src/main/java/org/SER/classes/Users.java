package org.SER.classes;

class User {
    private final String email;
    private final String username;
    private final String password;
    private final UserType userType;

    public User(String email, String username, String password, UserType userType) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}

enum UserType {
    SCRUM_MASTER, DEVELOPER, PRODUCT_OWNER
}
