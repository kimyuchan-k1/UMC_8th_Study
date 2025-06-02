package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.domain.embedded.Address;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

@Getter
public class JoinDto {
    String name;
    Integer gender;
    Integer birthYear;
    Integer birthMonth;
    Integer birthDay;
    Address address;
    @ExistCategories
    List<Long> preferCategory;
}
