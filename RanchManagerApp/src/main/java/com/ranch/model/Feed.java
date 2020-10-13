package com.ranch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Feed")
@Getter
@Setter
public class Feed {
	@Id @Column(name="feed_id") @NotBlank
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long fid;
	
	@Column(name="name")
	@NotBlank
	private String name;
	
	@Column(name="cost")
	@NotBlank
	private long eid;
	
	@Column(name="stock")
	@NotBlank
	private int stock;
	
//	@OneToOne
//	private Expense exp;
}