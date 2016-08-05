<div class="input-group">
<input type="hidden"<#rt/>
	name="${parameters.name?default("")?html}"<#rt/>
	<#if parameters.id?exists>
	 id="${parameters.id?html}"<#rt/>
	</#if>
	<#if parameters.nameValue?exists>
		value="<@s.property value="parameters.nameValue"/>"<#rt/>
	</#if>
	<#if parameters.definition?exists>
 	definition="${parameters.definition?html}"<#rt/>
/><input type="text"<#rt/>
<#if parameters.name?exists>
 name="${parameters.name?html}_text"<#rt/>
</#if>
<#if parameters.id?exists>
 id="${parameters.id?html}_text"<#rt/>
</#if>
<#if parameters.get("size")?exists>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.maxlength?exists>
 maxlength="${parameters.maxlength?html}"<#rt/>
</#if>
<#if parameters.nameText?exists>
 value="<@s.property value="parameters.nameText"/>"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.readonly?default(false)>
 readonly="readonly"<#rt/>
</#if>
<#if parameters.tabindex?exists>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>

<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
<#if parameters.cssStyle?exists>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.title?exists>
 title="${parameters.title?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
/>
<span class="input-group-btn"><button type="button"<#rt/>
<#if parameters.name?exists>
 name="${parameters.name?html}_button"<#rt/>
</#if>
<#if parameters.name?exists>
 name="${parameters.name?html}_button"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
 <#if parameters.readonly?default(false)>
 disabled="disabled"<#rt/>
</#if>
 class="btn btn-info btn-flat"<#rt/> 
</#if>
 onclick="javascript:openPicker(this,'${parameters.definition?html}');"
><i class="fa fa-search-plus"></i></button>
</span>
</div>
