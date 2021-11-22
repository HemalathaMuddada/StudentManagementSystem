package com.project.sms.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="principal")
@Data
@NoArgsConstructor
@AllArgsConstructor	
public class Principal {
	@Id
	@Column(name="Hod_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String first_name;
	private String Last_name;
	private String email;
	private String username;
	private String password;
	
	
}
