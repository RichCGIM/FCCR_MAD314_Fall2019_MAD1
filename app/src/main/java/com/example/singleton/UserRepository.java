package com.example.singleton;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static UserRepository instance = null;
    private Map<String, String> users;

    private UserRepository() {
        users = new HashMap<>();
        users.put("admin", "admin");
        users.put("demo", "demo1");
        users.put("rich", "daniel");
        users.put("users1", "users1");
        users.put("users2", "demo1");
        users.put("users3", "demo1");
    }
    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public Map<String, String> getUsers() {
        return new HashMap<>(users);
    }
}
