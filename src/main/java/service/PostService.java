package service;

import dto.Comment;
import dto.Post;
import dto.User;
import respository.PostRepository;

import java.time.LocalDateTime;
import java.util.*;

public class PostService {
    static int postCounter = 1 ;
    static int commentCount = 1 ;
    public void addPostForUser(User user , String feedItem){

        List<Post> allPost  =PostRepository.getAllPost();
        Post post = new Post(postCounter , user.getUsername(), feedItem ,  LocalDateTime.now() );

        allPost.add(post);
        Map<Integer , Post> postMap  =PostRepository.getAllPostMap();
        postMap.put(postCounter, post);

        postCounter++;
        Map<String , List<Post>> userPostMap  = PostRepository.getAllUserPost();
        userPostMap.computeIfAbsent(user.getUsername(), k -> new ArrayList<Post>() ).add(post);

    }

    public void showNewsFeed(){
        List<Post> allPost  =PostRepository.getAllPost();
        for(Post post: allPost){
            displayPost(post);
        }
    }

    private void displayPost(Post post){
        System.out.println("id "+ post.getId());
        System.out.println("( "+ post.getUpvote() +" upvotes , "+post.getDownvote()+" downvotes )");
        System.out.println(post.getName());
        System.out.println(post.getFeedItem());
        System.out.println(post.getDate());
        for(Comment comment : post.getComments())
        {
            System.out.println("           id "+ comment.getCommentedUser().getId());
            System.out.println("            "+comment.getComment());
            System.out.println("            "+comment.getCommentedUser().getUsername());
            System.out.println("           "+comment.getDate());
        }

    }

    public void upvote(int id) throws Exception {
        Map<Integer , Post> postMap  =PostRepository.getAllPostMap();
        if(!postMap.containsKey(id))
        {
            throw new Exception(String.format("Post with post ID %s doesn't esxits", id));
        }
        Post post = postMap.get(id);
        int count = post.getUpvote();
        post.setUpvote(++count);
    }
    public void downvote(int id) throws Exception {
        Map<Integer , Post> postMap  =PostRepository.getAllPostMap();
        if(!postMap.containsKey(id))
        {
            throw new Exception(String.format("Post with post ID %s doesn't esxits", id));
        }
        Post post = postMap.get(id);
        int count = post.getDownvote();
        post.setDownvote(--count);
    }

    public void reply(int id , String comment , User user ) throws Exception {
        Map<Integer , Post> postMap  =PostRepository.getAllPostMap();
        if(!postMap.containsKey(id))
        {
            throw new Exception(String.format("Post with post ID %s doesn't esxits", id));
        }
        Post post = postMap.get(id);
        List<Comment> comments = post.getComments();
        Comment newComment = new Comment(commentCount ,comment, user, LocalDateTime.now());
        comments.add(newComment);
        post.setComments(comments);
    }

    public void showFeedNewsFollowerSort(User user){
        List<User> followers = user.getFollowers();

        List<Post> posts =  PostRepository.getAllPost();
        List<Post> response = new ArrayList<>();
        Map<String , List<Post>> userPostMap  = PostRepository.getAllUserPost();

        for(User users: followers){
            if(userPostMap.containsKey(users.getUsername()))
              response.addAll(userPostMap.get(users.getUsername()));
        }

        for(Post post :posts){
            boolean isUserFollower = false ;
            for(User followedUser :followers) {
                if (post.getName() == followedUser.getUsername()){
                    isUserFollower = true ;
                }
            }
            if(!isUserFollower){
                response.add(post);
            }
        }

        for(Post post : response){
            displayPost(post);
        }

    }

    public void showFeedNewsUpVoteSort() {
        List<Post> posts =  PostRepository.getAllPost();
        List<Post> response = posts;
        Collections.sort(response , (a, b) ->{
            int diff1 = a.getUpvote() - a.getDownvote();
            int diff2 = b.getUpvote() - b.getDownvote();
            return diff2 - diff1 ;
        });

        for(Post post : response){
            displayPost(post);
        }

    }

    public void showFeedNewsCommentSort() {
        List<Post> posts =  PostRepository.getAllPost();
        List<Post> response = posts;
        Collections.sort(response , (a, b) ->{
            return b.getComments().size() - a.getComments().size();
        });

        for(Post post : response){
            displayPost(post);
        }

    }


}
