package com.province.demo.servicies;

import com.province.demo.models.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    Page<AppUser> findAll(Pageable pageable);

    List<AppUser> findAll();

    Optional<AppUser> findById(Long id);

    AppUser save(AppUser appUser);

    void remove(Long id);

    AppUser getUserByUsername(String username);
}
