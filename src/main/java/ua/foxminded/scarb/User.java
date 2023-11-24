package ua.foxminded.scarb;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class User {
    private String username;
    private String password;
    private String position;
    private String lastname;

    public static class UserBuilder {
        private String username;
        private String password;
        private String position;
        private String lastname;

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }
        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public UserBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public User build() {
            return new User(username, password, position, lastname);
        }
    }
}


