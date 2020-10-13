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

import com.ranch.model.enums.ExpenseType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Expense")
@Getter
@Setter
public class Expense {
	@Id @Column(name="exp_id") @NotBlank
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long eid;
	
	@Column(name="exp_item")
	@NotBlank
	private String item;
	
	@Column(name="exp_type")
	@Enumerated(EnumType.STRING)
	private ExpenseType expType;
	
	@Column(name="amount")
	@NotBlank
	private double amount;

	/**
	 * @param eid
	 * @param item
	 * @param expType
	 * @param amount
	 */
	public Expense(@NotBlank long eid, @NotBlank String item, ExpenseType expType, @NotBlank double amount) {
		this.eid = eid;
		this.item = item;
		this.expType = expType;
		this.amount = amount;
	}

	/**
	 * @param item
	 * @param expType
	 * @param amount
	 */
	public Expense(@NotBlank String item, ExpenseType expType, @NotBlank double amount) {
		this.item = item;
		this.expType = expType;
		this.amount = amount;
	}
}
