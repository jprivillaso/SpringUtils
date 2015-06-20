package com.springTutorial.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springTutorial.entities.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{

}
