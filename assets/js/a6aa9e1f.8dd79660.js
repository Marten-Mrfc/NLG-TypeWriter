"use strict";(self.webpackChunkdocumentation=self.webpackChunkdocumentation||[]).push([[37643],{12783:(e,t,a)=>{a.r(t),a.d(t,{default:()=>j});a(96540);var s=a(34164),n=a(97639),r=a(17153),i=a(18630),l=a(6953),o=a(84934),c=a(51210),d=a(64331),m=a(21141),g=a(89101),u=a(74848);function h(e){const t=(0,g.kJ)(e);return(0,u.jsx)(m.A,{children:(0,u.jsx)("script",{type:"application/ld+json",children:JSON.stringify(t)})})}function p(e){const{metadata:t}=e,{siteConfig:{title:a}}=(0,n.A)(),{blogDescription:s,blogTitle:i,permalink:l}=t,o="/"===l?a:i;return(0,u.jsxs)(u.Fragment,{children:[(0,u.jsx)(r.be,{title:o,description:s}),(0,u.jsx)(c.A,{tag:"blog_posts_list"})]})}function x(e){const{metadata:t,items:a,sidebar:s}=e;return(0,u.jsxs)(l.A,{sidebar:s,children:[(0,u.jsx)(d.A,{items:a}),(0,u.jsx)(o.A,{metadata:t})]})}function j(e){return(0,u.jsxs)(r.e3,{className:(0,s.A)(i.G.wrapper.blogPages,i.G.page.blogListPage),children:[(0,u.jsx)(p,{...e}),(0,u.jsx)(h,{...e}),(0,u.jsx)(x,{...e})]})}},84934:(e,t,a)=>{a.d(t,{A:()=>i});a(96540);var s=a(23230),n=a(13555),r=a(74848);function i(e){const{metadata:t}=e,{previousPage:a,nextPage:i}=t;return(0,r.jsxs)("nav",{className:"pagination-nav","aria-label":(0,s.T)({id:"theme.blog.paginator.navAriaLabel",message:"Blog list page navigation",description:"The ARIA label for the blog pagination"}),children:[a&&(0,r.jsx)(n.A,{permalink:a,title:(0,r.jsx)(s.A,{id:"theme.blog.paginator.newerEntries",description:"The label used to navigate to the newer blog posts page (previous page)",children:"Newer entries"})}),i&&(0,r.jsx)(n.A,{permalink:i,title:(0,r.jsx)(s.A,{id:"theme.blog.paginator.olderEntries",description:"The label used to navigate to the older blog posts page (next page)",children:"Older entries"}),isNext:!0})]})}},23162:(e,t,a)=>{a.d(t,{A:()=>_});a(96540);var s=a(34164),n=a(89101),r=a(74848);function i(e){let{children:t,className:a}=e;return(0,r.jsx)("article",{className:a,children:t})}var l=a(14783);const o={title:"title_f1Hy"};function c(e){let{className:t}=e;const{metadata:a,isBlogPostPage:i}=(0,n.e7)(),{permalink:c,title:d}=a,m=i?"h1":"h2";return(0,r.jsx)(m,{className:(0,s.A)(o.title,t),children:i?d:(0,r.jsx)(l.A,{to:c,children:d})})}var d=a(23230),m=a(57824),g=a(49191);const u={container:"container_mt6G"};function h(e){let{readingTime:t}=e;const a=function(){const{selectMessage:e}=(0,m.W)();return t=>{const a=Math.ceil(t);return e(a,(0,d.T)({id:"theme.blog.post.readingTime.plurals",description:'Pluralized label for "{readingTime} min read". Use as much plural forms (separated by "|") as your language support (see https://www.unicode.org/cldr/cldr-aux/charts/34/supplemental/language_plural_rules.html)',message:"One min read|{readingTime} min read"},{readingTime:a}))}}();return(0,r.jsx)(r.Fragment,{children:a(t)})}function p(e){let{date:t,formattedDate:a}=e;return(0,r.jsx)("time",{dateTime:t,children:a})}function x(){return(0,r.jsx)(r.Fragment,{children:" \xb7 "})}function j(e){let{className:t}=e;const{metadata:a}=(0,n.e7)(),{date:i,readingTime:l}=a,o=(0,g.i)({day:"numeric",month:"long",year:"numeric",timeZone:"UTC"});return(0,r.jsxs)("div",{className:(0,s.A)(u.container,"margin-vert--md",t),children:[(0,r.jsx)(p,{date:i,formattedDate:(c=i,o.format(new Date(c)))}),void 0!==l&&(0,r.jsxs)(r.Fragment,{children:[(0,r.jsx)(x,{}),(0,r.jsx)(h,{readingTime:l})]})]});var c}var A=a(97184);const f={authorCol:"authorCol_Hf19",imageOnlyAuthorRow:"imageOnlyAuthorRow_pa_O",imageOnlyAuthorCol:"imageOnlyAuthorCol_G86a"};function b(e){let{className:t}=e;const{metadata:{authors:a},assets:i}=(0,n.e7)();if(0===a.length)return null;const l=a.every((e=>{let{name:t}=e;return!t})),o=1===a.length;return(0,r.jsx)("div",{className:(0,s.A)("margin-top--md margin-bottom--sm",l?f.imageOnlyAuthorRow:"row",t),children:a.map(((e,t)=>(0,r.jsx)("div",{className:(0,s.A)(!l&&(o?"col col--12":"col col--6"),l?f.imageOnlyAuthorCol:f.authorCol),children:(0,r.jsx)(A.A,{author:{...e,imageURL:i.authorsImageUrls[t]??e.imageURL}})},t)))})}function v(){return(0,r.jsxs)("header",{children:[(0,r.jsx)(c,{}),(0,r.jsx)(j,{}),(0,r.jsx)(b,{})]})}var N=a(64609),T=a(44430);function y(e){let{children:t,className:a}=e;const{isBlogPostPage:i}=(0,n.e7)();return(0,r.jsx)("div",{id:i?N.LU:void 0,className:(0,s.A)("markdown",a),children:(0,r.jsx)(T.A,{children:t})})}var w=a(18630),k=a(15659),P=a(81113);function U(){return(0,r.jsx)("b",{children:(0,r.jsx)(d.A,{id:"theme.blog.post.readMore",description:"The label used in blog post item excerpts to link to full blog posts",children:"Read more"})})}function C(e){const{blogPostTitle:t,...a}=e;return(0,r.jsx)(l.A,{"aria-label":(0,d.T)({message:"Read more about {title}",id:"theme.blog.post.readMoreLabel",description:"The ARIA label for the link to full blog posts from excerpts"},{title:t}),...a,children:(0,r.jsx)(U,{})})}function R(){const{metadata:e,isBlogPostPage:t}=(0,n.e7)(),{tags:a,title:i,editUrl:l,hasTruncateMarker:o,lastUpdatedBy:c,lastUpdatedAt:d}=e,m=!t&&o,g=a.length>0;if(!(g||m||l))return null;if(t){const e=!!(l||d||c);return(0,r.jsxs)("footer",{className:"docusaurus-mt-lg",children:[g&&(0,r.jsx)("div",{className:(0,s.A)("row","margin-top--sm",w.G.blog.blogFooterEditMetaRow),children:(0,r.jsx)("div",{className:"col",children:(0,r.jsx)(P.A,{tags:a})})}),e&&(0,r.jsx)(k.A,{className:(0,s.A)("margin-top--sm",w.G.blog.blogFooterEditMetaRow),editUrl:l,lastUpdatedAt:d,lastUpdatedBy:c})]})}return(0,r.jsxs)("footer",{className:"row docusaurus-mt-lg",children:[g&&(0,r.jsx)("div",{className:(0,s.A)("col",{"col--9":m}),children:(0,r.jsx)(P.A,{tags:a})}),m&&(0,r.jsx)("div",{className:(0,s.A)("col text--right",{"col--3":g}),children:(0,r.jsx)(C,{blogPostTitle:i,to:e.permalink})})]})}function _(e){let{children:t,className:a}=e;const l=function(){const{isBlogPostPage:e}=(0,n.e7)();return e?void 0:"margin-bottom--xl"}();return(0,r.jsxs)(i,{className:(0,s.A)(l,a),children:[(0,r.jsx)(v,{}),(0,r.jsx)(y,{children:t}),(0,r.jsx)(R,{})]})}},64331:(e,t,a)=>{a.d(t,{A:()=>i});a(96540);var s=a(89101),n=a(23162),r=a(74848);function i(e){let{items:t,component:a=n.A}=e;return(0,r.jsx)(r.Fragment,{children:t.map((e=>{let{content:t}=e;return(0,r.jsx)(s.in,{content:t,children:(0,r.jsx)(a,{children:(0,r.jsx)(t,{})})},t.metadata.permalink)}))})}},28051:(e,t,a)=>{a.d(t,{A:()=>l});a(96540);var s=a(34164),n=a(6178);const r={img:"img_CujE"};var i=a(74848);function l(e){return(e.src??"").endsWith(".gif")?(0,i.jsx)("img",{decoding:"async",loading:"lazy",...e,className:(t=e.className,(0,s.A)(t,r.img))}):(0,i.jsxs)(n.A,{type:"danger",title:"Invalid image",children:["Image component not found, please report this in the ",(0,i.jsx)("a",{href:"https://discord.gg/gs5QYhfv9x",children:"TypeWriter Discord"}),"."]});var t}}}]);