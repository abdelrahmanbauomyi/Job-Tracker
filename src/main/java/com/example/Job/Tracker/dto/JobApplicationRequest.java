package com.example.Job.Tracker.dto;

import com.example.Job.Tracker.entity.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class JobApplicationRequest {
    @NotBlank
    private String jobTitle;

    @NotBlank
    private String companyName;

    private String location;
    private String jobLink;
    private ApplicationStatus status;
    private LocalDate appliedDate;
    private LocalDate followUpDate;
    private String notes;
}
