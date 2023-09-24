package com.gabryelbele.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabryelbele.todosimple.models.User;

@Repository
public interface UserReposirory extends JpaRepository<User, Long> {

}
