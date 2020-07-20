package com.permutations.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class PermutationService{
	
 public Set<String> getPermutations(String inputString) {
	
	 Set<String> permValue = new HashSet<String>();
	    if (inputString == "")
	        return permValue;

	    Character inputChar = inputString.charAt(0);

	    if (inputString.length() > 1)
	    {
	    	inputString = inputString.substring(1);

	        Set<String> permSet = getPermutations(inputString);

	        for (String s : permSet)
	        {
	            for (int i = 0; i <= s.length(); i++)
	            {
	            	permValue.add(s.substring(0, i) + inputChar + s.substring(i));
	            }
	        }
	    }
	    else
	    {
	    	permValue.add(inputChar + "");
	    }
	    return permValue;	 		
 }
 

}
