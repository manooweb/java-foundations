package fr.manooweb.java.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRecordRepository {

    private final Map<String, UserRecord> usersByEmail = new HashMap<>();

    public void save(UserRecord user) {
        usersByEmail.put(user.email(), user);
    }

    public Optional<UserRecord> findByEmail(String email) {
        return Optional.ofNullable(usersByEmail.get(email));
    }
}
