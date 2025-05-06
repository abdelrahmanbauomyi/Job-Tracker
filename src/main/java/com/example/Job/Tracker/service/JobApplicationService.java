package com.example.Job.Tracker.service;

import com.example.Job.Tracker.dto.JobApplicationRequest;
import com.example.Job.Tracker.dto.JobApplicationResponse;

import java.util.List;
import java.util.Optional;

public interface JobApplicationService {
    List<JobApplicationResponse> getAllJobApplication();
    Optional<JobApplicationResponse> getJobApplicationById(Long id);
    JobApplicationResponse saveJobApplication(JobApplicationRequest jobApplicationRequest);
    JobApplicationResponse updateJobApplication(Long id, JobApplicationRequest jobApplicationRequest);
    void deleteJobApplication(Long id);
}
