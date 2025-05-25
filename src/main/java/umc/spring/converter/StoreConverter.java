package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.store.StoreRequestDto;
import umc.spring.web.dto.store.StoreResponseDto;

public class StoreConverter {
    public static Store toEntity(StoreRequestDto request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .region(region)
                .build();
    }

    public static StoreResponseDto toResponseDto(Store store) {
        return new StoreResponseDto(
                store.getId(),
                store.getName(),
                store.getScore(),
                store.getRegion() != null ? store.getRegion().getName() : null
        );
    }
}
