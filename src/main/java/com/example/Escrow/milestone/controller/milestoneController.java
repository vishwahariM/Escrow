package com.example.Escrow.milestone.controller;

import com.example.Escrow.milestone.entity.milestone;
import com.example.Escrow.milestone.service.milestoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milestones")
public class milestoneController {

    private final milestoneService milestoneService;

    public milestoneController(milestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    // Create Milestone
    @PostMapping
    public ResponseEntity<milestone> createMilestone(
            @RequestBody milestone milestone) {

        milestone createdMilestone =
                milestoneService.createMilestone(milestone);

        return new ResponseEntity<>(
                createdMilestone,
                HttpStatus.CREATED
        );
    }

    // Get All Milestones
    @GetMapping
    public ResponseEntity<List<milestone>> getAllMilestones() {

        return ResponseEntity.ok(
                milestoneService.getAllMilestones()
        );
    }

    // Get Milestone By ID
    @GetMapping("/{id}")
    public ResponseEntity<milestone> getMilestoneById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                milestoneService.getMilestoneById(id)
        );
    }

    // Update Milestone
    @PutMapping("/{id}")
    public ResponseEntity<milestone> updateMilestone(
            @PathVariable Long id,
            @RequestBody milestone updatedMilestone) {

        return ResponseEntity.ok(
                milestoneService.updateMilestone(
                        id,
                        updatedMilestone
                )
        );
    }

    // Mark Milestone as Delivered
    @PutMapping("/{id}/deliver")
    public ResponseEntity<milestone> deliverMilestone(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                milestoneService.deliverMilestone(id)
        );
    }

    // Client Approve Milestone
    @PutMapping("/{id}/approve")
    public ResponseEntity<milestone> approveMilestone(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                milestoneService.approveMilestone(id)
        );
    }

    // Request Rework
    @PutMapping("/{id}/rework")
    public ResponseEntity<milestone> requestRework(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                milestoneService.requestRework(id)
        );
    }

    // Release Payment
    @PostMapping("/{id}/release")
    public ResponseEntity<milestone> releasePayment(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                milestoneService.releasePayment(id)
        );
    }

    // Delete Milestone
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMilestone(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                milestoneService.deleteMilestone(id)
        );
    }
}