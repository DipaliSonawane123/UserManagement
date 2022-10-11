package com.example.usermanagement.Repo;


import com.example.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM user WHERE  email_id = :email", nativeQuery = true)
    User findByEmail(String email);
}