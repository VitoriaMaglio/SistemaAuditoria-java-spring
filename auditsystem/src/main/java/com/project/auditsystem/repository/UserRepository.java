package com.project.auditsystem.repository;

import com.project.auditsystem.dto.response.UserResponseDTO;
import com.project.auditsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//Data JPA já possui métodos de ações no banco -> só adicionar no JpaRepository quando a consulta não existe e envolve regra de busca específica
    //CREATEUSER -> POST
    //validar se já existe user com email cadastrado
    boolean existsByEmail(String email);

    //para usuário fazer login
    Optional<User> findByEmail(String email);

    //Soft delete

    Optional<User> findByIdAndActiveTrue(Long id);
    Optional<User> findByEmailAndActiveTrue(String email);

    //Não estou fazendo getAllUsers pois para isso é necesário ser funcionário,admin do sistema -> Melhorar lógica

}
