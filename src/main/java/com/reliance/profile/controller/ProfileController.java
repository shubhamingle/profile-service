package com.reliance.profile.controller;

import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.reliance.profile.kafka.KafkaProducer;
import com.reliance.profile.model.Profile;
import com.reliance.profile.service.ProfileService;

@RestController
@RequestMapping("/api")
public class ProfileController {

	// Profile service

	@Autowired
	private ProfileService profileService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private KafkaProducer kafkaProducer;

	// ***** GET all profiles *****
	@GetMapping("/profiles")
	public List<Profile> getProfiles() {
		List<Profile> profiles = profileService.getProfiles();
		return profiles;
	}

	// ***** GET profile by id *****
	@GetMapping(path = "/profiles/{id}")
	public List<Profile> getProfileDetail(@PathVariable("id") String id) {
		List<Profile> profile = profileService.getProfile(id);
		return profile;
	}

	// ***** POST profile *****
	@PostMapping("/profiles")
	public Profile createProfile(@RequestBody Profile profile) {
		Profile newProfile = profileService.createProfile(profile);

//		/*
//		 * Synchronous call to notification-service using RestTemplate. Task - Create a
//		 * new notification when a new profile is created
//		 */
//
//		// Create an HTTP header and set the content type of the body (JSON)
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//
//		String url = "http://localhost:8081/api/notifications";
		String message = "Profile created for " + newProfile.getName();
//
//		JSONObject notificationObj = new JSONObject();
//		notificationObj.put("message", message);
//
//		// Create a payload (header + body) using HttpEntity
//		HttpEntity<String> s = new HttpEntity<String>(notificationObj.toString(), headers);
//
//		// Send request to the URL
//		restTemplate.postForObject(url, s, String.class);

		kafkaProducer.send(message);

		return newProfile;
	}

	// ***** PUT *****
	@PutMapping("/profiles/{id}")
	public Profile updateProfile(@PathVariable("id") Integer id, @RequestBody Profile profile) {
		return profileService.updateProfile(id, profile);
	}

	// ***** DELETE *****
	@DeleteMapping("/profiles/{id}")
	public void deleteProfile(@PathVariable("id") Integer id) {
		profileService.deleteProfile(id);
	}

//	// Notification Service
//
//	@Autowired
//	private NotificationService notificationService;
//
//	@GetMapping("/notifications")
//	public List<Notification> getNotifications() {
//		List<Notification> notifications = notificationService.getNotifications();
//		return notifications;
//	}
//
//	@GetMapping("/notifications/{id}")
//	public Notification getNotification(@PathVariable("id") Integer id) {
//		Notification notification = notificationService.getNotification(id);
//		return notification;
//	}
//
//	@PostMapping("/notifications")
//	public Notification postNotification(@RequestBody Notification notification) {
//		return notificationService.createNotification(notification);
//	}
//
//	@PutMapping("/notifications/{id}")
//	public Notification updateNotification(@PathVariable("id") Integer id, @RequestBody Notification notification) {
//		return notificationService.updateNotification(id, notification);
//	}
//
//	@DeleteMapping("/notifications/{id}")
//	public void deleteNotification(@PathVariable("id") Integer id) {
//		notificationService.deleteNotification(id);
//	}

}
