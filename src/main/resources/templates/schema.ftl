<#-- ASSIGNING PARAMETERS -->

<#assign elements=doc["xsd:schema"]["xsd:element"] />

<#list elements as element>
    <#if element.@name == 'comment'>
        <#assign commentType=element.@type />
    <#elseif element.@name == 'purchaseOrder' >
        <#assign purchaseOrderType=element.@type />
    </#if>
</#list>

<#-- LOOPED JSON STRUCTURE -->
elements : {
    {
        <#list elements as element>
            ${element.@name} {
                type : "${element.@type?keep_after(":")}"
            }
        </#list>
    }
}
simpleTypes {
    {
        <#assign simpleTypes=doc["xsd:schema"]["xsd:simpleType"] />
        <#list simpleTypes as simple>
            ${simple.@name} {
                <#if simple?children?has_content >
                    <#list simple?children as child >
                        <#if child?node_name != '@text' >
                       ${child?node_name?keep_after(":")} {
                        <#list simple["xsd:restriction"]?children as res >
                            <#if res?node_name != '@text'>
                                ${res?node_name?keep_after(":")} : ${res.@value}
                            </#if>
                        </#list>
                    }
                    </#if>
                    </#list>
                </#if>
            }
        </#list>
    }

}