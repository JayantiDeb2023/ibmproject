package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Associate;
import com.example.demo.model.Skills;
import com.example.demo.repo.AssociateRepository;
import com.example.demo.repo.SkillRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AssociateServiceImpl implements AssociateService{
	private final SkillRepository skillrepo;
	@Override
	public List<Associate> getallassociate() {
		// TODO Auto-generated method stub
		return associaterepo.findAll();
	}

	private AssociateRepository associaterepo;
	public Associate createAssociate(Associate associate) {
		Associate associate1=associaterepo.save(associate);
		if(associate1!=null)
		 return associate1;
		return null;
	}

	@Override
	public Associate findassociatebyid(int id) {
		Associate ass=associaterepo.findById(id).get();
		if(ass!=null)
			return ass;
		return null;
	}

	public String deleteassociatebyid(int id) {
		Associate ass=associaterepo.findById(id).get();
		String s=null;
		if(ass!=null)
			{associaterepo.delete(ass);
		    s="done";}
	    return s;
	}
   public Associate updateassociate(int id,Associate a)
   {
	   Associate ass=associaterepo.findById(id).get();
	   ass.setAssociatefirstname(a.getAssociatefirstname());
	   ass.setAssociatelastname(a.getAssociatelastname());
	   ass.setGender(a.getGender());
	   ass.setAssociatecountry(a.getAssociatecountry());
	   ass.setAssociatemobilenumber(a.getAssociatemobilenumber());
	   //ass.setSkillsid(ass.getSkillsid());
	   associaterepo.save(ass);
	   return ass;
	   
   }

@Override
public Associate findbyassociatecountry(String country) {
	// TODO Auto-generated method stub
	return associaterepo.FindByAssociatecountry(country);
}

@Override
public Associate FindByAssociateemail(String email) {
	// TODO Auto-generated method stub
	return associaterepo.FindByAssociateemail(email);
}

@Override
public Associate FindByAssociatemobile(String mobile) {
	// TODO Auto-generated method stub
	return associaterepo.FindByAssociatemobile(mobile);
}

@Override
public List<Associate> FindByAssociateskillname(String skillname) {
	List<Skills> skill=skillrepo.FindBySkillName(skillname);
	List<Integer> associateid=new ArrayList<>();
	List<Associate> associates=new ArrayList<Associate>();
	for(int i=0;i<skill.size();i++)
	{
		associateid.add(skill.get(i).getSkillid());
	}
	for(int i=0;i<associateid.size();i++)
	{
		Associate ass1=associaterepo.findById(associateid.get(i)).get();
		associates.add(ass1);
	}
	return associates;
}


  

}
