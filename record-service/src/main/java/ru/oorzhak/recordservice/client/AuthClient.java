package ru.oorzhak.recordservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("auth-service")
public interface AuthClient {
    @RequestMapping(method = RequestMethod.GET, value = "auth")
    Long getUserId(@CookieValue("session-id") String sessionId);
}
