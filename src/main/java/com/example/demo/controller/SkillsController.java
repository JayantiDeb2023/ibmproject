package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.exception.SkillNotCreatedException;
import com.example.demo.exception.SkillNotFoundException;
import com.example.demo.model.Skills;
import com.example.demo.service.SkillsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/skills")
@AllArgsConstructor
public class SkillsController {
	private final SkillsService service;
	@PostMapping("/createskills")
	public ResponseEntity<Skills> createskills(@RequestBody Skills skill)
	{
		Skills skills=service.createskill(skill);
		if(skills==null)
		{
			throw new SkillNotCreatedException("Skill cannot be created");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(skills);
	}
   @ExceptionHandler
   public ResponseEntity<?> handleException(SkillNotCreatedException e)
   {
	   e.setErrorReportringTime(System.currentTimeMillis());
		e.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		StringBuffer sb=new StringBuffer();
		sb.append(e.getMessage());
		sb.append(e.getErrorReportringTime());
		sb.append(e.getStatusCode());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sb);
   }
   @GetMapping("/getskillsbyid/{id}")
   public ResponseEntity<Skills> getskillsbyid(@PathVariable("id") int id)
	{
		Skills skills=service.getskillsbyid(id);
		if(skills==null)
		{
			throw new SkillNotFoundException("Skill cannot be found");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(skills);
	}
   @ExceptionHandler
   public ResponseEntity<?> handleException(SkillNotFoundException e)
   {
	   e.setErrorReportringTime(System.currentTimeMillis());
		e.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		StringBuffer sb=new StringBuffer();
		sb.append(e.getMessage());
		sb.append(e.getErrorReportringTime());
		sb.append(e.getStatusCode());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sb);
   }
   @GetMapping("/getallskills")
   public ResponseEntity<List<Skills>> getallskills()
   {
	   return ResponseEntity.status(HttpStatus.FOUND).body(service.getallskills());
   }
   @PutMapping("/updateskills/{id}")
   public ResponseEntity<Skills> updateskills(@PathVariable("id") int id,@RequestBody Skills skill)
   {
	   Skills skill1=service.getskillsbyid(id);
	   if(skill1==null)
	   {
		   throw new SkillNotFoundException("skill cannot be found");
	   }
	   return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateskill(id,skill));
   }
   @DeleteMapping("/deleteskills/{id}")
   public ResponseEntity<String> deleteskills(@PathVariable("id") int id)
   {
	   Skills skill1=service.getskillsbyid(id);
	   if(skill1==null)
	   {
		   throw new SkillNotFoundException("skill cannot be found");
	   }
	   return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.deleteskills(id));
   }
}
