package com.example.jpetstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.jpetstore.controller.AuctionForm;
import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Order;

@Component
public class AuctionFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Auction.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		AuctionForm auctionForm = (AuctionForm)target; 
		Item auctionItem = auctionForm.getAuctionItem();
		Auction auction = auctionForm.getAuction();
		double biddingprice = auction.getBiddingPrice();
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auctionItem.itemId", "CCN_REQUIRED", "FAKE (!) credit card number required.");
	}

}
