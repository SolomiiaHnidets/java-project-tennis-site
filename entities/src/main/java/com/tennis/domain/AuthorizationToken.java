package com.tennis.domain;

import javax.persistence.*;

@Entity
@Table(name = "athorization_token")
public class AuthorizationToken {

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	// private final static Integer DEFAULT_TIME_TO_LIVE_IN_SECONDS = (60 * 60 *
	// 24 * 30); // 30
	// // Days
	@Id
	@Column(length = 36, name = "token", unique = true, nullable = false)
	private String token;

	// @Column(name = "timeCreated")
	// private Date timeCreated;
	//
	// @Column(name = "expirationDate")
	// private Date expirationDate;

	@JoinColumn(name = "Users", referencedColumnName = "userID")
	@Column(name = "userID")
	private int userID;
}
