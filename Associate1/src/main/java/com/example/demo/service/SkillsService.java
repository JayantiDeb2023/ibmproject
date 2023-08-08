package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Skills;

public interface SkillsService {
Skills createskill(Skills skill);
Skills getskillsbyid(int id);
List<Skills> getallskills();
Skills updateskill(int id,Skills skill);
String deleteskills(int id);
}
