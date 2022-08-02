package com.School.app.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	static User findByidIgnoreCase(long id) {
		return null;
	}
	
	boolean existByPhoneNo(long phoneNo);

}
