package com.example.ValueAndConfiguration.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {

	@Value("${name:my Default value}")
	private String name;

	@Value("${price}")
	private int price;
	
	@Value("${values}")
	private List<String> values;
	
	@Value("#{${valuesMap}.?[value > 1]}")
	private Map<String, Integer> valuesMap;
	
	@Value("#{${valuesMap}.key1}")
	private int key1;
	
	@Value("#{${valuesMap}['key5'] ?: 15}")
	private int key5;
	
	@Value("#{${unknownMap : {key1 : 1 , key2: 2}}}")
	private Map<String, Integer> unknownMap;

	@GetMapping("/values")
	public String values() {
		return name + ":->" + price + ":" + key1 + ":" + key5;
	}
	
	@GetMapping("/listValues")
	public List<String> listValues() {
		return values;
	}
	
	@GetMapping("/mapValues")
	public Map<String, Integer> mapValues() {
		return unknownMap;
	}


}
