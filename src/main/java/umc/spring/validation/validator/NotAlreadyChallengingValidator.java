package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.validation.annotation.NotAlreadyChallenging;
import umc.spring.web.dto.MissionChallengeRequest;

@Component
@RequiredArgsConstructor
public class NotAlreadyChallengingValidator
        implements ConstraintValidator<NotAlreadyChallenging, MissionChallengeRequest> {

    private final MemberMissionRepository repo;

    @Override
    public boolean isValid(MissionChallengeRequest dto,
                           ConstraintValidatorContext ctx) {

        boolean already = repo.existsByMemberIdAndMissionIdAndStatus(
                dto.memberId(), dto.missionId(), MissionStatus.CHALLENGING);

        if (already) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("이미 도전 중인 미션입니다.")
                    .addPropertyNode("missionId")        // ← missionId 필드 오류로 변환
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
