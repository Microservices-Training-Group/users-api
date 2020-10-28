package com.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.users.model.Users;
import com.users.repository.UsersRepository;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private UsersRepository usersRepository;

	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	public Object getById(int id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id);
	}

	public List<Users> getByName(String name) {
		// TODO Auto-generated method stub
		return usersRepository.findByName(name);
	}
	
	//edit user
	public Optional<Object> userEdit(Users users, int id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id).map(mapper -> {
			mapper.setEmail(users.getEmail());
			mapper.setName(users.getName());
			mapper.setGender(users.getGender());
			mapper.setPhone_no(users.getPhone_no());
			
			return usersRepository.save(mapper);
		});
	}

	public Users addUsers(Users users) {
		// TODO Auto-generated method stub
		return usersRepository.save(users);
	}

	public ResponseEntity<?> DeleteUser(int id) {
		try {
			usersRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}