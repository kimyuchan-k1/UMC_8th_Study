package umc.spring.web.dto.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class StoreResponseDto {
    private Long storeId;
    private String name;
    private Float score;
    private String regionName;
}

