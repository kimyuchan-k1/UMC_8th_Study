package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import umc.spring.apipayload.ApiResponse;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.store.StoreRequestDto;
import umc.spring.web.dto.store.StoreResponseDto;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/create")
    public ApiResponse<StoreResponseDto> createStore(
            @RequestBody
            StoreRequestDto request
    ) {
        StoreResponseDto response = storeCommandService.addStore(request);

        return ApiResponse.onSuccess(response);
    }
}
