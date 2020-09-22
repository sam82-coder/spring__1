package com.web.jpa.j1.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.TemplateVariable;
import org.springframework.hateoas.TemplateVariable.VariableType;
import org.springframework.hateoas.UriTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.web.jpa.j1.controllers.UserController;

public class UserModel extends RepresentationModel<UserModel> implements IModel {

	String userName;
	String passWord;
	
	public UserModel() {
//
//		User user = new User("x", "y");
//		EntityModel<User> model = EntityModel.of(user);
//		Collection<User> users = Collections.singleton(user);
//		linkTo(methodOn(UserController.class).all()).withSelfRel();
//		CollectionModel<User> collectionModel = CollectionModel.of(users);
//
//		UriTemplate template = UriTemplate.of("/{segment}/something");
//		TemplateVariable xtemplateVaraible = new TemplateVariable("", VariableType.REQUEST_PARAM);
//		template.with(xtemplateVaraible);
//		HttpEntity<User> oneUser = new ResponseEntity<User>(user, HttpStatus.OK);
//		HttpEntity<List<User>> httpEntityUsers = new ResponseEntity<List<User>>((List<User>) users, HttpStatus.OK);
//		Link link = Link.of("/some-resource", IanaLinkRelations.NEXT);
	}

	@Override
	public UserModel setUser(User user) {
		this.userName = user.getUserName();
		this.passWord = user.getPassWord();
		return this;
	}

	
}
