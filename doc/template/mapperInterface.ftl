package ${mapperInterface.packageName};

import ${tableClass.fullClassName};
<#if tableClass.pkFields??>
    <#list tableClass.pkFields as field><#assign pkName>${field.shortTypeName}</#assign></#list>
</#if>
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
*  @author walter
*/
public interface ${mapperInterface.fileName} extends BaseMapper<${tableClass.shortClassName}> {

}




