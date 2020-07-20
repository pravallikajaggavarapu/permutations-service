package com.permutations.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.permutations.service.PermutationService;


@CrossOrigin
@RestController
public class PermutationController {
	
	@Autowired
	PermutationService permutationService;
	
	@PostMapping("/permutations")
	public Set<String> getPermutations(@RequestBody String id)
	{
		Set<String> permutataions  = permutationService.getPermutations(id);
				
				return permutataions;
	}

}
