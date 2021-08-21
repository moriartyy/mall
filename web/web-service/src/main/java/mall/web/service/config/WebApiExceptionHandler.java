package mall.web.service.config;

import lombok.extern.slf4j.Slf4j;
import mall.common.exception.BusinessException;
import mall.common.exception.SystemException;
import mall.web.service.api.exception.WebApiException;
import mall.web.service.api.result.WebApiResult;
import mall.web.service.api.result.WebApiStatus;
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
public class WebApiExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public Object handle(MethodArgumentTypeMismatchException e) {
        return WebApiResult.fail(WebApiStatus.INVALID_PARAMETER_TYPE, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(MissingServletRequestParameterException e) {
        return WebApiResult.fail(WebApiStatus.MISSING_PARAMETER, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(BindException e) {
        return WebApiResult.fail(WebApiStatus.INVALID_PARAMETER, ExceptionMessageExtractor.extract(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(MethodArgumentNotValidException e) {
        return WebApiResult.fail(WebApiStatus.INVALID_PARAMETER, ExceptionMessageExtractor.extract(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(ConstraintViolationException e) {
        return WebApiResult.fail(WebApiStatus.INVALID_PARAMETER, ExceptionMessageExtractor.extract(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(BusinessException e) {
        return WebApiResult.fail(WebApiStatus.BUSINESS_ERROR, e.getMessage(), e.getError());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(SystemException e) {
        return WebApiResult.fail(WebApiStatus.SYSTEM_ERROR, e.getMessage(), e.getError());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(WebApiException e) {
        return WebApiResult.fail(e.getStatus(), e.getMessage(), e.getError());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(Exception e) {
        log.error("Handling {}", e.getClass().getSimpleName(), e);
        return WebApiResult.fail(WebApiStatus.UNKNOWN_ERROR, e.getMessage());
    }
}
