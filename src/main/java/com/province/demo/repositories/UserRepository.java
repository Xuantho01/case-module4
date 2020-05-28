package com.province.demo.repositories;

import com.province.demo.models.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<AppUser, Long> {

    AppUser getAppUserByUsername(String username);

}
