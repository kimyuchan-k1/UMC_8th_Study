package umc.spring.service.missionService;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.MemberMissionDTO;
import umc.spring.web.dto.mission.MissionRequestDto;
import umc.spring.web.dto.mission.MissionResponseDto;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MissionResponseDto addMission(MissionRequestDto request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("\\가게가 존재하지 않습니다\\"));

        Mission newMission = MissionConverter.toEntity(request, store);
        Mission savedMission = missionRepository.save(newMission);

        return MissionConverter.toResponseDto(savedMission);
    }

    @Override
    public MemberMissionDTO completeMission(Long memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new IllegalArgumentException("\\존재하지 않는 미션 도전 정보\\"));


        memberMission.completeMission();
        memberMissionRepository.save(memberMission);




        return MemberMissionDTO.builder()
                .status(memberMission.getStatus())
                .missionId(memberMissionId)
                .build();
    }
}