package com.sam.microservice.uservideoservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="getAllVideoGroups", 
			query="SELECT vg FROM VideoGroup vg"),
	@NamedQuery(name="getVideoGroupsById", 
			query="SELECT v FROM VideoGroup v WHERE ID IN (:id)")
})
public class VideoGroup {
	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy="id")
	private List<Video> videos;
	
	public VideoGroup() {
		super();
	}

	
	public VideoGroup(int id, String name, List<Video> videos) {
		super();
		this.id = id;
		this.name = name;
		this.videos = videos;
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

	public List<Video> getVideos() {
		return videos;
	}


	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}


	@Override
	public String toString() {
		return "UserGroup [id=" + id + ", name=" + name + ", videos=" + videos + "]";
	}
	
	@Override
	public boolean equals(Object arg0) {
		return this.getId()==((VideoGroup)arg0).getId();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
