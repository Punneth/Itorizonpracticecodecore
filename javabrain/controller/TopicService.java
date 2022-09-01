//package com.youtube.javabrain.controller;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TopicService {
//	
//	@Autowired
//	private TopicRepository topicRepository;
//
//	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("Spring", "Spring Framework", "Spring Framework Description"), new Topic("Java", "Core Java", "Core Java Description"),
//			new Topic("JavaScript", "JavaScript", "JavaScript Description")));
//
//	public List<Topic> getAllTopic() {
//		List<Topic> topics = new ArrayList();
//		topicRepository.findAll()
//		.forEach(topics::add);
//		return topics;
//	}
//	
//	public Topic gettopic(String id) {
//		return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
//	}
//
//	public void addTopic(Topic topic) {
//		topics.add(topic);
//		
//	}
//
//	public void updateTopic(Topic topic, String id) {
//		for (int i=0;i<topics.size();i++){ 
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
//		
//	}
//
//	public void deletetopic(String id) {
//		
//		for (int i=0;i<topics.size();i++){ 
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.remove(t);
//			}
//		}
//	}
//
//}
