package com.sakthi.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakthi.project.Service.UserService;
import com.sakthi.project.model.User;


@RestController
@RequestMapping("/api/users")

public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers(){

		try {
			System.out.println("GET /api/users called");
			return userService.getAllUsers();
		} catch (Exception err) {
			System.out.println("Error while GET: " + err.getMessage());
			err.printStackTrace(); // Optional: shows full error stack in console
			return null; // or handle as needed
		}
	}
	
	@GetMapping("/{code}")
	
	public User getUserByCode(@PathVariable Long code){
		return userService.getUserByCode(code);	
	}
	
	 @PostMapping
	    public User createUser(@RequestBody User user) {
	        return userService.createUser(user);
	    }
	
	@PutMapping("/{code}")
    public User updateUser(@PathVariable Long code, @RequestBody User user) {
        return userService.updateUser(code, user);
    }

    @DeleteMapping("/{code}")
    public void deleteUser(@PathVariable Long code) {
        userService.deleteUser(code);
    }
    @Controller
    public class FrontendController {

        @RequestMapping(value = {"/{path:^(?!api|static|index\\.html|favicon\\.ico).*}", "/{path:^(?!api|static).*}/**"})
        public String redirect() {
            return "forward:/index.html";
        }
    }
}

