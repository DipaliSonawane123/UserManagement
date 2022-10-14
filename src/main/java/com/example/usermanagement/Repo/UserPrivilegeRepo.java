package com.example.usermanagement.Repo;

import com.example.usermanagement.model.UserPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrivilegeRepo extends JpaRepository<UserPrivilege, Integer> {

}
