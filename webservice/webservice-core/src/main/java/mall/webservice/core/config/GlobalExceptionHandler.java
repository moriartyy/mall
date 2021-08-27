package mall.webservice.core.config;

import lombok.extern.slf4j.Slf4j;
import mall.common.exception.BusinessException;
import mall.common.exception.SystemException;
import mall.webservice.api.Error;
import mall.webservice.api.Result;
import mall.webservice.api.ResultStatus;
import mall.webservice.core.util.ExceptionUtils;
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
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public Object handle(MethodArgumentTypeMismatchException e) {
        return Result.fail(ResultStatus.INVALID_PARAMETER_TYPE, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(MissingServletRequestParameterException e) {
        return Result.fail(ResultStatus.MISSING_PARAMETER, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(BindException e) {
        return Result.fail(ResultStatus.INVALID_PARAMETER, ExceptionUtils.buildMessage(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(MethodArgumentNotValidException e) {
        return Result.fail(ResultStatus.INVALID_PARAMETER, ExceptionUtils.buildMessage(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(ConstraintViolationException e) {
        return Result.fail(ResultStatus.INVALID_PARAMETER, ExceptionUtils.buildMessage(e));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(BusinessException e) {
        return Result.fail(ResultStatus.BUSINESS_ERROR, Error.of(e.getErrorCode(), e.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(SystemException e) {
        return Result.fail(ResultStatus.SYSTEM_ERROR, Error.of(e.getErrorCode(), e.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler
    public Object handle(Exception e) {
        log.error("Handling {}", e.getClass().getSimpleName(), e);
        return Result.fail(ResultStatus.UNKNOWN_ERROR, e.getMessage());
    }
}
