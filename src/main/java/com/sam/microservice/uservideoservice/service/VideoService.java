package com.sam.microservice.uservideoservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.microservice.uservideoservice.dao.VideoRepository;
import com.sam.microservice.uservideoservice.entity.User;
import com.sam.microservice.uservideoservice.entity.Video;
import com.sam.microservice.uservideoservice.entity.VideoGroup;
import com.sam.microservice.uservideoservice.model.UserVideoRequestModel;

@Service
public class VideoService {

	@Autowired
	private VideoRepository repository;
	
	public List<Video> getAllVideos() {
		return repository.getVideos();
	}
	
	public List<VideoGroup> getAllVideoGroups() {
		return repository.getGroups();
	}
	
	public List<User> assignVideos(UserVideoRequestModel request) {
		return repository.assignVideos(request);
	}
}
