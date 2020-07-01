package com.example.jpetstore.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
public class DeleteItem { 
	
	
	  @Autowired private PetStoreFacade petStore; public void
	  setPetStore(PetStoreFacade petStore) { this.petStore = petStore; }
	  
	  @RequestMapping("/shop/deleteItem.do") public String handleRequest(
	  
	  @RequestParam("itemId3") String itemId ) throws Exception {
	  petStore.deleteItem(itemId); return "index"; }
	 
	
	
	
}