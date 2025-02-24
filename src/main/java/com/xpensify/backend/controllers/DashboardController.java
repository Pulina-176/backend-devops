package com.xpensify.backend.controllers;

import com.xpensify.backend.services.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping("/balance/{userId}")
    public ResponseEntity<?> getBalance(@PathVariable long userId) {
        return ResponseEntity.ok(dashboardService.getBalance(userId));
    }

}
