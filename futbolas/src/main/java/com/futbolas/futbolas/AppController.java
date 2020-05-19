package com.futbolas.futbolas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

	@Autowired
	private FutbolasService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHomePage(Model model, String keyword) {
		List<Futbolas> listFutbolas = service.listAll();
		model.addAttribute("listFutbolas", listFutbolas);


		return "index";
	}

	//search
	@GetMapping("listFutbolas")
	public String getProducts(Model model, String keyword){
		model.addAttribute("listFutbolas", service.findByKeyword(keyword));

		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Futbolas futbolas = new Futbolas();
		model.addAttribute("futbolas", futbolas);
		
		return "new_futbolas";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Futbolas futbolas) {
		service.save(futbolas);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_futbolas");
		Futbolas futbolas = service.get(id);
		mav.addObject("futbolas", futbolas);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}
