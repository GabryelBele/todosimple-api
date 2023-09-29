package com.gabryelbele.todosimple.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabryelbele.todosimple.models.User;
import com.gabryelbele.todosimple.repositories.UserRepository;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    @Transactional
    public User create(User user) {
        user.setId(null);
        user = this.userRepository.save(user);
        return user;
    }

    @Transactional
    public User update(User obj) {
       User newObj = findById(obj.getId());
       newObj.setPassword(obj.getPassword());
    
       return this.userRepository.save(newObj);
    }
    

    public void delete(Long id) {
        findById(id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir, pois há entidades relacionadas!");
        }
    }
}
