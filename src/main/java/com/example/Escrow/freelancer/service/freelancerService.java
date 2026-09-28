package com.example.Escrow.freelancer.service;

import com.example.Escrow.freelancer.entity.freelancer;
import com.example.Escrow.freelancer.repository.freelancerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class freelancerService {

    private final freelancerRepository freelancerRepository;


    public freelancerService(
            freelancerRepository freelancerRepository) {

        this.freelancerRepository = freelancerRepository;
    }


    // CREATE FREELANCER
    public freelancer createFreelancer(freelancer freelancer) {

        if (freelancer.getName() == null ||
                freelancer.getName().trim().isEmpty()) {

            throw new RuntimeException(
                    "Freelancer name is required"
            );
        }


        if (freelancer.getEmail() == null ||
                freelancer.getEmail().trim().isEmpty()) {

            throw new RuntimeException(
                    "Freelancer email is required"
            );
        }


        return freelancerRepository.save(freelancer);
    }


    // GET ALL FREELANCERS
    public List<freelancer> getAllFreelancers() {

        return freelancerRepository.findAll();
    }


    // GET FREELANCER BY ID
    public freelancer getFreelancerById(Long id) {

        Optional<freelancer> result =
                freelancerRepository.findById(id);

        if (result.isEmpty()) {

            throw new RuntimeException(
                    "Freelancer not found with id: " + id
            );
        }

        return result.get();
    }


    // UPDATE FREELANCER
    public freelancer updateFreelancer(
            Long id,
            freelancer updatedFreelancer) {

        freelancer existingFreelancer =
                getFreelancerById(id);


        if (updatedFreelancer.getName() != null &&
                !updatedFreelancer.getName().trim().isEmpty()) {

            existingFreelancer.setName(
                    updatedFreelancer.getName()
            );
        }


        if (updatedFreelancer.getEmail() != null &&
                !updatedFreelancer.getEmail().trim().isEmpty()) {

            existingFreelancer.setEmail(
                    updatedFreelancer.getEmail()
            );
        }


        return freelancerRepository.save(
                existingFreelancer
        );
    }


    // DELETE FREELANCER
    public String deleteFreelancer(Long id) {

        if (!freelancerRepository.existsById(id)) {

            throw new RuntimeException(
                    "Freelancer not found with id: " + id
            );
        }


        freelancerRepository.deleteById(id);

        return "Freelancer deleted successfully";
    }
}