package com.example.music_management.service;
import com.example.music_management.entity.User;
import com.example.music_management.form.UserForm;
import com.example.music_management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserForm userForm)throws Exception {
        if(userRepository.selectUserByUsername(userForm.getUsername()) == null){
            User user = new User();
            user.setUsername(userForm.getUsername());

            String hashePassword = passwordEncoder.encode(userForm.getPassword());
            user.setPassword(hashePassword);
            userRepository.insertUser(user);
        }else{
            throw new Exception("");
        }
    }
}
