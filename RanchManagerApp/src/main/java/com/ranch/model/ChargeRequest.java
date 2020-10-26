package com.ranch.model;

import com.ranch.model.enums.Currency;

public class ChargeRequest {
	private String description;
	private int amount;
	private Currency currency;
	private String stripeEmail;
	private String stripeToken;
	
	public ChargeRequest() { }
	
	/**
	 * @param description
	 * @param amount
	 * @param currency
	 * @param stripeEmail
	 * @param stripeToken
	 */
	public ChargeRequest(String description, int amount, Currency currency, String stripeEmail, String stripeToken) {
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.stripeEmail = stripeEmail;
		this.stripeToken = stripeToken;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}
	/**
	 * @return the stripeEmail
	 */
	public String getStripeEmail() {
		return stripeEmail;
	}
	/**
	 * @return the stripeToken
	 */
	public String getStripeToken() {
		return stripeToken;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	/**
	 * @param stripeEmail the stripeEmail to set
	 */
	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}
	/**
	 * @param stripeToken the stripeToken to set
	 */
	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}
}