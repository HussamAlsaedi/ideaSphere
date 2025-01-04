package com.example.ideasphere.DTOsIN;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyCompetitionExtendDTOIn {

    @NotNull(message = "Error: id is empty")
    private Integer id;


    private LocalDate voteEndDate;

    @NotNull(message = "Error: endDate is empty")
    @Future(message = "Error: endDate must be in Future")
    private LocalDate endDate;


    @NotNull(message = "Error: increaseParticipants is empty")
    @Max(value = 500 , message = "Error :increaseParticipants the max is 500 ")
    @PositiveOrZero(message = "Error: increaseParticipants must be Positive Or Zero")
    private Integer increaseParticipants;
}
