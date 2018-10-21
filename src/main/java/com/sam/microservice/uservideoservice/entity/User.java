package com.sam.microservice.uservideoservice.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USERS")
@NamedQueries({
	@NamedQuery(name="getAllUsers", 
			query="SELECT u FROM User u")
})
public class User {

	@Id
	private int id;
	private String name;
	
	@OneToOne
	private UserGroup group;
	
	@JsonIgnore
	@ManyToMany(cascade= {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name="user_to_video",
		joinColumns=@JoinColumn(name="video_id"),
		inverseJoinColumns = {@JoinColumn(name="user_id")}
	)
	private List<Video> videos = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(cascade= {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name="user_to_video_group",
		joinColumns=@JoinColumn(name="video_group_id"),
		inverseJoinColumns = {@JoinColumn(name="user_id")}
	)
	private List<VideoGroup> videoGroups = new ArrayList<>();
	
	public User() {
		super();
	}

	public User(int id, String name, UserGroup group, List<Video> videos, List<VideoGroup> videoGroups) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
		this.videos = videos;
		this.videoGroups = videoGroups;
	}



	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserGroup getGroup() {
		return group;
	}

	public void setGroup(UserGroup group) {
		this.group = group;
	}
	
	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public void addVideos(List<Video> videos) {
		videos.forEach((v)->{
			if(!this.videos.contains(v)) {
				this.videos.add(v);
			}
		});
	}
	
	public void removeVideos(List<Video> videos) {
		videos.forEach((v)->{
			if(this.videos.contains(v)) {
				this.videos.remove(v);
			}
		});
	}
	
	public List<VideoGroup> getVideoGroups() {
		return videoGroups;
	}

	public void setVideoGroups(List<VideoGroup> videoGroups) {
		this.videoGroups = videoGroups;
	}
	
	
	public void addVideoGroups(List<VideoGroup> videos) {
		videos.forEach((v)->{
			if(!this.videoGroups.contains(v)) {
				this.videoGroups.add(v);
			}
		});
	}
	
	public void removeVideoGroups(List<VideoGroup> videos) {
		videos.forEach((v)->{
			if(this.videoGroups.contains(v)) {
				this.videoGroups.remove(v);
			}
		});
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", group=" + group + ", videos=" + videos + ", videoGroups="
				+ videoGroups + "]";
	}
	
}
