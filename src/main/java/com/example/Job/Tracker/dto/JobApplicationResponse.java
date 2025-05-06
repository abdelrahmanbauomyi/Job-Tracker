package com.example.Job.Tracker.dto;

import com.example.Job.Tracker.entity.ApplicationStatus;
import com.example.Job.Tracker.entity.JobApplication;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Builder
@Data
public class JobApplicationResponse {
    private Long id;
    private String jobTitle;
    private String companyName;
    private String location;
    private String jobLink;
    private ApplicationStatus status;
    private LocalDate appliedDate;
    private LocalDate followUpDate;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static JobApplicationResponse fromEntity(JobApplication job) {
        return JobApplicationResponse.builder()
                .id(job.getId())
                .jobTitle(job.getJobTitle())
                .companyName(job.getCompanyName())
                .location(job.getLocation())
                .jobLink(job.getJobLink())
                .status(job.getStatus())
                .appliedDate(job.getAppliedDate())
                .followUpDate(job.getFollowUpDate())
                .notes(job.getNotes())
                .createdAt(job.getCreatedAt())
                .updatedAt(job.getUpdatedAt())
                .build();
    }
}
