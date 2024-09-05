"use strict";(self.webpackChunkdocumentation=self.webpackChunkdocumentation||[]).push([[61283],{13862:(e,t,a)=>{a.r(t),a.d(t,{assets:()=>d,contentTitle:()=>s,default:()=>h,frontMatter:()=>i,metadata:()=>c,toc:()=>l});var n=a(74848),r=a(28453);const i={},s="ArtifactEntry",c={id:"develop/adapters/entries/static/artifact",title:"ArtifactEntry",description:"The ArtifactEntry is a specialized interface derived from AssetEntry.",source:"@site/versioned_docs/version-0.4.2/develop/02-adapters/03-entries/static/artifact.mdx",sourceDirName:"develop/02-adapters/03-entries/static",slug:"/develop/adapters/entries/static/artifact",permalink:"/0.4.2/develop/adapters/entries/static/artifact",draft:!1,unlisted:!1,editUrl:"https://github.com/gabber235/TypeWriter/tree/develop/documentation/versioned_docs/version-0.4.2/develop/02-adapters/03-entries/static/artifact.mdx",tags:[],version:"0.4.2",lastUpdatedBy:"Gabber235",lastUpdatedAt:1725524848e3,frontMatter:{},sidebar:"develop",previous:{title:"CinematicEntry",permalink:"/0.4.2/develop/adapters/entries/cinematic/"},next:{title:"AssetEntry",permalink:"/0.4.2/develop/adapters/entries/static/asset"}},d={},l=[{value:"Usage",id:"usage",level:2},{value:"Defining an ArtifactEntry",id:"defining-an-artifactentry",level:3},{value:"Accessing the Artifact&#39;s Content",id:"accessing-the-artifacts-content",level:3}];function o(e){const t={code:"code",h1:"h1",h2:"h2",h3:"h3",header:"header",p:"p",pre:"pre",...(0,r.R)(),...e.components};return(0,n.jsxs)(n.Fragment,{children:[(0,n.jsx)(t.header,{children:(0,n.jsx)(t.h1,{id:"artifactentry",children:"ArtifactEntry"})}),"\n",(0,n.jsxs)(t.p,{children:["The ",(0,n.jsx)(t.code,{children:"ArtifactEntry"})," is a specialized interface derived from ",(0,n.jsx)(t.code,{children:"AssetEntry"}),".\nIts primary purpose is to handle artifacts, which are assets generated by the plugins/adapters itself.\nUnlike standard assets, artifacts are usually dynamic and created during runtime.\nThis makes them particularly useful for storing data that changes based on player interactions or game events."]}),"\n",(0,n.jsxs)(t.p,{children:["An essential feature of ",(0,n.jsx)(t.code,{children:"ArtifactEntry"})," is its unique ",(0,n.jsx)(t.code,{children:"artifactId"}),".\nThis identifier must remain constant once assigned and is used to reference the artifact within the plugin."]}),"\n",(0,n.jsx)(t.h2,{id:"usage",children:"Usage"}),"\n",(0,n.jsxs)(t.p,{children:["Here's a generic example of creating and using an ",(0,n.jsx)(t.code,{children:"ArtifactEntry"}),":"]}),"\n",(0,n.jsx)(t.h3,{id:"defining-an-artifactentry",children:"Defining an ArtifactEntry"}),"\n",(0,n.jsx)(t.pre,{children:(0,n.jsx)(t.code,{className:"language-kotlin",children:'@Entry("example_artifact", "An example artifact entry.", Colors.BLUE, Icons.ARROW)\nclass ExampleArtifactEntry(\n    override val id: String = "",\n    override val name: String = "",\n    override val artifactId: String = "",\n) : ArtifactEntry\n'})}),"\n",(0,n.jsx)(t.h3,{id:"accessing-the-artifacts-content",children:"Accessing the Artifact's Content"}),"\n",(0,n.jsx)(t.pre,{children:(0,n.jsx)(t.code,{className:"language-kotlin",children:"import org.koin.java.KoinJavaComponent.get\n\nval assetManager = get<AssetManager>(AssetManager::class.java)\n\nval id = // ID of the entry\nval entry = Query.findById<ExampleArtifactEntry>(id)\nval content: String = assetManager.fetchAsset(entry)\n"})}),"\n",(0,n.jsxs)(t.p,{children:["In this example, ",(0,n.jsx)(t.code,{children:"ExampleArtifactEntry"})," is defined as an artifact with a unique identifier. The ",(0,n.jsx)(t.code,{children:"assetManager.fetchAsset"})," method is then used to retrieve the content of the artifact, based on its ",(0,n.jsx)(t.code,{children:"artifactId"}),"."]})]})}function h(e={}){const{wrapper:t}={...(0,r.R)(),...e.components};return t?(0,n.jsx)(t,{...e,children:(0,n.jsx)(o,{...e})}):o(e)}}}]);