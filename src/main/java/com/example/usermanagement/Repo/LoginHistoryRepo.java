package com.example.usermanagement.Repo;

import com.example.usermanagement.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginHistoryRepo extends JpaRepository<LoginHistory, Integer> {
    @Query(value = "SELECT * FROM login_historys WHERE email_id =:email  ", nativeQuery = true)
    List<LoginHistory> findbyemail(String email);
}
