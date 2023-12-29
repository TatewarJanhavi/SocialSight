package service;

import dto.User;
import respository.UserRepository;

import java.util.List;
import java.util.Map;

public class UserService {
    static int id = 1 ;
    public void signUp(String name ) throws Exception {
        Map<String , User>  userMap = UserRepository.getAllUser();
        if(userMap.containsKey(name)){
            throw new Exception (String.format("User already username %s esxits ", name));
        }
        User user = new User(id , name);
        id++;
        userMap.put(name , user);
    }

    public User login(String name ) throws Exception {
        Map<String , User>  userMap = UserRepository.getAllUser();
        if(!userMap.containsKey(name)){
            throw new Exception (String.format("User with username %s doesn't  esxits ", name));
        }
        return userMap.get(name);
    }

    public void follow(User user , String name) throws Exception {
        Map<String , User>  userMap = UserRepository.getAllUser();
        if(!userMap.containsKey(name)){
            throw new Exception (String.format("User with username %s doesn't  esxits ", name));
        }

        User followUser = userMap.get(user.getUsername());
        List<User> followersList = followUser.getFollowers();
        followersList.add(userMap.get(name));
        followUser.setFollowers(followersList);


    }


}


