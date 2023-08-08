package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Associate;

public interface AssociateService {
Associate createAssociate(Associate associate);
List<Associate> getallassociate();
Associate findassociatebyid(int id);
String deleteassociatebyid(int id);
Associate updateassociate(int id,Associate a);
Associate findbyassociatecountry(String country);
Associate FindByAssociateemail(String email);
Associate FindByAssociatemobile(String mobile);
List<Associate> FindByAssociateskillname(String skillname);
}
