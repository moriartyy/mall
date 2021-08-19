package dmall.product.service.interfaces.controller;

import dmall.product.service.application.ProductServiceImpl;
import dmall.product.service.contract.ProductService;
import dmall.product.service.contract.dto.ProductCreateParams;
import dmall.product.service.contract.dto.ProductGetParams;
import dmall.product.service.contract.dto.ProductInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walter
 */
@Api("Product Management")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController implements ProductService {

    private final ProductServiceImpl productServiceImpl;


    @ApiOperation(value = "获取Product")
    @RequestMapping(path = "product/get", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json")
    @Override
    public ProductInfo get(ProductGetParams productGetParams) {
        return productServiceImpl.get(productGetParams);
    }

    @ApiOperation(value = "create")
    @PostMapping(path = "product/create", produces = "application/json")
    @Override
    public Integer create(ProductCreateParams productCreateParams) {
        return productServiceImpl.create(productCreateParams);
    }
}
