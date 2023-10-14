package com.taco.TacoCloud.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import com.taco.TacoCloud.TacoOrder;
import com.taco.TacoCloud.repository.jdbc.OrderRepository;
@Slf4j
@Controller
@RequestMapping ("/orders")
@SessionAttributes ("tacoOrder")
public class OrderController {
	
	private OrderRepository orderRepo;
	
	public OrderController (OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	@GetMapping("/current")
	public String orderForm(Model model) {
	    return "orderForm";
	}
	
	
	@PostMapping
	   public String processOrder(@Valid TacoOrder order, Errors e,
			   SessionStatus sessionStatus) {
		if(e.hasErrors()) {
			return "orderForm";
		}
		   orderRepo.save(order);
		   sessionStatus.setComplete();
		   
		   return "redirect:/";
	   }

   }