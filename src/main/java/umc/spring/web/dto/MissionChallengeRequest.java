package umc.spring.web.dto;

import jakarta.validation.constraints.Positive;
import umc.spring.validation.annotation.NotAlreadyChallenging;

@NotAlreadyChallenging
public record MissionChallengeRequest (
    @Positive
    Long memberId,
    @Positive Long missionId) { }




