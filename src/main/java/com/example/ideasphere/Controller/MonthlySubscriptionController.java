package com.example.ideasphere.Controller;

import com.example.ideasphere.ApiResponse.ApiResponse;
import com.example.ideasphere.Model.MonthlySubscription;
import com.example.ideasphere.Model.MyUser;
import com.example.ideasphere.Service.MonthlySubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/monthly-subscription")
@RequiredArgsConstructor
public class MonthlySubscriptionController {

    private final MonthlySubscriptionService monthlySubscriptionService;


    // By basil
    // Get all monthly subscription for admin
    @GetMapping("/get-all-monthly-subscription")
    public ResponseEntity getAllMonthlySubscription(){
        return ResponseEntity.ok(monthlySubscriptionService.getAllMonthlySubscription());
    }
    // By basil
    // get my monthly subscription
    @GetMapping("/get-my-monthly-subscription")
    public ResponseEntity getMyMonthlySubscription(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.ok(monthlySubscriptionService.getMyMonthlySubscription(myUser.getId()));
    }
    // By basil
    // this end point for subscribing
    @PostMapping("/subscribe/{subscriptionPackageId}")
    public ResponseEntity subscribe(@AuthenticationPrincipal MyUser myUser , @PathVariable Integer subscriptionPackageId){
        monthlySubscriptionService.subscribe(myUser.getId(),subscriptionPackageId);
        return ResponseEntity.status(201).body(new ApiResponse("subscribed done successfully"));
    }

    // By basil
    // this end point for renew subscription
    @PostMapping("/renew-subscription/{subscriptionPackageId}")
    public ResponseEntity renewSubscription(@AuthenticationPrincipal MyUser myUser , @PathVariable Integer subscriptionPackageId){
        monthlySubscriptionService.renewSubscribe(myUser.getId(),subscriptionPackageId);
        return ResponseEntity.status(201).body(new ApiResponse("Renew Subscription done successfully"));
    }
}
