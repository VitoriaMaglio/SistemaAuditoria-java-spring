package com.project.auditsystem.controller;

import com.project.auditsystem.dto.request.UserRequestDTO;
import com.project.auditsystem.dto.response.UserResponseDTO;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsável por expor os endpoints REST
 * relacionados ao gerenciamento de usuários do sistema.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //User pode fazer post,get,delete(lógica de inativação) e put


    public UserController(UserService userService) {
        this.userService = userService;
    }
    //Criar um user
    //Método tipo ResponseEntity parametrizado com UserResponseDTO pois o retorno do método é responsedto
    //@RequestBody pois vai pedir inserção de dados do tipo dtoRequest
    //chamar o service
    //retornar status code
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDto){
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    //Método para buscar um user pelo id
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        UserResponseDTO userResponseDTO = userService.getUserById(id);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO dto){
        UserResponseDTO userResponseDTO = userService.updateUser(id,dto);
        return
                ResponseEntity.ok(userResponseDTO);
    }

    //Soft delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
