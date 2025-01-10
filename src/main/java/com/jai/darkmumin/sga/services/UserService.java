package com.jai.darkmumin.sga.services;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jai.darkmumin.sga.models.User;
import com.jai.darkmumin.sga.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    UserRepository userRepository;

    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
    public User obtainUserById(Long id) {
        return userRepository.findById(id).get();
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userInput) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userInput);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }else {
            List<GrantedAuthority> authorities = new ArrayList<>();
            return new org.springframework.security.core.userdetails.User(Long.toString(user.id), user.password, authorities);
        }
    }
}
