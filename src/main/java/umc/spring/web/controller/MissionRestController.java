package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.service.missionService.MissionCommandService;
import umc.spring.web.dto.mission.MissionRequestDto;
import umc.spring.web.dto.mission.MissionResponseDto;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping
    public ApiResponse<MissionResponseDto> createMission(@RequestBody @Valid MissionRequestDto request) {
        MissionResponseDto response = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(response);
    }
}
