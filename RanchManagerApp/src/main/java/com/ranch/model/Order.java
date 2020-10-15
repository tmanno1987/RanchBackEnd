package com.ranch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Orders")
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
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false, updatable=false)
	private Users user;
	
	@Column(name="order_price")
	@Digits(fraction=2,integer=8)
	private double price;
	
	// default constructor
	public Order() { super(); }

	/**
	 * @param name
	 * @param numOrdered
	 * @param user
	 * @param price
	 */
	public Order(@NotBlank String name, @NotBlank int numOrdered, Users user,
			@Digits(fraction = 2, integer = 8) double price) {
		this.name = name;
		this.numOrdered = numOrdered;
		this.user = user;
		this.price = price;
	}

	/**
	 * @param oid
	 * @param name
	 * @param numOrdered
	 * @param user
	 * @param price
	 */
	public Order(long oid, @NotBlank String name, @NotBlank int numOrdered, Users user,
			@Digits(fraction = 2, integer = 8) double price) {
		this.oid = oid;
		this.name = name;
		this.numOrdered = numOrdered;
		this.user = user;
		this.price = price;
	}

	/**
	 * @return the oid
	 */
	public long getOid() {
		return oid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the numOrdered
	 */
	public int getNumOrdered() {
		return numOrdered;
	}

	/**
	 * @return the user
	 */
	public Users getUser() {
		return user;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param oid the oid to set
	 */
	public void setOid(long oid) {
		this.oid = oid;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param numOrdered the numOrdered to set
	 */
	public void setNumOrdered(int numOrdered) {
		this.numOrdered = numOrdered;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Users user) {
		this.user = user;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}
//@ManyToOne
//@JoinColumn(name="DEPT_ID", nullable=false, updatable=false, )
//
//private Department d;
//**referencedColumnName
//@OneToMany(orphanRemoval = true, mappedBy = "d", fetch = FetchType.LAZY)
//private List<Employee> empList;
