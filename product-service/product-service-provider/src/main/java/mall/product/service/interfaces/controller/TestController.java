package mall.product.service.interfaces.controller;

import io.swagger.annotations.Api;
import lombok.Getter;
import mall.service.exception.BusinessException;
import mall.service.exception.SystemException;
import mall.web.service.dto.Result;
import mall.web.service.dto.ResultStatus;
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
        return Result.fail(ResultStatus.BUSINESS_ERROR, "INTERNAL_ERROR");
    }

    @GetMapping(path = "result2")
    public Object result2() {
        return Result.fail(ResultStatus.SYSTEM_ERROR, "INTERNAL_ERROR", Greeting.of("Whoops"));
    }

    @GetMapping(path = "exp1")
    public Object throwExp1() {
        throw new SystemException("SystemException");
    }

    @GetMapping(path = "exp2")
    public Object throwExp2() {
        throw new BusinessException("BusinessException");
    }
}
