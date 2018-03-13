<#include "../include/imports.ftl">

<#if plainResource?has_content && plainResource.valueMap?has_content>
    <div>
        <h1>Your spirit animal is a: ${plainResource.valueMap.string}</h1>
    </div>
</#if>
