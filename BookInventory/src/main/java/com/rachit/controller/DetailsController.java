package com.rachit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rachit.model.Details;
import com.rachit.repo.DetailsRepository;


@RestController
public class DetailsController 
{

	@Autowired
	DetailsRepository repo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DetailsController.class);
	
	@RequestMapping(value = "/details/", method = RequestMethod.GET)
	public List<Details> getContacts() {
		LOGGER.info("display details");
		return repo.findAll();
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public Details getContact(@PathVariable("id") int id) {
		LOGGER.info("Finding details by ID:"+id);
		return repo.getById(id);
	}

	@RequestMapping(value = "/details/", method = RequestMethod.POST)
	public Details createDetails(@RequestBody Details details) {
		LOGGER.info("create details");
		return repo.save(details);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updateByInventory(@RequestParam(value = "user_name") String user_name, @RequestParam(value = "store") String store,
			@RequestParam(value = "book_name") String book_name, @RequestParam(value = "count") int count) {
		System.out.println(count);
		   repo.updateInventoryByBook(count, user_name, store, book_name);
		
	}
	

	@RequestMapping(value = "/details/{id}", method = RequestMethod.PUT)
	public Details updateContact(@RequestBody Details details, @PathVariable("id") int id) {
		LOGGER.info("update details");
		details.setId(id);
		return repo.save(details);
	}
	
	

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void deleteDetails(@RequestParam(value = "user_name") String user_name, @RequestParam(value = "store") String store,
			@RequestParam(value = "book_name") String book_name) {
		LOGGER.info("delete details");
		repo.deleteInventoryByBook(user_name, store, book_name);
	}	
	
	@RequestMapping(value = "/{user}", method = RequestMethod.GET)
	public List<String> findbyUser(@PathVariable("user") String user)
	{
	System.out.println(user);
	return repo.findByUser(user);	
	}
	
	@RequestMapping(value = "/{user}/{store}", method = RequestMethod.GET)
	public List<Object[]> findbyStore(@PathVariable("user") String user, @PathVariable("store") String store)
	{
	return repo.findByStore(user, store);
	}
	
}
