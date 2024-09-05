"use strict";(self.webpackChunkdocumentation=self.webpackChunkdocumentation||[]).push([[15709],{77980:(e,n,t)=>{t.r(n),t.d(n,{assets:()=>u,contentTitle:()=>o,default:()=>p,frontMatter:()=>i,metadata:()=>c,toc:()=>d});var r=t(74848),a=t(28453),l=t(49489),s=t(7227);const i={},o="All api changes to 0.5.0",c={id:"develop/adapters/api-changes/0.5.0",title:"All api changes to 0.5.0",description:"This document lists all the API changes introduced in version 0.5.0 of the TypeWriter plugin. If you are upgrading from an older version, please read this document before upgrading.",source:"@site/versioned_docs/version-0.5.0/develop/02-adapters/06-api-changes/0.5.0.mdx",sourceDirName:"develop/02-adapters/06-api-changes",slug:"/develop/adapters/api-changes/0.5.0",permalink:"/develop/adapters/api-changes/0.5.0",draft:!1,unlisted:!1,editUrl:"https://github.com/gabber235/TypeWriter/tree/develop/documentation/versioned_docs/version-0.5.0/develop/02-adapters/06-api-changes/0.5.0.mdx",tags:[],version:"0.5.0",lastUpdatedBy:"Gabber235",lastUpdatedAt:1725524848e3,frontMatter:{},sidebar:"develop",previous:{title:"API Changes",permalink:"/develop/adapters/api-changes/"}},u={},d=[{value:"New type: Ref",id:"new-type-ref",level:2},{value:"Change to facts interface",id:"change-to-facts-interface",level:2},{value:"Entry Icon Changes",id:"entry-icon-changes",level:2}];function h(e){const n={a:"a",code:"code",h1:"h1",h2:"h2",header:"header",p:"p",pre:"pre",...(0,a.R)(),...e.components};return(0,r.jsxs)(r.Fragment,{children:[(0,r.jsx)(n.header,{children:(0,r.jsx)(n.h1,{id:"all-api-changes-to-050",children:"All api changes to 0.5.0"})}),"\n",(0,r.jsxs)(n.p,{children:["This document lists all the API changes introduced in version ",(0,r.jsx)(n.code,{children:"0.5.0"})," of the TypeWriter plugin. If you are upgrading from an older version, please read this document before upgrading."]}),"\n",(0,r.jsx)(n.h2,{id:"new-type-ref",children:"New type: Ref"}),"\n",(0,r.jsx)(n.p,{children:"To streamline the api more, I created a new type called Ref.\nIt provides a much nicer api for referencing entries."}),"\n",(0,r.jsxs)(l.A,{children:[(0,r.jsxs)(s.A,{value:"old",label:"Old",children:[(0,r.jsx)(n.pre,{children:(0,r.jsx)(n.code,{className:"language-kotlin",metastring:"showLineNumbers",children:'class ExampleEntry(\n    // ...\n    override val triggers: List<String> = emptyList(),\n    @EntryIdentifier(OtherEntry::class)\n    val identifier: String = "",\n    // ...\n) : TriggerableEntry\n'})}),(0,r.jsx)(n.p,{children:"Getting entry:"}),(0,r.jsx)(n.pre,{children:(0,r.jsx)(n.code,{className:"language-kotlin",metastring:"showLineNumbers",children:"val otherEntry = Query.findById<OtherEntry>(entry.identifier)\n"})})]}),(0,r.jsxs)(s.A,{value:"new",label:"New",default:!0,children:[(0,r.jsx)(n.pre,{children:(0,r.jsx)(n.code,{className:"language-kotlin",metastring:"showLineNumbers",children:"class ExampleEntry(\n    // ...\n    override val triggers: List<Ref<TriggerableEntry>> = emptyList(),\n    val identifier: Ref<OtherEntry> = emptyRef(),\n    // ...\n) : TriggerableEntry\n"})}),(0,r.jsx)(n.p,{children:"Getting entry:"}),(0,r.jsx)(n.pre,{children:(0,r.jsx)(n.code,{className:"language-kotlin",metastring:"showLineNumbers",children:"val otherEntry = entry.identifier.get()\n"})})]})]}),"\n",(0,r.jsx)(n.h2,{id:"change-to-facts-interface",children:"Change to facts interface"}),"\n",(0,r.jsxs)(n.p,{children:["Since ",(0,r.jsx)(n.code,{children:"Facts"})," can now be applied to groups of players, the ",(0,r.jsx)(n.code,{children:"read"})," function no longer works.\nA simple migration is to use the ",(0,r.jsx)(n.code,{children:"readSinglePlayer"})," function instead."]}),"\n",(0,r.jsxs)(l.A,{children:[(0,r.jsx)(s.A,{value:"old",label:"Old",children:(0,r.jsx)(n.pre,{children:(0,r.jsx)(n.code,{className:"language-kotlin",metastring:"showLineNumbers",children:'class InventoryItemCountFact(\n    override val id: String = "",\n    override val name: String = "",\n    override val comment: String = "",\n    @Help("The item to check for.")\n    val item: Item = Item.Empty,\n) : ReadableFactEntry {\n    override fun read(playerId: UUID): Fact {\n        val player = server.getPlayer(playerId) ?: return Fact(id, 0)\n        val amount = player.inventory.contents.filterNotNull().filter { item.isSameAs(player, it) }.sumOf { it.amount }\n        return Fact(id, amount)\n    }\n}\n'})})}),(0,r.jsx)(s.A,{value:"new",label:"New",default:!0,children:(0,r.jsx)(n.pre,{children:(0,r.jsx)(n.code,{className:"language-kotlin",metastring:"showLineNumbers",children:'class InventoryItemCountFact(\n    override val id: String = "",\n    override val name: String = "",\n    override val comment: String = "",\n    override val group: Ref<GroupEntry> = emptyRef(),\n    @Help("The item to check for.")\n    val item: Item = Item.Empty,\n) : ReadableFactEntry {\n    override fun readSinglePlayer(player: Player): FactData {\n        val amount = player.inventory.contents.filterNotNull().filter { item.isSameAs(player, it) }.sumOf { it.amount }\n        return FactData(amount)\n    }\n}\n'})})})]}),"\n",(0,r.jsx)(n.h2,{id:"entry-icon-changes",children:"Entry Icon Changes"}),"\n",(0,r.jsxs)(n.p,{children:["The icon set has changed from only allowing Font Awesome icons, to allowing any icon from ",(0,r.jsx)(n.a,{href:"https://iconify.design/",children:"Iconify"}),".\nThis means that entries can use any icon from ",(0,r.jsx)(n.a,{href:"https://iconify.design/",children:"Iconify"}),".\nSince the icon set is so big, there no longer is a nice ",(0,r.jsx)(n.code,{children:"Icon"})," class. Instead, you just pass the icon name to the icon parameter."]}),"\n",(0,r.jsxs)(l.A,{children:[(0,r.jsx)(s.A,{value:"old",label:"Old",children:(0,r.jsx)(n.pre,{children:(0,r.jsx)(n.code,{className:"language-kotlin",metastring:"showLineNumbers",children:'@Entry("add_potion_effect", "Add a potion effect to the player", Colors.RED, Icons.FLASK_VIAL)\n'})})}),(0,r.jsx)(s.A,{value:"new",label:"New",default:!0,children:(0,r.jsx)(n.pre,{children:(0,r.jsx)(n.code,{className:"language-kotlin",metastring:"showLineNumbers",children:'@Entry("add_potion_effect", "Add a potion effect to the player", Colors.RED, "fa6-solid:flask-vial")\n'})})})]})]})}function p(e={}){const{wrapper:n}={...(0,a.R)(),...e.components};return n?(0,r.jsx)(n,{...e,children:(0,r.jsx)(h,{...e})}):h(e)}},7227:(e,n,t)=>{t.d(n,{A:()=>s});t(96540);var r=t(34164);const a={tabItem:"tabItem_Ymn6"};var l=t(74848);function s(e){let{children:n,hidden:t,className:s}=e;return(0,l.jsx)("div",{role:"tabpanel",className:(0,r.A)(a.tabItem,s),hidden:t,children:n})}},49489:(e,n,t)=>{t.d(n,{A:()=>I});var r=t(96540),a=t(34164),l=t(24245),s=t(56347),i=t(36494),o=t(62814),c=t(45167),u=t(69900);function d(e){return r.Children.toArray(e).filter((e=>"\n"!==e)).map((e=>{if(!e||(0,r.isValidElement)(e)&&function(e){const{props:n}=e;return!!n&&"object"==typeof n&&"value"in n}(e))return e;throw new Error(`Docusaurus error: Bad <Tabs> child <${"string"==typeof e.type?e.type:e.type.name}>: all children of the <Tabs> component should be <TabItem>, and every <TabItem> should have a unique "value" prop.`)}))?.filter(Boolean)??[]}function h(e){const{values:n,children:t}=e;return(0,r.useMemo)((()=>{const e=n??function(e){return d(e).map((e=>{let{props:{value:n,label:t,attributes:r,default:a}}=e;return{value:n,label:t,attributes:r,default:a}}))}(t);return function(e){const n=(0,c.XI)(e,((e,n)=>e.value===n.value));if(n.length>0)throw new Error(`Docusaurus error: Duplicate values "${n.map((e=>e.value)).join(", ")}" found in <Tabs>. Every value needs to be unique.`)}(e),e}),[n,t])}function p(e){let{value:n,tabValues:t}=e;return t.some((e=>e.value===n))}function m(e){let{queryString:n=!1,groupId:t}=e;const a=(0,s.W6)(),l=function(e){let{queryString:n=!1,groupId:t}=e;if("string"==typeof n)return n;if(!1===n)return null;if(!0===n&&!t)throw new Error('Docusaurus error: The <Tabs> component groupId prop is required if queryString=true, because this value is used as the search param name. You can also provide an explicit value such as queryString="my-search-param".');return t??null}({queryString:n,groupId:t});return[(0,o.aZ)(l),(0,r.useCallback)((e=>{if(!l)return;const n=new URLSearchParams(a.location.search);n.set(l,e),a.replace({...a.location,search:n.toString()})}),[l,a])]}function f(e){const{defaultValue:n,queryString:t=!1,groupId:a}=e,l=h(e),[s,o]=(0,r.useState)((()=>function(e){let{defaultValue:n,tabValues:t}=e;if(0===t.length)throw new Error("Docusaurus error: the <Tabs> component requires at least one <TabItem> children component");if(n){if(!p({value:n,tabValues:t}))throw new Error(`Docusaurus error: The <Tabs> has a defaultValue "${n}" but none of its children has the corresponding value. Available values are: ${t.map((e=>e.value)).join(", ")}. If you intend to show no default tab, use defaultValue={null} instead.`);return n}const r=t.find((e=>e.default))??t[0];if(!r)throw new Error("Unexpected error: 0 tabValues");return r.value}({defaultValue:n,tabValues:l}))),[c,d]=m({queryString:t,groupId:a}),[f,g]=function(e){let{groupId:n}=e;const t=function(e){return e?`docusaurus.tab.${e}`:null}(n),[a,l]=(0,u.Dv)(t);return[a,(0,r.useCallback)((e=>{t&&l.set(e)}),[t,l])]}({groupId:a}),v=(()=>{const e=c??f;return p({value:e,tabValues:l})?e:null})();(0,i.A)((()=>{v&&o(v)}),[v]);return{selectedValue:s,selectValue:(0,r.useCallback)((e=>{if(!p({value:e,tabValues:l}))throw new Error(`Can't select invalid tab value=${e}`);o(e),d(e),g(e)}),[d,g,l]),tabValues:l}}var g=t(11062);const v={tabList:"tabList__CuJ",tabItem:"tabItem_LNqP"};var y=t(74848);function b(e){let{className:n,block:t,selectedValue:r,selectValue:s,tabValues:i}=e;const o=[],{blockElementScrollPositionUntilNextRender:c}=(0,l.a_)(),u=e=>{const n=e.currentTarget,t=o.indexOf(n),a=i[t].value;a!==r&&(c(n),s(a))},d=e=>{let n=null;switch(e.key){case"Enter":u(e);break;case"ArrowRight":{const t=o.indexOf(e.currentTarget)+1;n=o[t]??o[0];break}case"ArrowLeft":{const t=o.indexOf(e.currentTarget)-1;n=o[t]??o[o.length-1];break}}n?.focus()};return(0,y.jsx)("ul",{role:"tablist","aria-orientation":"horizontal",className:(0,a.A)("tabs",{"tabs--block":t},n),children:i.map((e=>{let{value:n,label:t,attributes:l}=e;return(0,y.jsx)("li",{role:"tab",tabIndex:r===n?0:-1,"aria-selected":r===n,ref:e=>o.push(e),onKeyDown:d,onClick:u,...l,className:(0,a.A)("tabs__item",v.tabItem,l?.className,{"tabs__item--active":r===n}),children:t??n},n)}))})}function x(e){let{lazy:n,children:t,selectedValue:l}=e;const s=(Array.isArray(t)?t:[t]).filter(Boolean);if(n){const e=s.find((e=>e.props.value===l));return e?(0,r.cloneElement)(e,{className:(0,a.A)("margin-top--md",e.props.className)}):null}return(0,y.jsx)("div",{className:"margin-top--md",children:s.map(((e,n)=>(0,r.cloneElement)(e,{key:n,hidden:e.props.value!==l})))})}function j(e){const n=f(e);return(0,y.jsxs)("div",{className:(0,a.A)("tabs-container",v.tabList),children:[(0,y.jsx)(b,{...n,...e}),(0,y.jsx)(x,{...n,...e})]})}function I(e){const n=(0,g.A)();return(0,y.jsx)(j,{...e,children:d(e.children)},String(n))}}}]);