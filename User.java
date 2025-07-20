package com.EcommerceApplication.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user") // or whatever your table name is
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; 

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public Role getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}

    
}
