package umc.spring.web.dto;

import umc.spring.domain.enums.MissionStatus;

public record MissionChallengeResponse(
        Long memberMissionId,
        Long missionId,
        MissionStatus status) { }
