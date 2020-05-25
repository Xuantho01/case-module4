package com.province.demo.servicies.impl;

import com.province.demo.models.UserRole;
import com.province.demo.repositories.UserRoleRepository;
import com.province.demo.servicies.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleImpl implements IUserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findAll() {
        return (List<UserRole>) userRoleRepository.findAll();
    }

}
