package com.dpt.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpt.workshopmongo.domain.User;
import com.dpt.workshopmongo.dto.UserDTO;
import com.dpt.workshopmongo.repository.UserRepository;
import com.dpt.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		if (user.isEmpty()) {
			throw new ObjectNotFoundException("Usuário não encontrado!");
		}
		return user.get();
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public User fromDTO(UserDTO userDto) { 
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
}
