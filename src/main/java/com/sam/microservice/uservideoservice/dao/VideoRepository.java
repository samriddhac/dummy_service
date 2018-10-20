package com.sam.microservice.uservideoservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.sam.microservice.uservideoservice.entity.User;
import com.sam.microservice.uservideoservice.entity.UserGroup;
import com.sam.microservice.uservideoservice.entity.Video;
import com.sam.microservice.uservideoservice.entity.VideoGroup;
import com.sam.microservice.uservideoservice.model.UserVideoRequestModel;

@Repository
public class VideoRepository {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;
	
	public List<Video> getVideos() {
		return em.createNamedQuery("getAllVideos", Video.class )
				.getResultList();
	}
	
	public List<VideoGroup> getGroups() {
		return em.createNamedQuery("getAllVideoGroups", VideoGroup.class )
				.getResultList(); 
	}

	@Transactional
	public List<User> assignVideos(UserVideoRequestModel request) {
		logger.info("Request {}",request);
		List<User> users = new ArrayList<User>();
		if(request!=null) {
			if(!CollectionUtils.isEmpty(request.getUserIds())) {
				request.getUserIds().forEach(userId->{
					User user = em.find(User.class, userId);
					if(!CollectionUtils.isEmpty(request.getVideoIds())) {
						List<Video> assignedVideos = user.getVideos();
						List<Video> selectedVideos = em.createNamedQuery("getVideosById", Video.class)
								.setParameter("id", request.getVideoIds())
								.getResultList();
						List<Video> unassignedVideos = selectedVideos.stream()
								.filter(v->!assignedVideos.contains(v))
								.collect(Collectors.toList());
						user.addVideos(unassignedVideos);
					}
					if(!CollectionUtils.isEmpty(request.getVideoGroupIds())) {
						List<VideoGroup> assignedVideoGroups = user.getVideoGroups();
						List<VideoGroup> selectedVideoGroups = em.createNamedQuery("getVideoGroupsById", VideoGroup.class)
								.setParameter("id", request.getVideoGroupIds())
								.getResultList();
						List<VideoGroup> unassignedVideoGroups = selectedVideoGroups.stream()
								.filter(v->!assignedVideoGroups.contains(v))
								.collect(Collectors.toList());
						user.addVideoGroups(unassignedVideoGroups);
					}
					logger.info("user {}", user);
					em.persist(user);
					users.add(user);
				});
			}
			if(!CollectionUtils.isEmpty(request.getUserGroupIds())) {
				request.getUserGroupIds().forEach(userGroupId->{
					UserGroup userGroup = em.find(UserGroup.class, userGroupId);
					if(!CollectionUtils.isEmpty(request.getVideoIds())) {
						List<Video> assignedVideos = userGroup.getVideos();
						List<Video> selectedVideos = em.createNamedQuery("getVideosById", Video.class)
								.setParameter("id", request.getVideoIds())
								.getResultList();
						List<Video> unassignedVideos = selectedVideos.stream()
								.filter(v->!assignedVideos.contains(v))
								.collect(Collectors.toList());
						userGroup.addVideos(unassignedVideos);
					}
					if(!CollectionUtils.isEmpty(request.getVideoGroupIds())) {
						List<VideoGroup> assignedVideoGroups = userGroup.getVideoGroups();
						List<VideoGroup> selectedVideoGroups = em.createNamedQuery("getVideoGroupsById", VideoGroup.class)
								.setParameter("id", request.getVideoGroupIds())
								.getResultList();
						List<VideoGroup> unassignedVideoGroups = selectedVideoGroups.stream()
								.filter(v->!assignedVideoGroups.contains(v))
								.collect(Collectors.toList());
						userGroup.addVideoGroups(unassignedVideoGroups);
					}
					logger.info("userGroup {}", userGroup);
					em.persist(userGroup);
				});
			}
		}
		return users;
	}
}
