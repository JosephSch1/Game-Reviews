package com.coderscampus.gamereviews.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.gamereviews.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u" + " left join fetch u.authorities" + " where u.username = :username")
	User findByUserName(String userName);

	User findByUserId(Long id);

}
