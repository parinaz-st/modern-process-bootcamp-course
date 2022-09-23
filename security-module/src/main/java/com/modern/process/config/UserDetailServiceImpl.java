package com.modern.process.config;

import com.modern.process.domain.User;
import com.modern.process.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
      private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User currentUser = userRepo.findByUsername(userName);

        UserDetails user = new org.springframework.security.core.userdetails.User(userName,
                currentUser.getPassword(), true, true,true,
                true, AuthorityUtils.createAuthorityList(currentUser.getRole()));

        return user;
    }
}
