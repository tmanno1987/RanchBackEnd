package com.ranch.model;

public class ChargeRequest {
	private enum Currency { EUR, USD; }
	private String description;
	private int amount;
	private Currency currency;
	private String stripeEmail;
	private String stripeToken;
}