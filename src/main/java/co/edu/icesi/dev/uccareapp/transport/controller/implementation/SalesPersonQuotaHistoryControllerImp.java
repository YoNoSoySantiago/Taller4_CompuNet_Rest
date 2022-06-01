package co.edu.icesi.dev.uccareapp.transport.controller.implementation;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.dev.uccareapp.transport.business.delegate.interfaces.SalesPersonQuotaHistoryBusinessDelegate;
import co.edu.icesi.dev.uccareapp.transport.model.sales.Salespersonquotahistory;
import co.edu.icesi.dev.uccareapp.transport.repository.SalesPersonRepository;

@Controller
public class SalesPersonQuotaHistoryControllerImp {
	
	SalesPersonQuotaHistoryBusinessDelegate salesPersonQuotaHistoryBusinesDelegate;
	SalesPersonRepository salesPersonRepository;
	
	public SalesPersonQuotaHistoryControllerImp(SalesPersonQuotaHistoryBusinessDelegate spqhs, SalesPersonRepository spr) {
		this.salesPersonQuotaHistoryBusinesDelegate = spqhs;
		this.salesPersonRepository = spr;
	}
	
	@GetMapping("/sales_persons_history")
	public String salesTerritories(Model model) {
		model.addAttribute("persons_history", salesPersonQuotaHistoryBusinesDelegate.findAll());
		return "history/person/index";
	}
	
	@GetMapping("/sales_persons_history/add")
	public String addSalesTerritory(Model model) {
		model.addAttribute("salespersonquotahistory", new Salespersonquotahistory());
		model.addAttribute("sales_persons", salesPersonRepository.findAll());
		return "history/person/add-sales-person-quota-history";
	}
	
	@PostMapping("/sales_persons_history/add")
	public String saveSalesTerritory(@Validated @ModelAttribute Salespersonquotahistory salespersonquotahistory,
			BindingResult bindingResult,Model model, @RequestParam(value = "action", required = true) String action) {
			if (action != null && !action.equals("Cancel")) {
				try {
					if(bindingResult.hasErrors()) {
						model.addAttribute("salespersonquotahistory", salespersonquotahistory);
						model.addAttribute("sales_persons", salesPersonRepository.findAll());
						return "history/person/add-sales-person-quota-history";
					}
					
					salespersonquotahistory.setModifieddate(Timestamp.valueOf(LocalDateTime.now()));
					salesPersonQuotaHistoryBusinesDelegate.add(salespersonquotahistory);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return "redirect:/sales_persons_history";
	}
	
	@GetMapping("/sales_persons_history/edit/{id}")
	public String editSalesTerritory(@PathVariable("id") int id,Model model) {
		Salespersonquotahistory person_history = salesPersonQuotaHistoryBusinesDelegate.findById(id);
		if(person_history!=null) {
			model.addAttribute("salespersonquotahistory", person_history);
			model.addAttribute("sales_persons", salesPersonRepository.findAll());
			return "history/person/update-sales-person-quota-history";
		}
		return "redirect:/sales_persons_history";
	}
	
	@PostMapping("/sales_persons_history/edit/{id}")
	public String updateSalesPersonHistory(@PathVariable("id") int id,@Validated @ModelAttribute Salespersonquotahistory salespersonhistory, 
			BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action) {
		
		if (action != null && !action.equals("Cancel")) {
			salespersonhistory.setId(id);
			if(bindingResult.hasErrors()) {
				model.addAttribute("salespersonquotahistory", salespersonhistory);
				model.addAttribute("sales_persons", salesPersonRepository.findAll());
				return "history/person/update-sales-person-quota-history";
			}
			try {
				salespersonhistory.setModifieddate(Timestamp.valueOf(LocalDateTime.now()));
				salesPersonQuotaHistoryBusinesDelegate.update(salespersonhistory);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("persons_history", salesPersonQuotaHistoryBusinesDelegate.findAll());
		}
		return "redirect:/sales_persons_history";
	}
	
	@GetMapping("/sales_persons_history/del/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		Salespersonquotahistory person_history = salesPersonQuotaHistoryBusinesDelegate.findById(id);
		if(person_history!=null) {
			salesPersonQuotaHistoryBusinesDelegate.delete(person_history.getId());
			model.addAttribute("persons_history", salesPersonQuotaHistoryBusinesDelegate.findAll());
		}
		return "redirect:/sales_persons_history";
	}
	
	@GetMapping("/sales_persons_history/sales_person_info/{id}")
	public String showSalesPersonInfo(@PathVariable("id") int id, Model model) {
		model.addAttribute("back", "/sales_persons_history");
		model.addAttribute("salesperson", salesPersonRepository.findById(id).get());
		return "sales/person/info-sales-person";
	}
}
