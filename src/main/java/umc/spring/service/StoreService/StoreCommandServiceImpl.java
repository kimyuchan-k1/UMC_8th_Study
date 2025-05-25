package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository.RegionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.store.StoreRequestDto;
import umc.spring.web.dto.store.StoreResponseDto;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService{

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    @Override
    public StoreResponseDto addStore(StoreRequestDto requestDto) {
        Region region = regionRepository.findById(requestDto.getRegionId())
                .orElseThrow(() -> new IllegalArgumentException("\\존재하지 않는 지역입니다\\"));

        Store store = StoreConverter.toEntity(requestDto , region);
        Store saved = storeRepository.save(store);

        return StoreConverter.toResponseDto(saved);
    }
}
