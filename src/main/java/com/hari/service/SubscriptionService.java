package com.hari.service;

import com.hari.Type.PlanType;
import com.hari.model.Subscription;
import com.hari.model.User;

public interface SubscriptionService {
    Subscription createSubscription(User user);
    Subscription getUserSubscription(Long userId)throws Exception;
    Subscription upgradeSubscription(Long userId, PlanType planType )throws Exception;
    boolean isValid(Subscription subscription);


}
