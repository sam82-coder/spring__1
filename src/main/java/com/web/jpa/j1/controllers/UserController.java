package com.web.jpa.j1.controllers;

import java.lang.reflect.Method;
import java.net.http.HttpHeaders;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.apache.catalina.mbeans.UserMBean;
import org.springframework.hateoas.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.web.jpa.j1.domain.IModel;
import com.web.jpa.j1.domain.User;
import com.web.jpa.j1.domain.UserModel;
import com.web.jpa.j1.repositories.UserRepositories;

@RestController
public class UserController {

	private final UserRepositories repository;

	UserController(UserRepositories repository) {
		this.repository = repository;
	}

	// Aggregate root
	/*
	 * @GetMapping("/users") List<User> all() throws NoSuchMethodException,
	 * SecurityException { // Method xMethod = UserController.class.getMethod("one",
	 * Long.class); for (int i = 0; i <
	 * UserController.class.getDeclaredMethods().length; i++) { Method array_element
	 * = UserController.class.getDeclaredMethods()[i];
	 * System.out.println(array_element.getName()); } //
	 * System.out.println(xMethod.getName()); return repository.findAll(); }
	 */

//	  
//	  @GetMapping("/employees")
//	  CollectionModel<User> all() {
//
//	    List<EntityModel<User>> users = repository.findAll().stream()
//	      .map(user -> new EntityModel<User>(user,
//	        linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
//	        linkTo(methodOn(UserController.class).all()).withRel("users")))
//	      .collect(Collectors.toList());
//
//	    return new CollectionModel<User>(users,
//	      linkTo(methodOn(UserController.class).all()).withSelfRel());
//	  }
//

	@GetMapping("/users")
	public HttpEntity<List<User>> all() {

		Link link = Link.of("/{segment}/something{?parameter}");

		List<User> users = repository.findAll();
//		  Collection<User> users =repository.findAll();
//		  CollectionModel<User> models = CollectionModel.of(users);
//		  
		return new ResponseEntity<List<User>>(users, HttpStatus.ACCEPTED);

	}

	@PostMapping("/users")
	public ResponseEntity<UserModel> newUser(@RequestBody User newUser) {
		UserModel userModel = new UserModel().setUser(repository.save(newUser));
		userModel.add(linkTo(methodOn(UserController.class).newUser(newUser)).withSelfRel());
		
		return new ResponseEntity<UserModel>(userModel,HttpStatus.OK);
	}

	/*
	 * @GetMapping("/users/{id}") User one(@PathVariable Long id) { return
	 * repository.findById(id).orElseThrow(()->new UserNotFoundException(id)); }
	 */
	@GetMapping("/users/{id}")
	EntityModel<User> one(@PathVariable Long id) throws NoSuchMethodException, SecurityException {
		User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
//		 Link link = Link.linkTo(UserController.class).withRel("users");
//		 EntityModel<User> model = EntityModel.of(user);
		return new EntityModel<User>(user, linkTo(methodOn(UserController.class).one(id)).withSelfRel(),
				linkTo(methodOn(UserController.class).all()).withRel("users"));
	}

	@PutMapping("/users/{id}")
	User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
		return repository.findById(id).map(user -> {

			user.setUserName(newUser.getUserName());
			user.setPassWord(newUser.getPassWord());
			return repository.save(user);
		}).orElseGet(() -> {
			newUser.setId(id);
			return repository.save(newUser);
		});
	}

	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
