package com.ranch.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ranch.services.StripeService;

@Controller
public class PaymentController {
	@Value("${STRIPE_PUBLIC_KEY}")
	private String stripePubKey;
	
	@Autowired
	private StripeService stripeServ;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("amount", 50 * 100);
		model.addAttribute("stripePublicKey", stripePubKey);
		return "index";
	}
	
	@PostMapping(value="/charge")
	public String chargeCard(HttpServletRequest req) throws Exception {
		String tok = req.getParameter("stripeToken");
		Double amount = Double.parseDouble(req.getParameter("amount"));
		stripeServ.chargeNewCard(tok, amount);
		return "result";
	}
}


