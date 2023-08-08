package com.example.demo.controller;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.AssociateNotCreatedException;
import com.example.demo.exception.AssociateNotFoundException;
import com.example.demo.model.Associate;
import com.example.demo.service.AssociateService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/associate")
@AllArgsConstructor
public class AssociateController {
	private final AssociateService service;
	private final Environment env;
	@PostMapping("/createassociate")
	public ResponseEntity<Associate> createAssociate(@RequestBody Associate associate)
	{
		Associate associate1=service.createAssociate(associate);
		if(associate1==null)
		{
			throw new AssociateNotCreatedException("Associate cannot be created");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(associate1);
	}
	@GetMapping("/getallassociate")
	public ResponseEntity<List<Associate>> getallassociate()
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getallassociate());
	}
	@ExceptionHandler
	public ResponseEntity<?> handleException(AssociateNotCreatedException e)
		{e.setErrorReportringTime(System.currentTimeMillis());
		e.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		StringBuffer sb=new StringBuffer();
		sb.append(e.getMessage());
		sb.append(e.getErrorReportringTime());
		sb.append(e.getStatusCode());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sb);
	}
	@GetMapping("/getassociatebyid/{id}")
	public ResponseEntity<Associate> getAssociateById(@PathVariable("id") int id)
	{
		Associate associate1=service.findassociatebyid(id);
		if(associate1==null)
		{
			throw new AssociateNotFoundException("Associate cannot be found");
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(associate1);
	}
	@PutMapping("/updateassociate/{id}")
	public ResponseEntity<Associate> updateAssociate(@PathVariable("id") int id,@RequestBody Associate a)
	{
		Associate associate1=service.updateassociate(id, a);
		if(associate1==null)
		{
			throw new AssociateNotFoundException("Associate cannot be found");
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(associate1);
	}
	@DeleteMapping("/deleteassociate/{id}")
	public ResponseEntity<String> deleteAssociate(@PathVariable("id") int id)
	{
		String s=service.deleteassociatebyid(id);
		if(s==null)
		{
			throw new AssociateNotFoundException("Associate cannot be found");
		}
		return ResponseEntity.ok(s);
	}
	@GetMapping("/findassociatebycountry/{country}")
	public ResponseEntity<Associate> getAssociateByCountry(@PathVariable("country") String country)
	{
		Associate associate1=service.findbyassociatecountry(country);
		if(associate1==null)
		{
			throw new AssociateNotFoundException("Associate cannot be found");
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(associate1);
	}
	@GetMapping("/findassociatebyemail/{email}")
	public ResponseEntity<Associate> getAssociateByEmail(@PathVariable("email") String email)
	{
		Associate associate1=service.FindByAssociateemail(email);
		if(associate1==null)
		{
			throw new AssociateNotFoundException("Associate cannot be found");
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(associate1);
	}
	@GetMapping("/findassociatebymobilenumber/{mobilenumber}")
	public ResponseEntity<Associate> getAssociateByMobileNumber(@PathVariable("mobilenumber") String mobilenumber)
	{
		Associate associate1=service.FindByAssociatemobile(mobilenumber);
		if(associate1==null)
		{
			throw new AssociateNotFoundException("Associate cannot be found");
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(associate1);
	}
	@GetMapping("/findassociatebyskillname/{skillname}")
	public ResponseEntity<List<Associate>> getAssociateBySkill(@PathVariable("skillname") String skillname)
	{
		List<Associate> associate1=service.FindByAssociateskillname(skillname);
		if(associate1==null)
		{
			throw new AssociateNotFoundException("Associate cannot be found");
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(associate1);
	}
}
