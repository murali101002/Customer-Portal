package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dao.CustomerDao;
import com.project.entity.Customer;
import com.project.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//inject service for controller to call service which delegates calls to dao classes
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String showCustomers(Model model){
		List<Customer> customers = customerService.getCustomers();
		for(Customer cust:customers){
			System.out.println(cust.toString());
		}
		model.addAttribute("customers",customers);
		return "list-customers";
	}
	@GetMapping("/showFormToAdd")
	public String showFormToAdd(Model model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	@PostMapping("/addSuccess")
	public String saveCustomer(@ModelAttribute(name="customer") Customer customer){
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("customerId") Integer id, Model model){
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer",customer);
		return "customer-form";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") Integer id){
		Customer customer = customerService.getCustomer(id);
		customerService.removeCustomer(customer);
		return "redirect:/customer/list";
	}
	@PostMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String lastName, Model model){
		List<Customer> customers = customerService.getCustomersByName(lastName);
		model.addAttribute("customers", customers);
		return "list-customers";
	}
}
