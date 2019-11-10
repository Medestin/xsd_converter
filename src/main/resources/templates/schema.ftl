<#-- ASSIGNING PARAMETERS -->

<#assign elements=doc["xsd:schema"]["xsd:element"] />

<#assign test>
    <#list elements as element>
        <#if element.@name == 'comment'>
            <#assign commentType=element.@type />
        <#elseif element.@name == 'purchaseOrder' >
            <#assign purchaseOrderType=element.@type />
        </#if>
    </#list>
</#assign>

<#-- JSON STRUCTURE -->
{

    comment {
        type : ${commentType}
    }

    purchaseOrder {
        type : ${purchaseOrderType}
    }

}