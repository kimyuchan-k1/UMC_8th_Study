package umc.spring.service.TempService;


import org.springframework.stereotype.Service;

public interface TempQueryService {
    // query 와 command 의 분리 :  query - 조회 담당 ,command - 내부로직

    void CheckFlag(Integer flag);

}
