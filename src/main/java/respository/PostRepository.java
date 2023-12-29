package respository;

import dto.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    private static Map<Integer , Post> postMap ;
    private static Map<String , List<Post>> userPostMap ;
    private static  List<Post> allPost ;

    public PostRepository() {
        postMap = new HashMap<>();
        allPost = new ArrayList<>();
        userPostMap = new HashMap<>();
    }

    public static Map<Integer , Post> getAllPostMap(){
        return postMap;
    }
    public static List<Post> getAllPost(){
        return allPost;
    }
    public static Map<String ,List <Post>> getAllUserPost(){
        return userPostMap;
    }
}
