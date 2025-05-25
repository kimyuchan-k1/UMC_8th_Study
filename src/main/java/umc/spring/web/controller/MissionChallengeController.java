package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.service.MissionChallengeService;
import umc.spring.web.dto.MissionChallengeRequest;
import umc.spring.web.dto.MissionChallengeResponse;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionChallengeController {

    private final MissionChallengeService service;

    @PostMapping("/challenge")
    public ApiResponse<MissionChallengeResponse> challenge(
            @Valid @RequestBody MissionChallengeRequest request) {

        MissionChallengeResponse res = service.challenge(request);
        return ApiResponse.onSuccess(res);
    }
}
