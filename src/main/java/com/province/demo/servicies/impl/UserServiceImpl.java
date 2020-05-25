package com.province.demo.servicies.impl;

import com.province.demo.models.AppUser;
import com.province.demo.models.UserRole;
import com.province.demo.repositories.UserRepository;
import com.province.demo.servicies.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<AppUser> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<AppUser> findAll() {
        return (List<AppUser>) userRepository.findAll();
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public AppUser save(AppUser appUser) {
        return userRepository.save(appUser);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return userRepository.getAppUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = this.getUserByUsername(username);

        List<UserRole> authorities = new ArrayList<>();

        authorities.add(appUser.getUserRole());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), authorities);

        return userDetails;
    }
}
