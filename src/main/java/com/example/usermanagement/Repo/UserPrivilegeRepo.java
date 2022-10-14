package com.example.usermanagement.Repo;

import com.example.usermanagement.model.UserPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface to save data in SQL by using abstraction of JPARepository inbuilt class
 */
@Repository
public interface UserPrivilegeRepo extends JpaRepository<UserPrivilege, Integer> {

}
