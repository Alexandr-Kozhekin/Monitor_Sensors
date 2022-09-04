package com.monitor_sensors.web_security.details;

import com.monitor_sensors.core.database.UserRepository;
import com.monitor_sensors.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(email);

        if(user != null) {

            return new UserDetailsImpl(user);

        } else  throw new IllegalArgumentException("User not found");

    }

}
