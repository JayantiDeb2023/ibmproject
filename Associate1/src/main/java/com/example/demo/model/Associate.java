package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="associate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Associate {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int associateid;
private String associatefirstname;
private String associatelastname;
private String gender;
private Date dob;
private String associateemail;
private String associatecountry;
private String associatemobilenumber;
private String password;
//private List<Integer> Skillsid;

}
