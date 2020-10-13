package com.ranch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Mixes")
@Getter
@Setter
public class Mix {
	@Id @Column(name="mix_id") @NotBlank
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long mid;
	
	@Column(name="food_id")
	@NotBlank
	private long fid;
	
	@Column(name="percent")
	@NotBlank
	@Digits(fraction = 2, integer = 2)
	private double percent;
	
//	private Feed food;
}