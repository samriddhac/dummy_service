package com.sam.microservice.uservideoservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sam.microservice.uservideoservice.entity.User;
import com.sam.microservice.uservideoservice.entity.UserGroup;
import com.sam.microservice.uservideoservice.entity.Video;
import com.sam.microservice.uservideoservice.entity.VideoGroup;
import com.sam.microservice.uservideoservice.model.UserVideoRequestModel;
import com.sam.microservice.uservideoservice.service.VideoService;

@Controller
public class VideoController {

	@Autowired
	private VideoService videoService;

	@GetMapping(path="/videos")
	@ResponseBody
	public List<Video> getUsers() {
		return videoService.getAllVideos();
	}
	
	@GetMapping(path="/videos/groups")
	@ResponseBody
	public List<VideoGroup> getGroups() {
		return videoService.getAllVideoGroups();
	}
	
	@PutMapping(path="/videos/users")
	@ResponseBody
	public List<User> assignVideosUsers(@RequestBody UserVideoRequestModel request) {
		return videoService.assignVideos(request);
	}

}
