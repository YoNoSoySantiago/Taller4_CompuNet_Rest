package co.edu.icesi.dev.uccareapp.transport.controller.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces.CurrencyBusinessDelegate;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Currency;

@Controller
public class CurrencyControllerImp {
	
	private CurrencyBusinessDelegate currencyBusinessDelegate;

	@Autowired
	public CurrencyControllerImp(CurrencyBusinessDelegate currencyBusinessDelegate) {
		this.currencyBusinessDelegate = currencyBusinessDelegate;
	}
	
	@GetMapping("/currency")
	public String currencies(Model model) {
		model.addAttribute("currency", currencyBusinessDelegate.findAll());
		return "currency/currency/index";
	}
	
	@GetMapping("/currency/add")
	public String addCurrency(Model model) {		
		model.addAttribute("currency", new Currency());
		return "currency/currency/add-currency";
	}
	
	
	@PostMapping("/currency/add")
	public String saveCurrency(@ModelAttribute Currency currency, Model model, @RequestParam(value = "action", required = true) String action) {
		if (action != null && !action.equals("Cancel")) {
			currencyBusinessDelegate.add(currency);
		}
		return "redirect:/currency";
	}
	
	@GetMapping("/currency/edit/{id}")
	public String editCurrency(@PathVariable("id") String id,Model model) {
		Currency currency = currencyBusinessDelegate.findById(id);
		if(currency!=null) {
			model.addAttribute("currency", currency);
			return "currency/currency/add-currency";
		}
		return "redirect:/currency";
	}
	
	@PostMapping("/currency/edit/{id}")
	public String updateCurrency(@PathVariable("id") String id,
			@RequestParam(value = "action", required = true) String action,@ModelAttribute Currency currency, Model model) {
		if (action != null && !action.equals("Cancel")) {
			currencyBusinessDelegate.update(currency);
			
			model.addAttribute("currencies", currencyBusinessDelegate.findAll());
		}
		return "redirect:/currency";
	}
	
	@GetMapping("/currency/del/{id}")
	public String deleteCurrency(@PathVariable("id") String id, Model model) {
		Currency currency = currencyBusinessDelegate.findById(id);
		if(currency!=null) {
			
			currencyBusinessDelegate.delete(id);
			model.addAttribute("currencies", currencyBusinessDelegate.findAll());
		}
		return "redirect:/currency";
	}
}
