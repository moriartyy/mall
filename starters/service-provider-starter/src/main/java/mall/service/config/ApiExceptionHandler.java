package mall.service.config;

import lombok.extern.slf4j.Slf4j;
import mall.service.contract.api.ApiException;
import mall.service.contract.api.ApiStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

import static mall.service.contract.api.ApiResult.fail;
import static mall.service.util.ExceptionUtils.buildMessage;

/**
 * @author hongmiao.yu on 5/5/17.
 */
@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public Object handle(MethodArgumentTypeMismatchException e) {
        return fail(ApiStatus.INVALID_PARAMETER_TYPE, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(MissingServletRequestParameterException e) {
        return fail(ApiStatus.MISSING_PARAMETER, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(BindException e) {
        return fail(ApiStatus.INVALID_PARAMETER, buildMessage(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(MethodArgumentNotValidException e) {
        return fail(ApiStatus.INVALID_PARAMETER, buildMessage(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(ConstraintViolationException e) {
        return fail(ApiStatus.INVALID_PARAMETER, buildMessage(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(ApiException e) {
        return fail(e.getStatus(), e.getMessage(), e.getError());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(Exception e) {
        log.error("Handling {}", e.getClass().getSimpleName(), e);
        return fail(ApiStatus.INTERNAL_ERROR, e.getMessage());
    }
}
