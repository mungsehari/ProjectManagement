package com.hari.service.Imlp;

import com.hari.config.JwtProvider;
import com.hari.model.User;
import com.hari.repository.UserRepository;
import com.hari.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserProfileByJwt(String jwt) throws Exception {
        String email= JwtProvider.getEmailFromToken(jwt);
        return findUserByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user=userRepository.findByEmail(email);
        if (user==null) throw new Exception("User not found");
        return user;
    }

    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> optionalUser=userRepository.findById(userId);
        if (optionalUser.isEmpty()) throw new Exception("User not found");
        return optionalUser.get();
    }

    @Override
    public User updateUserProjectSize(User user, int number) throws Exception {
        user.setProjectSize(user.getProjectSize()+number);
        return userRepository.save(user);
    }
}
