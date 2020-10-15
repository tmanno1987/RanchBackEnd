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

@Entity
@Table(name="Expense")
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
	
	@Column(name="Note")
	private String note;
	
	/*****************************
	 * Constructor Instantiation *
	 *****************************/
	
	// default constructor
	public Expense() { super(); }
	
	// overloaded without expense id
	public Expense(@NotBlank String item, ExpenseType expType, @NotBlank double amount, String note) {
		this.item = item;
		this.expType = expType;
		this.amount = amount;
		this.note = note;
	}
	
	// overloaded constructor
	public Expense(@NotBlank long eid, @NotBlank String item, ExpenseType expType, @NotBlank double amount,
			String note) {
		this.eid = eid;
		this.item = item;
		this.expType = expType;
		this.amount = amount;
		this.note = note;
	}
	
		/****************
		 * Getter Setup *
		 ****************/

	/**
	 * @return the eid
	 */
	public long getEid() {
		return eid;
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @return the expType
	 */
	public ExpenseType getExpType() {
		return expType;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	
	/****************
	 * Setter Setup *
	 ****************/

	/**
	 * @param eid the eid to set
	 */
	public void setEid(long eid) {
		this.eid = eid;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @param expType the expType to set
	 */
	public void setExpType(ExpenseType expType) {
		this.expType = expType;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
}