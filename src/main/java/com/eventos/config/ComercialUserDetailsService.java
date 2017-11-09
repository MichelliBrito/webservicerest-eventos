package com.eventos.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.eventos.models.Users;
import com.eventos.repository.UsersRepository;


@Repository
public class ComercialUserDetailsService implements UserDetailsService{

	@Autowired
	private UsersRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Users user = ur.findByNome(nome);
		
	    if (user == null) {
	      throw new UsernameNotFoundException("Usuário não encontrado!");
	    }
		return user;
	}
	

}
