package mall.webservice.core.config;

import mall.common.util.JsonUtils;
import mall.webservice.api.dto.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author walter
 */
@ControllerAdvice(basePackages = "mall")
public class ResponseBodyWrapper implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        Object result = (body instanceof Result) ? body : Result.success(body);

        if (selectedConverterType == StringHttpMessageConverter.class) {
            result = JsonUtils.serializeToString(result);
        }

        return result;
    }
}
