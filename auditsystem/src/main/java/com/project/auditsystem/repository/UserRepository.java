package com.project.auditsystem.repository;

import com.project.auditsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //validar se já existe user com email cadastrado
    boolean existsByEmail(String email);

    //para usuário fazer login
    Optional<User> findByEmail(String email);
}
