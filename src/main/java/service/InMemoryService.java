package service;

import respository.PostRepository;
import respository.UserRepository;

public class InMemoryService {
    public static UserRepository userRepository ;
    public static PostRepository postRepository;

    public InMemoryService() {
        userRepository = new UserRepository();
        postRepository = new PostRepository();
    }
}
