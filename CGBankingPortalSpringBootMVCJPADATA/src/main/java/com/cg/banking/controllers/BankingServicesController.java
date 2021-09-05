package com.cg.banking.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.services.BankingServices;;

@Controller
public class BankingServicesController {
	
	@Autowired
	BankingServices bankingServices;
@RequestMapping("/registerAssociate")
	public ModelAndView registerAssociate(Account account) throws InvalidAccountTypeException, InvalidAmountException, BankingServicesDownException {
	//if(result.hasErrors()) return new ModelAndView("registrationPage");
		account=bankingServices.openAccount(account);
		return new ModelAndView("createAccountSucces", "associate", account);
}
}
