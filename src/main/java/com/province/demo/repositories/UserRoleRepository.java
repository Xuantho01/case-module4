package com.province.demo.repositories;

import com.province.demo.models.UserRole;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long> {
}
