package service;

import dto.User;

public class Application {
    public static void main(String[] args) throws Exception {
        InMemoryService inMemoryService = new InMemoryService();
        UserService userService = new UserService();
        PostService postService = new PostService();
//        userService.signUp("lucious");
//        userService.signUp("albus");
//        userService.signUp("tom");
//        User user = userService.login("tom");
//       //
//        postService.addPostForUser(user , "I am goind to darksite dark wizard");
//        postService.addPostForUser(user , "I am lord Voldermt");
//        user = userService.login("lucious");
//        postService.showNewsFeed();
//
//
//
//        System.out.println(" --- -------");
//        postService.upvote(1);
//        userService.follow(user , "tom");
//        postService.reply(1, "I am on your dark lord" , user);
//        user = userService.login("albus");
//        postService.showNewsFeed();

//        userService.signUp("lucious");
//        userService.signUp("albus");
//        userService.signUp("tom");
//        User user = userService.login("tom");
//        postService.addPostForUser(user , "I am goind to darksite dark wizard");
//        postService.addPostForUser(user , "I am lord Voldermt");
//        postService.upvote(2);
//        postService.upvote(2);
//        postService.upvote(1);
//        postService.reply(1, "I am on your dark lord" , user);
//        user = userService.login("albus");
//        postService.addPostForUser(user , "123 chvhjjkkjlhkljlkj");
//        User user1 = userService.login("lucious");
//        userService.follow(user1, "albus");
//        postService.showFeedNewsCommentSort();
         userService.signUp("lucious");
//         userService.signUp("lucious");
        User user = userService.login("tom");
     //   user = userService.login("lucious");








    }

}
