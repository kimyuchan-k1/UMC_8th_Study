package umc.spring.service.StoreService;

import umc.spring.web.dto.store.StoreRequestDto;
import umc.spring.web.dto.store.StoreResponseDto;

public interface StoreCommandService {

    StoreResponseDto addStore(StoreRequestDto request);
}
