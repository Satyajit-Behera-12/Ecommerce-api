package com.EcommerceApplication.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user") 
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; 

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

	public String getUsername() {
		return null;
	}

	public Role getRole() {
		return null;
	}

	public String getPassword() {
		return null;
	}

	public void setPassword(String encode) {
		
	}

    
}
