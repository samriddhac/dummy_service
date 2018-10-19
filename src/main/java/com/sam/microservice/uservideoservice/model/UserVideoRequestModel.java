package com.sam.microservice.uservideoservice.model;

import java.util.ArrayList;
import java.util.List;

public class UserVideoRequestModel {

	private List<Integer> userIds = new ArrayList<>();
	private List<Integer> userGroupIds = new ArrayList<>();
	private List<Integer> videoIds = new ArrayList<>();
	private List<Integer> videoGroupIds = new ArrayList<>();
	
	public List<Integer> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}
	public List<Integer> getUserGroupIds() {
		return userGroupIds;
	}
	public void setUserGroupIds(List<Integer> userGroupIds) {
		this.userGroupIds = userGroupIds;
	}
	public List<Integer> getVideoIds() {
		return videoIds;
	}
	public void setVideoIds(List<Integer> videoIds) {
		this.videoIds = videoIds;
	}
	public List<Integer> getVideoGroupIds() {
		return videoGroupIds;
	}
	public void setVideoGroupIds(List<Integer> videoGroupIds) {
		this.videoGroupIds = videoGroupIds;
	}
	@Override
	public String toString() {
		return "UserVideoRequestModel [userIds=" + userIds + ", userGroupIds=" + userGroupIds + ", videoIds=" + videoIds
				+ ", videoGroupIds=" + videoGroupIds + "]";
	}
	
	
}
