package com.hari.repository;

import com.hari.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription ,Long> {
    Subscription findByUserId(Long userId);
}
