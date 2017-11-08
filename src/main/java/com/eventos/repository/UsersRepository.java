package com.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventos.models.Users;

public interface UsersRepository extends JpaRepository<Users, String>{

	Users findByNome(String nome);
}
