package com.reliance.profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reliance.profile.model.Notification;
import com.reliance.profile.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	// Get all notification
	@Override
	public List<Notification> getNotifications() {
		List<Notification> notifications = notificationRepository.findAll();
		return notifications;
	}

	// Get notification for a particular id
	@Override
	public Notification getNotification(int id) {
		Optional<Notification> notification = notificationRepository.findById(id);
		if (notification.isPresent()) {
			return notification.get();
		}
		return null;
	}

	// Create notification
	@Override
	public Notification createNotification(Notification notification) {
		Notification dbNotification = notificationRepository.save(notification);
		return dbNotification;
	}

	// Update notification
	@Override
	public Notification updateNotification(int id, Notification notification) {
		Optional<Notification> dbNotification = notificationRepository.findById(id);
		if (dbNotification.isPresent()) {
			Notification toBeUpdated = dbNotification.get();
			toBeUpdated.setMessage(notification.getMessage());
			Notification updatedNotification = notificationRepository.save(toBeUpdated);
			return updatedNotification;
		} else {
			return null;
		}
	}

	// Delete notification
	@Override
	public void deleteNotification(int id) {
		notificationRepository.deleteById(id);
	}

}
