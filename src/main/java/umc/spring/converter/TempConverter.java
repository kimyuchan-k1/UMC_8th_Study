package umc.spring.converter;

import umc.spring.web.dto.TempResponse;

public class TempConverter {
    public static TempResponse.TempTestDto toTempTestDTO() {
        return TempResponse.TempTestDto.builder().
                testString("This is test!")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
