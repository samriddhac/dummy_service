package com.sam.microservice.uservideoservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries({@NamedQuery(name="getAllGroups", 
query="SELECT ug FROM UserGroup ug")})
public class UserGroup {

	@Id
	private int id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="id")
	private List<User> users;
	
	@ManyToMany(cascade= {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name="user_group_to_video",
		joinColumns=@JoinColumn(name="video_id"),
		inverseJoinColumns = {@JoinColumn(name="user_group_id")}
	)
	private List<Video> videos = new ArrayList<>();
	
	@ManyToMany(cascade= {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name="user_group_to_video_group",
		joinColumns=@JoinColumn(name="video_group_id"),
		inverseJoinColumns = {@JoinColumn(name="user_group_id")}
	)
	private List<VideoGroup> videoGroups = new ArrayList<>();
	
	public UserGroup() {
		super();
	}

	
	public UserGroup(int id, String name, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}


	public int getId() {
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

	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Video> getVideos() {
		return videos;
	}


	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}


	public List<VideoGroup> getVideoGroups() {
		return videoGroups;
	}


	public void setVideoGroups(List<VideoGroup> videoGroups) {
		this.videoGroups = videoGroups;
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
		return "UserGroup [id=" + id + ", name=" + name + "]";
	}
	
	
}
