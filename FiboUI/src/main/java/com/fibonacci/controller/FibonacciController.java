package com.fibonacci.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fibonacci.model.Fibonacci;


@SuppressWarnings("unused")
@Controller
public class FibonacciController {
	
	@Value("${api.backEndUrl}")
	private String apiURL; 
	
	@GetMapping(value = "/index")
	public String get(Model model) {
		Fibonacci fb = new  Fibonacci();
		model.addAttribute("fb", fb);
	    return "index";
	}
	
	@PostMapping(value = "/fibonacci")
	public String result(@ModelAttribute("fb") Fibonacci fb, Model model) {
		int number = fb.getNumber();
		System.out.println(apiURL);
		// rest
		final RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("rawtypes")
		final List response = restTemplate
				.getForObject(apiURL + "/fibonacci?number="+number, List.class);

	    model.addAttribute("fibResult", response);
	    return "result";
	}
}
