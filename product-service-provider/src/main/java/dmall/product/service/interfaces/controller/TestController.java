package dmall.product.service.interfaces.controller;

import dmall.service.contract.api.ApiError;
import dmall.service.contract.api.ApiException;
import dmall.service.contract.api.ApiResult;
import dmall.service.contract.api.ApiStatus;
import io.swagger.annotations.Api;
import lombok.Getter;
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
        return ApiResult.fail(ApiStatus.INTERNAL_ERROR, "INTERNAL_ERROR", ApiError.UNKNOWN);
    }

    @GetMapping(path = "result2")
    public Object result2() {
        return ApiResult.fail(ApiStatus.INTERNAL_ERROR, "INTERNAL_ERROR", Greeting.of("Whoops"), ApiError.UNKNOWN);
    }

    @GetMapping(path = "exp1")
    public Object throwExp1() {
        throw new ApiException(ApiStatus.INTERNAL_ERROR);
    }

    @GetMapping(path = "exp2")
    public Object throwExp2() {
        throw new ApiException(ApiStatus.INTERNAL_ERROR, ApiError.UNKNOWN);
    }
}
