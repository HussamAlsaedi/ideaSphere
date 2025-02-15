package com.example.ideasphere.Controller;

import com.example.ideasphere.ApiResponse.ApiResponse;
import com.example.ideasphere.DTOsIN.*;
import com.example.ideasphere.DTOsOut.CompanyCompetitionDTOOut;
import com.example.ideasphere.Model.MyUser;
import com.example.ideasphere.Service.CompanyCompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company-competition")
@RequiredArgsConstructor
public class CompanyCompetitionController {

    private final CompanyCompetitionService companyCompetitionService;

    // by Basil
    // get all competition for Company Competition
    @GetMapping("/get-all-competition")
    public ResponseEntity<List<CompanyCompetitionDTOOut>> getAllCompetitions() {
        List<CompanyCompetitionDTOOut> competitions = companyCompetitionService.getAllCompanyCompetition();
        return ResponseEntity.ok(competitions);
    }
    // by Basil
    // get my competition as company Organizer
    @GetMapping("/get-my-competitions")
    public ResponseEntity<List<CompanyCompetitionDTOOut>> getMyCompetitions(@AuthenticationPrincipal MyUser myUser) {
        List<CompanyCompetitionDTOOut> competitions = companyCompetitionService.getMyCompetition(myUser.getId());
        return ResponseEntity.ok(competitions);
    }

    // by Basil
    // create competition with Reward type financial and interview
    @PostMapping("/create-competition-financial-interview")
    public ResponseEntity<ApiResponse> createFinancialInterview(
            @AuthenticationPrincipal MyUser myUser,
            @RequestBody @Valid CompanyCompetitionFinancialInterviewDTOIn competitionDTO) {
        companyCompetitionService.createCompetitionFinancialInterview(myUser.getId(), competitionDTO);
        return ResponseEntity.status(201).body(new ApiResponse("Competition created successfully."));
    }

    // by Basil
    // create competition with Reward type interview
    @PostMapping("/create-competition-interview")
    public ResponseEntity<ApiResponse> createInterview(
            @AuthenticationPrincipal MyUser myUser,
            @RequestBody @Valid CompanyCompetitionInterviewDTOIn competitionDTO) {
        companyCompetitionService.createCompetitionInterview(myUser.getId(), competitionDTO);
        return ResponseEntity.status(201).body(new ApiResponse("Competition created successfully."));
    }
    // by Basil
    // create competition with Reward type financial and select winner method by-vote
    @PostMapping("/create-competition-financial-by-vote")
    public ResponseEntity<ApiResponse> createFinancialByVote(
            @AuthenticationPrincipal MyUser myUser,
            @RequestBody @Valid CompanyCompetitionFinancialByVoteDTOIn competitionDTO) {
        companyCompetitionService.createCompetitionFinancialByVoteDTOIn(myUser.getId(), competitionDTO);
        return ResponseEntity.status(201).body(new ApiResponse("Competition created successfully."));
    }
    // by Basil
    // create competition with Reward type financial and select winner method by-organizer
    @PostMapping("/create-competition-financial-by-organizer")
    public ResponseEntity<ApiResponse> createFinancialByOrganizer(
            @AuthenticationPrincipal MyUser myUser,
            @RequestBody @Valid CompanyCompetitionFinancialByOrganizerDTOIn competitionDTO) {
        companyCompetitionService.createCompetitionFinancialByOrganizerDTOIn(myUser.getId(), competitionDTO);
        return ResponseEntity.status(201).body(new ApiResponse("Competition created successfully."));
    }

    // by Basil
    // pay monetary Reward to start the competition
    @PostMapping("/add-competition-payment")
    public ResponseEntity<ApiResponse> addPayment(
            @AuthenticationPrincipal MyUser myUser,
            @RequestBody @Valid CompanyCompetitionPaymentDTOIn competitionPaymentDTOIn){
        companyCompetitionService.addPayment(myUser.getId(), competitionPaymentDTOIn);
        return ResponseEntity.status(200).body(new ApiResponse("Competition Payment Completed Successfully."));
    }
    // by Basil
    // cancel Competition the competition return payment if Reward type have financial
    @PutMapping("/cancel-competition/{companyCompetitionId}")
    public ResponseEntity<ApiResponse> cancelCompetition(
            @AuthenticationPrincipal MyUser myUser,
            @PathVariable Integer companyCompetitionId){
        companyCompetitionService.cancelCompetition(myUser.getId(), companyCompetitionId);
        return ResponseEntity.status(200).body(new ApiResponse("Competition canceled Successfully."));
    }
    // by Basil
    // extend the competition dates and number of Participant
    @PutMapping("/extend-competition")
    public ResponseEntity<ApiResponse> extendCompetition(
            @AuthenticationPrincipal MyUser myUser,
            @RequestBody @Valid CompanyCompetitionExtendDTOIn companyCompetitionExtendDTOIn){
        companyCompetitionService.extendCompetition(myUser.getId(), companyCompetitionExtendDTOIn);
        return ResponseEntity.status(200).body(new ApiResponse("Competition extend successfully."));
    }
    // by Basil
    // update the competition content
    @PutMapping("/update-competition")
    public ResponseEntity<ApiResponse> updateCompetition(
            @AuthenticationPrincipal MyUser myUser,
            @RequestBody @Valid CompanyCompetitionUpdateDTOIn companyCompetitionUpdateDTOIn){
        companyCompetitionService.updateCompetition(myUser.getId(), companyCompetitionUpdateDTOIn);
        return ResponseEntity.status(200).body(new ApiResponse("Competition updated successfully."));
    }

}
