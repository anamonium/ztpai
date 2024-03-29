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
public class WeddingDetailsResponse {
    LocalDate weddingDate;
    Double budgetSpend;
    Double beginningBudget;
    Integer subtaskDone;
    Integer allSubtask;
    Integer guestsAccepted;
    Integer guestsInvited;
}
