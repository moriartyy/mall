package mall.web.service.config;

import mall.web.service.annotation.RequestParams;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import java.util.List;

/**
 * @author walter
 */
public class RequestParamsResolver implements HandlerMethodArgumentResolver {

    private final ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor;
    private final RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor;

    public RequestParamsResolver(List<HttpMessageConverter<?>> converters) {
        this.servletModelAttributeMethodProcessor = new ServletModelAttributeMethodProcessor(true);
        this.requestResponseBodyMethodProcessor = new RequestResponseBodyMethodProcessor(converters);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestParams.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String contentType = webRequest.getHeader(HttpHeaders.CONTENT_TYPE);
        HandlerMethodArgumentResolver resolver = (contentType != null && contentType.startsWith(MimeTypeUtils.APPLICATION_JSON_VALUE))
                ? requestResponseBodyMethodProcessor
                : servletModelAttributeMethodProcessor;
        return resolver.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
    }
}
