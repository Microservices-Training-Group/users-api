package com.users.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.users.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

	@Query(value = "SELECT * FROM news a WHERE a.name=?1",nativeQuery = true)
	List<Users> findByName(String name);
}

	