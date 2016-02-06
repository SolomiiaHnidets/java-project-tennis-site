package com.tennis.domain;

import javax.persistence.*;

@Entity
public class VideoCatalog {

	public int getVideoID() {
		return videoID;
	}

	public void setVideoID(int videoID) {
		this.videoID = videoID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
	@Column(name = "videoID", nullable = false)
	private int videoID;

	@Column(name = "url", nullable = false, unique = true)
	private String url;

	@Column(name = "description")
	private String description;
}
