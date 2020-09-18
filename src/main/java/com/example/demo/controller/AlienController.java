package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepository;
import com.example.demo.model.AlienModel;
import com.example.demo.service.AlienService;


@Controller
public class AlienController {
	@Autowired
	AlienService alienService;
	@Autowired
	AlienRepository alienRepository;

	@RequestMapping("/addAlien")
	public String addAlien(@RequestBody AlienModel alienModel) {
		System.out.println("Alien is -" + alienModel);
		alienRepository.save(alienModel);
		return "home";
	}

	@RequestMapping(path = "/getAlien", consumes = { "application/json" })
	public ModelAndView getAlien(String aid) {
		ModelAndView mv = new ModelAndView("showalien");
		AlienModel alien = alienRepository.findById(Integer.parseInt(aid)).orElse(null);
		System.out.println("fetched object is " + alien);
		mv.addObject("alien", alien);
		return mv;
	}

	@RequestMapping(path = "/aliens", produces = { "application/xml" })
	@ResponseBody // here we are telling that don't expect string page name as return type in REST
	public List<AlienModel> getAliens() {
		// return alienRepository.findAll().toString();
		return alienRepository.findAll();
	}

	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<AlienModel> getSpecificAlien(@PathVariable("aid") int aid) {
		return alienRepository.findById(aid);
	}

	@PostMapping("/alien")
	@ResponseBody // Instaed of writing everytime we can even write it on top of method name
	              // @RestController if all methods are returning methods
	public AlienModel saveAlien(AlienModel alienModel) {
		System.out.println("Alien to be saved is -" + alienModel);
		alienRepository.save(alienModel);
		return alienModel;
	}

	@DeleteMapping(path = "/alien/{aid}")
	@ResponseBody
	public String deleteAlien(@PathVariable int aid) {
		AlienModel alienModel = alienRepository.getOne(aid);
		alienRepository.delete(alienModel);
		return "deleted";
	}

	@PutMapping(path = "/alien", consumes = { "application/json" })
	public AlienModel updateAlien(@RequestBody AlienModel alien) {
		alienRepository.save(alien);
		return alien;
	}

}
