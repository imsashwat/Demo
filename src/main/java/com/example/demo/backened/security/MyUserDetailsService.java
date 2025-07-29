package com.example.demo.backened.security;

import com.example.demo.backened.model.User;
import com.example.demo.backened.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    public MyUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);  // Fetch user from the database
         // If user is not found, throw an exception    
        if (user == null) throw new UsernameNotFoundException("User not found");
         System.out.println("🔍 Loading user from DB: " + username);
        
         // Create a UserDetails object with the user's information
        // Ensure that the password is encoded and roles are set correctly
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(), // Must be encoded!
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
}
