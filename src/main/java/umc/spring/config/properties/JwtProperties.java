package umc.spring.config.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("jwt.token")
public class JwtProperties {

    private String secretKey = ""; // JWT 비밀 키
    private Expiration expiration; // JWT 만료 시간 설정

    @Getter
    @Setter
    public static class Expiration {
       private Long accessToken; // 액세스 토큰 만료 시간 (초 단위)
//         private Long refreshToken;  리프레시 토큰 만료 시간 (초 단위)
    }


}
