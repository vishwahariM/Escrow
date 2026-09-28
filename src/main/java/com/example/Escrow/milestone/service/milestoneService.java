package com.example.Escrow.milestone.service;

import com.example.Escrow.milestone.entity.milestone;
import com.example.Escrow.milestone.repository.milestoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class milestoneService {

    private final milestoneRepository milestoneRepository;

    public milestoneService(milestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
    }

    // Create Milestone
    public milestone createMilestone(milestone milestone) {

        if (milestone.getTitle() == null ||
                milestone.getTitle().trim().isEmpty()) {

            throw new RuntimeException("Milestone title is required");
        }

        if (milestone.getAmount() == null ||
                milestone.getAmount().signum() <= 0) {

            throw new RuntimeException(
                    "Milestone amount must be greater than zero"
            );
        }

        if (milestone.getStatus() == null ||
                milestone.getStatus().trim().isEmpty()) {

            milestone.setStatus("PENDING");
        }

        return milestoneRepository.save(milestone);
    }

    // Get All Milestones
    public List<milestone> getAllMilestones() {

        return milestoneRepository.findAll();
    }

    // Get Milestone By ID
    public milestone getMilestoneById(Long id) {

        return milestoneRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Milestone not found with id: " + id
                        ));
    }

    // Update Milestone
    public milestone updateMilestone(
            Long id,
            milestone updatedMilestone) {

        milestone existingMilestone =
                getMilestoneById(id);

        if (updatedMilestone.getTitle() != null &&
                !updatedMilestone.getTitle().trim().isEmpty()) {

            existingMilestone.setTitle(
                    updatedMilestone.getTitle()
            );
        }

        if (updatedMilestone.getDescription() != null) {

            existingMilestone.setDescription(
                    updatedMilestone.getDescription()
            );
        }

        if (updatedMilestone.getAmount() != null &&
                updatedMilestone.getAmount().signum() > 0) {

            existingMilestone.setAmount(
                    updatedMilestone.getAmount()
            );
        }

        return milestoneRepository.save(existingMilestone);
    }

    // Mark as Delivered
    public milestone deliverMilestone(Long id) {

        milestone milestone =
                getMilestoneById(id);

        milestone.setStatus("DELIVERED");

        return milestoneRepository.save(milestone);
    }

    // Client Approve
    public milestone approveMilestone(Long id) {

        milestone milestone =
                getMilestoneById(id);

        if (!"DELIVERED".equals(milestone.getStatus())) {

            throw new RuntimeException(
                    "Milestone must be delivered before approval"
            );
        }

        milestone.setClientApproved(true);
        milestone.setStatus("APPROVED");

        return milestoneRepository.save(milestone);
    }

    // Request Rework
    public milestone requestRework(Long id) {

        milestone milestone =
                getMilestoneById(id);

        milestone.setStatus("REWORK_REQUESTED");
        milestone.setClientApproved(false);

        return milestoneRepository.save(milestone);
    }

    // Release Payment
    public milestone releasePayment(Long id) {

        milestone milestone =
                getMilestoneById(id);

        if (!milestone.isClientApproved()) {

            throw new RuntimeException(
                    "Payment can be released only after client approval"
            );
        }

        if (milestone.isPaymentReleased()) {

            throw new RuntimeException(
                    "Milestone payment has already been released"
            );
        }

        milestone.setPaymentReleased(true);
        milestone.setStatus("RELEASED");

        return milestoneRepository.save(milestone);
    }

    // Delete Milestone
    public String deleteMilestone(Long id) {

        if (!milestoneRepository.existsById(id)) {

            throw new RuntimeException(
                    "Milestone not found with id: " + id
            );
        }

        milestoneRepository.deleteById(id);

        return "Milestone deleted successfully";
    }
}