package com.sgr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;
    
    @Column(name="rol")
    private String rol;

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", rol=" + rol + "]";
	}

}
