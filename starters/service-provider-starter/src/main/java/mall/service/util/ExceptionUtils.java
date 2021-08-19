package mall.service.util;

import com.google.common.base.CaseFormat;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hongmiao.yu
 */
public class ExceptionUtils {

    private ExceptionUtils() {
    }

    public static String buildMessage(MethodArgumentNotValidException e) {
        return buildMessage(e.getBindingResult());
    }

    public static String buildMessage(BindingResult bindingResult) {
        List<String> errors = bindingResult.getAllErrors()
                .stream()
                .map(e -> {
                    if (e instanceof FieldError) {
                        FieldError fe = (FieldError) e;
                        return toLowerUnderscore(fe.getField()) + e.getDefaultMessage();
                    }
                    return e.getDefaultMessage();
                })
                .collect(Collectors.toList());
        return errors.get(0);
    }

    private static String toLowerUnderscore(String name) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
    }

    public static String buildMessage(ConstraintViolationException e) {
        List<String> errors = e.getConstraintViolations()
                .stream()
                .map(cv -> {
                    String message = (String) cv.getConstraintDescriptor().getAttributes().get("message");
                    if (message != null && isTemplate(message)) {
                        return getPropertyPath(cv) + cv.getMessage();
                    }
                    return cv.getMessage();
                })
                .collect(Collectors.toList());
        return errors.get(0);
    }

    private static Path getPropertyPath(ConstraintViolation<?> cv) {
        return cv.getPropertyPath();
    }

    private static boolean isTemplate(String message) {
        return message.startsWith("{javax");
    }
}
