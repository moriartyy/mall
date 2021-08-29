package mall.dictionary.api.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mall.dictionary.api.dto.DictionaryDeleteParams;
import mall.dictionary.api.dto.DictionaryGetParams;
import mall.dictionary.api.dto.DictionaryInfo;
import mall.dictionary.api.dto.DictionarySaveParams;
import mall.webservice.api.annotation.RequestParams;
import mall.webservice.api.dto.Acknowledgement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author walter
 */
@Api(value = "dictionary-service")
@FeignClient(name = "dictionary-service")
public interface DictionaryService {

    @ApiOperation(value = "save")
    @RequestMapping(path = "dictionary/save", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    Acknowledgement save(@RequestParams DictionarySaveParams dictionarySaveParams);

    @ApiOperation(value = "get")
    @RequestMapping(path = "dictionary/get", method = {RequestMethod.POST, RequestMethod.GET}, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    DictionaryInfo get(@RequestParams DictionaryGetParams dictionaryGetParams);

    @ApiOperation(value = "delete")
    @RequestMapping(path = "dictionary/delete", method = {RequestMethod.POST, RequestMethod.GET}, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    Acknowledgement delete(@RequestParams DictionaryDeleteParams dictionaryDeleteParams);
}
