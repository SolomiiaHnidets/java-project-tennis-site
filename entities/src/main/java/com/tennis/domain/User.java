package com.tennis.domain;

import java.util.Date;

import javax.persistence.*;

import com.tennis.util.HashedPassword;

@Entity
@Table(name = "Users")
public class User {

	public User() {
	}

	public User(String name, String password) {
		this.userName = name;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID", nullable = false)
	private int userID;

	@Column(name = "userName", nullable = false, unique = true)
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "birthDate")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Column(name = "sex")
	private String sex;

	@Column(name = "authToken")
	private String authToken;

	public int getUserID() {
		return userID;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = HashedPassword.encodePassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
