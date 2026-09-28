package com.example.Escrow.freelancer.controller;

import com.example.Escrow.freelancer.entity.freelancer;
import com.example.Escrow.freelancer.service.freelancerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freelancers")
public class freelancerController {

    private final freelancerService freelancerService;


    public freelancerController(
            freelancerService freelancerService) {

        this.freelancerService = freelancerService;
    }


    // CREATE FREELANCER
    @PostMapping
    public ResponseEntity<freelancer> createFreelancer(
            @RequestBody freelancer freelancer) {

        freelancer createdFreelancer =
                freelancerService.createFreelancer(
                        freelancer
                );

        return new ResponseEntity<>(
                createdFreelancer,
                HttpStatus.CREATED
        );
    }


    // GET ALL FREELANCERS
    @GetMapping
    public ResponseEntity<List<freelancer>>
    getAllFreelancers() {

        List<freelancer> freelancers =
                freelancerService.getAllFreelancers();

        return new ResponseEntity<>(
                freelancers,
                HttpStatus.OK
        );
    }


    // GET FREELANCER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<freelancer>
    getFreelancerById(
            @PathVariable Long id) {

        freelancer freelancer =
                freelancerService.getFreelancerById(id);

        return new ResponseEntity<>(
                freelancer,
                HttpStatus.OK
        );
    }


    // UPDATE FREELANCER
    @PutMapping("/{id}")
    public ResponseEntity<freelancer>
    updateFreelancer(
            @PathVariable Long id,
            @RequestBody freelancer updatedFreelancer) {

        freelancer freelancer =
                freelancerService.updateFreelancer(
                        id,
                        updatedFreelancer
                );

        return new ResponseEntity<>(
                freelancer,
                HttpStatus.OK
        );
    }


    // DELETE FREELANCER
    @DeleteMapping("/{id}")
    public ResponseEntity<String>
    deleteFreelancer(
            @PathVariable Long id) {

        String message =
                freelancerService.deleteFreelancer(id);

        return new ResponseEntity<>(
                message,
                HttpStatus.OK
        );
    }
}