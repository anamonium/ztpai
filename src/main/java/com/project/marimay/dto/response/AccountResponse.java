package com.project.marimay.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountResponse {
    private Double budget;
    private LocalDate weddingDate;
    private String name;
}
