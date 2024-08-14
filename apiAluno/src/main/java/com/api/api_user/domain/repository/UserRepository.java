package com.api.api_user.domain.repository;

import com.api.api_user.domain.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long>  {

    @Query("SELECT u FROM User u WHERE u.login = ?1 and u.senha = ?2")
    User findUserByLoginAndPassword(String login, String password);

    @Query("SELECT u FROM User u WHERE u.nome like ?1")
    List<User> findUserByName(String nome);

    @Query("SELECT u FROM User u WHERE u.login like ?1")
    List<User> findUserByLogin(String login);
}
