package com.example.Job.Tracker.service;

import com.example.Job.Tracker.dto.JobApplicationRequest;
import com.example.Job.Tracker.dto.JobApplicationResponse;
import com.example.Job.Tracker.entity.ApplicationStatus;
import com.example.Job.Tracker.entity.JobApplication;
import com.example.Job.Tracker.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class JobApplicationImpl implements JobApplicationService{
    @Autowired
    JobApplicationRepository jobApplicationRepository;

    @Override
    public List<JobApplicationResponse> getAllJobApplication() {
        return jobApplicationRepository.findAll()
                .stream()
                .map(JobApplicationResponse ::fromEntity)
                .toList();

    }

    @Override
    public Optional<JobApplicationResponse> getJobApplicationById(Long id) {
        return jobApplicationRepository.findById(id)
                .map(JobApplicationResponse::fromEntity);
    }

    @Override
    public JobApplicationResponse saveJobApplication(JobApplicationRequest request) {
        JobApplication job = JobApplication.builder()
                .jobTitle(request.getJobTitle())
                .companyName(request.getCompanyName())
                .location(request.getLocation())
                .jobLink(request.getJobLink())
                .status(ApplicationStatus.APPLIED)
                .appliedDate(request.getAppliedDate())
                .notes(request.getNotes())
                .build();
        return JobApplicationResponse.fromEntity(jobApplicationRepository.save(job));
    }

    @Override
    public JobApplicationResponse updateJobApplication(Long id, JobApplicationRequest request) {
        JobApplication existing = jobApplicationRepository.findById(id).orElseThrow(()->new RuntimeException("Job not fount with id : "+id));
        existing.setJobTitle(request.getJobTitle());
        existing.setCompanyName(request.getCompanyName());
        existing.setLocation(request.getLocation());
        existing.setJobLink(request.getJobLink());
        existing.setStatus(request.getStatus());
        existing.setAppliedDate(request.getAppliedDate());
        existing.setFollowUpDate(request.getFollowUpDate());
        existing.setNotes(request.getNotes());
        return JobApplicationResponse.fromEntity(jobApplicationRepository.save(existing));
    }

    @Override
    public void deleteJobApplication(Long id) {
    jobApplicationRepository.deleteById(id);
    }
}
