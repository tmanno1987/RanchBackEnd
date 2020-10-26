package com.ranch.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cattle_category")
public class CattleCategory {
	@Id @Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="breed")
	private String breed;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="category")
	private Set<Cattle> cattle;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return breed;
	}

	/**
	 * @return the cattle
	 */
	public Set<Cattle> getCattle() {
		return cattle;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.breed = name;
	}

	/**
	 * @param cattle the cattle to set
	 */
	public void setCattle(Set<Cattle> cattle) {
		this.cattle = cattle;
	}
}