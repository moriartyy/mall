package ${baseInfo.packageName};

import lombok.RequiredArgsConstructor;
import ${tableClass.fullClassName};
import ${repositoryImpl.packageName}.${repositoryImpl.fileName};
import ${mapperInterface.packageName}.${mapperInterface.fileName};
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

<#assign mapperName = mapperInterface.fileName>
<#assign mapperNameLower = mapperName?uncap_first>

/**
* @author Walter
*/
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ${baseInfo.fileName} implements ${tableClass.shortClassName}Repository {

private final ${mapperName} ${mapperNameLower};

}




