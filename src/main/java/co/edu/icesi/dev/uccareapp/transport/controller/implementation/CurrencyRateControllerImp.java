package co.edu.icesi.dev.uccareapp.transport.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces.CurrencyRateBusinessDelegate;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Currency;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Currencyrate;


@Controller
public class CurrencyRateControllerImp {

	private CurrencyRateBusinessDelegate currencyRateBusinessDelegate;

	@Autowired
	public CurrencyRateControllerImp(CurrencyRateBusinessDelegate currencyBusinessDelegate) {
		this.currencyRateBusinessDelegate = currencyBusinessDelegate;
	}
	
	@GetMapping("/currency_rate")
	public String currencyRates(Model model) {
		model.addAttribute("currency_rate", currencyRateBusinessDelegate.findAll());
		return "currency/rate/index";
	}
	
	@GetMapping("/currency_rate/add")
	public String addCurrencyRate(Model model) {		
		model.addAttribute("currency_rate", new Currency());
		return "currency/rate/add-currency-rate";
	}
	
	
	@PostMapping("/currency_rate/add")
	public String saveCurrencyRate(@ModelAttribute Currencyrate currency, Model model, @RequestParam(value = "action", required = true) String action) {
		if (action != null && !action.equals("Cancel")) {
			currencyRateBusinessDelegate.add(currency);
		}
		return "redirect:/currency_rate";
	}
	
	@GetMapping("/currency_rate/edit/{id}")
	public String editCurrencyRate(@PathVariable("id") int id,Model model) {
		Currencyrate currency = currencyRateBusinessDelegate.findById(id);
		if(currency!=null) {
			model.addAttribute("currency_rate", currency);
			return "currency/rate/add-currency-rate";
		}
		return "redirect:/currency_rate";
	}
	
	@PostMapping("/currency_rate/edit/{id}")
	public String updateCurrencyRate(@PathVariable("id") int id,
			@RequestParam(value = "action", required = true) String action,@ModelAttribute Currencyrate currency, Model model) {
		if (action != null && !action.equals("Cancel")) {
			currencyRateBusinessDelegate.update(currency);
			
			model.addAttribute("currency_rates", currencyRateBusinessDelegate.findAll());
		}
		return "redirect:/currency_rate";
	}
	
	@GetMapping("/currency_rate/del/{id}")
	public String deleteCurrencyRate(@PathVariable("id") int id, Model model) {
		Currencyrate currency = currencyRateBusinessDelegate.findById(id);
		if(currency!=null) {
			
			currencyRateBusinessDelegate.delete(id);
			model.addAttribute("currency_rates", currencyRateBusinessDelegate.findAll());
		}
		return "redirect:/currency_rate";
	}
}
