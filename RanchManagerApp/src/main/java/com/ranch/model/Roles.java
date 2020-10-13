package com.ranch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.ranch.model.enums.EnumRoles;

@Entity
@Table(name="Roles_Table")
public class Roles {
	@Id @Column(name="role_id", nullable=false)
	@NotBlank
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rid;
	
	@NotBlank
	@Column(name="role_names")
	@Enumerated(EnumType.STRING)
	private EnumRoles name;
	
	public Roles() { }
	
	public Roles(EnumRoles name) {
		this.name = name;
	}

	/**
	 * @return the rid
	 */
	public long getId() {
		return rid;
	}

	/**
	 * @param rid the rid to set
	 */
	public void setId(long rid) {
		this.rid = rid;
	}

	/**
	 * @return the title
	 */
	public EnumRoles getTitle() {
		return name;
	}

	/**
	 * @param title the title to set
	 */
	public void setName(EnumRoles name) {
		this.name = name;
	}
}