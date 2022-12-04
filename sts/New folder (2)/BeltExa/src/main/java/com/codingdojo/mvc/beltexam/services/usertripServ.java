package com.codingdojo.mvc.beltexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.beltexam.models.User;
import com.codingdojo.mvc.beltexam.models.usertrips;
import com.codingdojo.mvc.beltexam.repositries.usertripRepo;



@Service
public class usertripServ {
@Autowired
usertripRepo usertriprepo;
public usertrips findDate(User user) {
	return usertriprepo.findByuser(user);
}
public List<usertrips> findAll(){
	return  usertriprepo.findAll();
}
public usertrips create(usertrips i) {
	return usertriprepo.save(i);
}
}
