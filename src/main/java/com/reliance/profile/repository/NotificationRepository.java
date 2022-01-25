package com.reliance.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reliance.profile.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
