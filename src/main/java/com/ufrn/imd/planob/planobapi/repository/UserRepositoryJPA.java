package com.ufrn.imd.planob.planobapi.repository;

import com.ufrn.imd.planob.planobapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepositoryJPA extends JpaRepository<User, String> {

}
