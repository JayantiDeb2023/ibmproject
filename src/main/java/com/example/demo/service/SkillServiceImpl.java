package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Skills;
import com.example.demo.repo.SkillRepository;
import com.example.demo.service.SkillsService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SkillServiceImpl implements SkillsService{
	private final SkillRepository repo;
	public Skills createskill(Skills skill) {
		return repo.save(skill);
	}

	@Override
	public Skills getskillsbyid(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Skills> getallskills() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Skills updateskill(int id,Skills skill) {
		Skills k=repo.findById(id).get();
		if(k!=null)
		{
			k.setSkillname(skill.getSkillname());
			k.setStartdate(skill.getStartdate());
			k.setEnddate(skill.getEnddate());
			repo.save(k);
			return k;
		}
		return null;
	}

	@Override
	public String deleteskills(int id) {
		String s=null;
		Skills k=repo.findById(id).get();
		if(k!=null)
		{repo.delete(k);
		 s="done";
		}
		return s;
	}

}
