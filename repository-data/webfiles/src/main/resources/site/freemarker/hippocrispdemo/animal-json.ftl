<#include "../include/imports.ftl">

<#if resource?has_content && resource.valueMap?has_content>
    <#assign animal = resource.valueMap/>
    <div>
        <#if animal.name?has_content>
            <h1>${animal.name}</h1>
        </#if>
        <#if animal.description?has_content>
            <p>Description: ${animal.description}</p>
        </#if>
        <#if animal.color?has_content>
            <p>Color: ${animal.color}</p>
        </#if>
        <#if animal.heightFeet?has_content && animal.heightInch?has_content>
            <p>Height: ${animal.heightFeet}' ${animal.heightInch}"</p>
        </#if>
        <#if animal.weight?has_content>
            <p>Weight: ${animal.weight} lbs.</p>
        </#if>
    </div>
</#if>