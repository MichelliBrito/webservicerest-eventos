package com.eventos.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
    private String nomeRole;
	
	
	public String getNomeRole() {
		return nomeRole;
	}


	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nomeRole;
	}

}
