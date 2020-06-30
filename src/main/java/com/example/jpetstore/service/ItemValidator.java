package com.example.jpetstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.jpetstore.controller.AuctionForm;
import com.example.jpetstore.controller.ItemForm;
import com.example.jpetstore.domain.Item;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Component
public class ItemValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Item.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		AuctionForm auctionForm = (AuctionForm)obj; 
		Item auctionItem = auctionForm.getAuctionItem();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auctionItem.itemId", "ID_REQUIRED", "item id is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auctionItem.listPrice", "LP_REQUIRED", "list price is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auctionItem.unitCost", "NC_REQUIRED", "unit cost is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auctionItem.attribute1", "ATTR_REQUIRED", "attribute is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auctionItem.product", "PID_REQUIRED", "product id is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auctionItem.product.categoryId", "CID_REQUIRED", "category id is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auctionItem.closingTime", "CT_REQUIRED", "closing time is required.");
	}
	
	public void validate2(Object obj, Errors errors) {
		
		ItemForm itemForm = (ItemForm)obj; 
		Item item = itemForm.getItem();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.itemId", "ID_REQUIRED", "item id is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.listPrice", "LP_REQUIRED", "list price is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.unitCost", "NC_REQUIRED", "unit cost is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.attribute1", "ATTR_REQUIRED", "attribute is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.product", "PID_REQUIRED", "product id is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.product.categoryId", "CID_REQUIRED", "category id is required.");

	}
	

}