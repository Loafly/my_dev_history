package kr.com.ns.mydevhistory.common.cors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "app.cors")
public class CorsProperties {

    /**
     * 허용할 출처 목록. "*"을 사용하면 모든 도메인을 허용합니다.
     * 예: allowed-origins: ["https://example.com", "https://another.com"]
     */
    private List<String> allowedOrigins;

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }
}
