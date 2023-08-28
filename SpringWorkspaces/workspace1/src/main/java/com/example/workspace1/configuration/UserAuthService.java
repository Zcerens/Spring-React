package com.example.workspace1.configuration;

import com.example.workspace1.user.User;
import com.example.workspace1.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User inDb = userRepository.findByUsername(username);
        if(inDb == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new WorkspaceUserDetails(inDb);
    }
}
