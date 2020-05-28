package com.province.demo.repositories;

import com.province.demo.models.Oder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OderRepository extends PagingAndSortingRepository<Oder, Long> {
}
