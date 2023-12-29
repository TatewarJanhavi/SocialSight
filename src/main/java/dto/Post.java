package dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Post {
    int id;
    String name ;
    String feedItem ;
    List<Comment> comments ;
    LocalDateTime date;
    int upvote ;
    int downvote ;


    public Post(int id , String name , String feedItem,  LocalDateTime date) {
        this.id = id ;
        this.name = name ;
        this.feedItem = feedItem;
        this.date = date;
        comments = new ArrayList<>();
        upvote = 0 ;
        downvote = 0 ;
    }


}
