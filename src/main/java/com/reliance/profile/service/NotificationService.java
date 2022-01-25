package com.reliance.profile.service;

import java.util.List;

import com.reliance.profile.model.Notification;

public interface NotificationService {

	List<Notification> getNotifications(); // get all notifications

	Notification getNotification(int id); // get notification for a particular id

	Notification createNotification(Notification notification); // create notification

	Notification updateNotification(int id, Notification notification); // update existing notification

	void deleteNotification(int id); // delete notification
}
