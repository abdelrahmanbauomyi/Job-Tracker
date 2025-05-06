package com.example.Job.Tracker.controller;

import com.example.Job.Tracker.dto.JobApplicationRequest;
import com.example.Job.Tracker.dto.JobApplicationResponse;
import com.example.Job.Tracker.entity.JobApplication;
import com.example.Job.Tracker.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobApplicationController {
    @Autowired
    JobApplicationService jobApplicationService;
    @GetMapping
    public ResponseEntity<List<JobApplicationResponse>> getAllJobs(){
        List<JobApplicationResponse> jobList = jobApplicationService.getAllJobApplication();
        return ResponseEntity.ok(jobList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobApplicationResponse> getJobById(@PathVariable Long id){
        Optional<JobApplicationResponse> job = jobApplicationService.getJobApplicationById(id);
        return job.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<JobApplicationResponse>insertJob(@RequestBody JobApplicationRequest request){
        return ResponseEntity.status(201).body(jobApplicationService.saveJobApplication(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<JobApplicationResponse> updateJob(@PathVariable Long id,@RequestBody JobApplicationRequest request){
        try{
            JobApplicationResponse job = jobApplicationService.updateJobApplication(id ,request);
            return ResponseEntity.ok(job);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id){
        jobApplicationService.deleteJobApplication(id);
        return ResponseEntity.noContent().build();
    }

}
