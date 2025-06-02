package umc.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.service.missionService.MissionCommandService;
import umc.spring.validation.annotation.StoreExists;
import umc.spring.web.dto.MemberMissionDTO;
import umc.spring.web.dto.mission.MissionRequestDto;
import umc.spring.web.dto.mission.MissionResponseDto;
import umc.spring.web.dto.store.StoreResponseDto;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    private final StoreQueryService storeQueryService;

    @PostMapping
    public ApiResponse<MissionResponseDto> createMission(@RequestBody @Valid MissionRequestDto request) {
        MissionResponseDto response = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(response);
    }

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses(
            {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            }
    )
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호 입니다. 1 이상의 값을 입력해주세요!")
    })
    public ApiResponse<MissionResponseDto.StoreMissionListDTO> getReviewList(@StoreExists @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        Page<Mission> missionPreviewList = storeQueryService.getMissionList(storeId,page);

        return ApiResponse.onSuccess(StoreConverter.toStoreMissionListDTO(missionPreviewList));

    }

    @PatchMapping("/{memberMissionId}/complete")
    public ApiResponse<MemberMissionDTO> completeMission(
            @PathVariable Long memberMissionId
    ) {
        MemberMissionDTO response = missionCommandService.completeMission(memberMissionId);
        return ApiResponse.onSuccess(response);
    }
}
