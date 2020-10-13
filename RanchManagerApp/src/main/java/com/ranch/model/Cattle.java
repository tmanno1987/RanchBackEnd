package com.ranch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.ranch.model.enums.CattleTypes;
import com.ranch.model.enums.SexType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Cattle")
@Getter
@Setter
public class Cattle {
	@Id @Column(name="cattle_id")
	@NotBlank
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Column(name="name")
	private String name;
	
	@NotBlank
	@Column(name="sex")
	@Enumerated(EnumType.STRING)
	private SexType sex;
	
	@NotBlank
	@Column(name="cattle_type")
	@Enumerated(EnumType.STRING)
	private CattleTypes breed;
	
	@NotBlank
	@Column(name="birthday")
	@Temporal(TemporalType.DATE)
	private Date bday;
	
	@NotBlank
	@Column(name="last_check")
	@Temporal(TemporalType.DATE)
	private Date check;
	
	@NotBlank
	@Column(name="age")
	@Digits(fraction = 0, integer = 8)
	private int age;
	
	@Column(name="price")
	@Digits(fraction=2,integer=8)
	@NotBlank
	private double price;
	
	@NotBlank
	@Column(name="food_type")
	private long fid;
	
	@ManyToOne
	private Mix mix;
}












