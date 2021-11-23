package com.project.sms.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "college", uniqueConstraints = { @UniqueConstraint(columnNames = { "college_code" }) })
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class College {
@Id
	private int id;
	private String college_name;
	private int college_code;
}
