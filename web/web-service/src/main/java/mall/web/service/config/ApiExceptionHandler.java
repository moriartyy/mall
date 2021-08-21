package mall.web.service.config;

import lombok.extern.slf4j.Slf4j;
import mall.common.exception.BusinessException;
import mall.common.exception.SystemException;
import mall.web.service.api.exception.ApiException;
import mall.web.service.api.result.ApiResult;
import mall.web.service.api.result.ApiStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

/**
 * @author hongmiao.yu on 5/5/17.
 */
@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public Object handle(MethodArgumentTypeMismatchException e) {
        return ApiResult.fail(ApiStatus.INVALID_PARAMETER_TYPE, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(MissingServletRequestParameterException e) {
        return ApiResult.fail(ApiStatus.MISSING_PARAMETER, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(BindException e) {
        return ApiResult.fail(ApiStatus.INVALID_PARAMETER, ExceptionUtils.buildMessage(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(MethodArgumentNotValidException e) {
        return ApiResult.fail(ApiStatus.INVALID_PARAMETER, ExceptionUtils.buildMessage(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(ConstraintViolationException e) {
        return ApiResult.fail(ApiStatus.INVALID_PARAMETER, ExceptionUtils.buildMessage(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(BusinessException e) {
        return ApiResult.fail(ApiStatus.BUSINESS_ERROR, e.getMessage(), e.getError());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(SystemException e) {
        return ApiResult.fail(ApiStatus.SYSTEM_ERROR, e.getMessage(), e.getError());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(ApiException e) {
        return ApiResult.fail(e.getStatus(), e.getMessage(), e.getError());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(Exception e) {
        log.error("Handling {}", e.getClass().getSimpleName(), e);
        return ApiResult.fail(ApiStatus.UNKNOWN_ERROR, e.getMessage());
    }
}
