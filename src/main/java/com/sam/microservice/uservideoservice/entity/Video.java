package com.sam.microservice.uservideoservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name="getAllVideos", 
			query="SELECT v FROM Video v"),
	@NamedQuery(name="getVideosById", 
		query="SELECT v FROM Video v WHERE ID IN :id")
})
public class Video {

	@Id
	private long id;
	private String name;
	
	@OneToOne
	private UserGroup group;
	
	@ManyToMany(mappedBy="videos")
	private List<User> users;
	
	@ManyToMany(mappedBy="videoGroups")
	private List<User> usersbyGroups;
	
	public Video() {
		super();
	}

	public Video(long id, String name, UserGroup group) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getUsersbyGroups() {
		return usersbyGroups;
	}

	public void setUsersbyGroups(List<User> usersbyGroups) {
		this.usersbyGroups = usersbyGroups;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", name=" + name + ", group=" + group + "]";
	}

	@Override
	public boolean equals(Object arg0) {
		return this.getId()==((Video)arg0).getId();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
