package com.web.jpa.j1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User  implements IModel{
	
	
	@Id
	@GeneratedValue
	Long id;
	String userName;
	String passWord;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String userName,String passWord){
		this.userName = userName;
		this.passWord = passWord;
		
	}
	
	
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}



	@Override
	public IModel setUser(User user) {
		return this;
		
	}
	

}
