package it.beije.turing.settemmezzo.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/login")
	public UserDto login(@RequestBody UserDto userDto) {
		UserDto u = userService.login(userDto.getEmail(), userDto.getPassword());
		
		//TODO online = true;
		
		if(u == null) {
			throw new RuntimeException("");
		}
		return u;
	}

	@PostMapping(value = "/addUser")
	public UserDto addUser(@RequestBody User user) {
		if(user.getPassword() == null || user.getEmail() == null || user.getUsername() == null) {
			throw new RuntimeException("One or more fields missing for creating a user");
		}
		user.setScore(0);
		
		userService.addUser(user);
		UserDto userDto = new UserDto(user);
		
		return userDto;
		
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping(value = "/users")
	public List<User> getUsers(){
		List<User> users = userService.getAllUser();
		return users;
		
	}
	
	@DeleteMapping(value = "/deleteUser/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable Integer id) {
		userService.removeUser(id);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("Esito: ", Boolean.TRUE);
		
		return map;
		
	}
	
	@PutMapping(value = "/modifyUser/{id}")
	public UserDto modifyUser(@RequestBody User user, @PathVariable Integer id) {
		
		UserDto userDto = new UserDto(userService.updateUser(user, id));
		return userDto;
		
	}
	
	
	
}
