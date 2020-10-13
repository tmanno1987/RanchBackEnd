package com.ranch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Orders")
@Getter
@Setter
public class Order {
	@Id @Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	
	@Column(name="order_name", length=50)
	@NotBlank
	private String name;
	
	@Column(name="order_amount")
	@NotBlank
	private int numOrdered;
	
	@Column(name="user")
	@NotBlank
	private long uid;
	
	@ManyToOne
	@JoinColumn(name="uid", nullable=false, updatable=false)
	private Users user;

	/**
	 * @param name
	 * @param numOrdered
	 * @param uid
	 */
	public Order(@NotBlank String name, @NotBlank int numOrdered, @NotBlank long uid) {
		this.name = name;
		this.numOrdered = numOrdered;
		this.uid = uid;
	}

	/**
	 * @param oid
	 * @param name
	 * @param numOrdered
	 * @param uid
	 * @param user
	 */
	public Order(long oid, @NotBlank String name, @NotBlank int numOrdered, @NotBlank long uid, Users user) {
		this.oid = oid;
		this.name = name;
		this.numOrdered = numOrdered;
		this.uid = uid;
		this.user = user;
	}
}
//@ManyToOne
//@JoinColumn(name="DEPT_ID", nullable=false, updatable=false, )
//
//private Department d;
//**referencedColumnName
//@OneToMany(orphanRemoval = true, mappedBy = "d", fetch = FetchType.LAZY)
//private List<Employee> empList;
