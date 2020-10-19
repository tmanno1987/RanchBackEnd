package com.ranch.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ranch.model.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.model.Charge;

@Service
public class StripeService {
	@Value("${STRIPE_SECRET_KEY}")
	private String API_SECRET_KEY;
	
	@Autowired
	public StripeService() {
		Stripe.apiKey = API_SECRET_KEY;
	}
	
	public Charge chargeNewCard(String tok, double amt) throws Exception {
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", (int)(amt * 100));
		chargeParams.put("currency", "USD");
		chargeParams.put("source", tok);
		Charge crg = Charge.create(chargeParams);
		return crg;
	}
	
	public Charge charge(ChargeRequest creq) throws Exception {
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", creq.getAmount());
		chargeParams.put("currency", creq.setCurrency("USD").getCurrency());
		chargeParams.put("source", creq.getStripeToken());
		chargeParams.put("description", creq.getDescription());
		return Charge.create(chargeParams);
	}
}








