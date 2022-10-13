package com.example.usermanagement.Repo;

import com.example.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM user WHERE  email_id = :email", nativeQuery = true)
    User findByEmail(String email);
    @Query(value = "SELECT * FROM user WHERE age <18 ", nativeQuery = true)
    List<User> findByAgeUnder18();
    @Query(value = "SELECT * FROM user WHERE age between 18 and 40 ", nativeQuery = true)
   List<User> findByAge();
    @Query(value = "SELECT * FROM user WHERE age >40 ", nativeQuery = true)
    List<User> findByAgeAbove40();

    @Query(value = "SELECT * FROM user WHERE  address LIKE :address% ", nativeQuery = true)
    List<User> findByAddress(String address);
    @Query(value = "SELECT * FROM user WHERE  gender = :gender", nativeQuery = true)
    List<User> findByGender(String gender);
    @Query(value = "SELECT * FROM user ORDER BY created_time_stamp DESC LIMIT 10 ", nativeQuery = true)
   List<User>  getRecentTegistration();
    @Query(value = "SELECT * FROM user ORDER BY created_time_stamp  ", nativeQuery = true)
    List<User> getAllregistration();


}