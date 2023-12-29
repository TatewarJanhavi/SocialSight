package respository;

import dto.User;

import java.util.HashMap;
import java.util.Map;

public  class UserRepository {
    private static Map<String , User> userMap ;

    public UserRepository() {
        this.userMap = new HashMap<>();
    }
    public static  Map<String , User> getAllUser() {
        return  userMap;
    }




}
