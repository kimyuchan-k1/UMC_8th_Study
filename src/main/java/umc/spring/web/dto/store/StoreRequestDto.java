package umc.spring.web.dto.store;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreRequestDto {
    private String name;
    private String address;
    private Float score;
    private Long regionId;
}
