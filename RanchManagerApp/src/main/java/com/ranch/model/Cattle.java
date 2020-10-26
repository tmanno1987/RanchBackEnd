package com.ranch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ranch.model.enums.SexType;

@Entity
@Table(name="Cattle")
public class Cattle {
	@Id @Column(name="cattle_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Column(name="sex")
	@Enumerated(EnumType.STRING)
	private SexType sex;
	
	@ManyToOne
	@JoinColumn(name="breed", nullable=false)
	private CattleCategory category;
	
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
	
	@Column(name="photoUrl")
	private String photoUrl;
	
	/*****************************
	 * Constructor Instantiation *
	 *****************************/
	
	// default constructor
	public Cattle() { super(); }
	
	/**
	 * @param sex
	 * @param category
	 * @param bday
	 * @param check
	 * @param age
	 * @param price
	 * @param photoUrl
	 */
	public Cattle(@NotBlank SexType sex, CattleCategory category, @NotBlank Date bday, @NotBlank Date check,
			@NotBlank @Digits(fraction = 0, integer = 8) int age,
			@Digits(fraction = 2, integer = 8) @NotBlank double price, String photoUrl) {
		this.sex = sex;
		this.category = category;
		this.bday = bday;
		this.check = check;
		this.age = age;
		this.price = price;
		this.photoUrl = photoUrl;
	}

	/**
	 * @param id
	 * @param sex
	 * @param category
	 * @param bday
	 * @param check
	 * @param age
	 * @param price
	 * @param photoUrl
	 */
	public Cattle(long id, @NotBlank SexType sex, CattleCategory category, @NotBlank Date bday, @NotBlank Date check,
			@NotBlank @Digits(fraction = 0, integer = 8) int age,
			@Digits(fraction = 2, integer = 8) @NotBlank double price, String photoUrl) {
		this.id = id;
		this.sex = sex;
		this.category = category;
		this.bday = bday;
		this.check = check;
		this.age = age;
		this.price = price;
		this.photoUrl = photoUrl;
	}

		/****************
		 * Getter Setup *
		 ****************/
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the sex
	 */
	public SexType getSex() {
		return sex;
	}

	/**
	 * @return the birthday
	 */
	public Date getBday() {
		return bday;
	}

	/**
	 * @return the check
	 */
	public Date getCheck() {
		return check;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}
	
		/****************
		 * Setter Setup *
		 ****************/

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param sex the animal sex to set
	 */
	public void setSex(SexType sex) {
		this.sex = sex;
	}

	/**
	 * @param bday the birthday to set
	 */
	public void setBday(Date bday) {
		this.bday = bday;
	}

	/**
	 * @param check the last check up date to set
	 */
	public void setCheck(Date check) {
		this.check = check;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	/**
	 * @return the category
	 */
	public CattleCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(CattleCategory category) {
		this.category = category;
	}
}