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
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Feed")
public class Feed {
	@Id @Column(name="feed_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long fid;
	
	@Column(name="name")
	@NotBlank
	private String name;
	
	@OneToMany(mappedBy="fid", targetEntity=Cattle.class, cascade=CascadeType.ALL)
	private Set<Cattle> cid;
	
	@Column(name="stock")
	private int stock = 1;
	
	@Column(name="photoUrl")
	private String photoUrl;
	
	/*****************************
	 * Constructor Instantiation *
	 *****************************/
	
	// default constructor
	public Feed() { super(); }
	
	// overloaded constructor minus feed id field
	public Feed(@NotBlank String name, Set<Cattle> cid, int stock, String photoUrl) {
		this.name = name;
		this.cid = cid;
		this.stock = stock;
		this.photoUrl = photoUrl;
	}
	
	// overloaded constructor
	public Feed(long fid, @NotBlank String name, Set<Cattle> cid, int stock, String photoUrl) {
		this.fid = fid;
		this.name = name;
		this.cid = cid;
		this.stock = stock;
		this.photoUrl = photoUrl;
	}
	
		/****************
		 * Getter Setup *
		 ****************/

	/**
	 * @return the feed id
	 */
	public long getFid() {
		return fid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the cattle id
	 */
	public Set<Cattle> getCid() {
		return cid;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
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
	 * @param fid the feed id to set
	 */
	public void setFid(long fid) {
		this.fid = fid;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param cid the cattle id to set
	 */
	public void setCid(Set<Cattle> cid) {
		this.cid = cid;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}