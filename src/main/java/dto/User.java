package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {
    int id ;
    String username ;
    List<User> followers ;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
        followers = new ArrayList<>();
    }
}
