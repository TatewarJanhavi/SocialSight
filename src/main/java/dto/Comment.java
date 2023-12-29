package dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class Comment {
    int id ;
    String comment ;
    User commentedUser ;
    LocalDateTime date ;

    public Comment(int id ,String comment, User commentedUser, LocalDateTime date) {
        this.id = id ;
        this.comment = comment;
        this.commentedUser = commentedUser;
        this.date = date;
    }
}
