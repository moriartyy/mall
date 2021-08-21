package mall.product.service.interfaces.controller;

import io.swagger.annotations.Api;
import lombok.Getter;
import mall.web.service.api.exception.WebApiException;
import mall.web.service.api.result.WebApiError;
import mall.web.service.api.result.WebApiResult;
import mall.web.service.api.result.WebApiStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@Api("Test")
@RestController
public class TestController {

    @GetMapping(path = "greeting")
    public Object greeting() {
        return Greeting.of("hello user!");
    }

    @Getter
    public static class Greeting {
        private String message;
        private final LocalDateTime now = LocalDateTime.now();

        public static Greeting of(String message) {
            Greeting g = new Greeting();
            g.message = message;
            return g;
        }
    }

    @GetMapping(path = "result1")
    public Object result1() {
        return WebApiResult.fail(WebApiStatus.BUSINESS_ERROR, "INTERNAL_ERROR", WebApiError.UNKNOWN);
    }

    @GetMapping(path = "result2")
    public Object result2() {
        return WebApiResult.fail(WebApiStatus.SYSTEM_ERROR, "INTERNAL_ERROR", Greeting.of("Whoops"), WebApiError.UNKNOWN);
    }

    @GetMapping(path = "exp1")
    public Object throwExp1() {
        throw new WebApiException(WebApiStatus.SYSTEM_ERROR);
    }

    @GetMapping(path = "exp2")
    public Object throwExp2() {
        throw new WebApiException(WebApiStatus.BUSINESS_ERROR, "INTERNAL_ERROR", WebApiError.UNKNOWN);
    }
}
