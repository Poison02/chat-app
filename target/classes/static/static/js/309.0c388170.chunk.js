"use strict";(self.webpackChunkchat_app_front=self.webpackChunkchat_app_front||[]).push([[309],{1309:function(e,s,t){t.r(s);var n=t(2398),r=t(2310),a=t(2870),l=t(4336),c=t(591),i=t(6177),o=t.n(i),m=t(3047),u=t(3949),f=t(6961),d=t(3883),g=t(8692),x=t(3433),h=t(2388),p=function(e){var s,t=(0,l.TL)(),i=(0,a.UO)().chatId,p=(0,r.useState)(""),v=(0,n.Z)(p,2),j=v[0],w=v[1],N=(0,r.useState)(),b=(0,n.Z)(N,2),y=b[0],I=b[1],E=(0,l.CG)((function(e){return{groupList:e.message.groupList,groupMessageList:e.message.groupMessageList}}),l.ir),L=E.groupList,M=E.groupMessageList;(0,r.useEffect)((function(){L.forEach((function(e){e.groupId==i&&(s=e)})),I(s)}),[L]),(0,r.useEffect)((function(){t((0,x.bm)(i))}),[i]),(0,r.useEffect)((function(){(0,c.b)(),(0,c.I)().on("receiveGroupMessageEvent",(function(e){t((0,x.Kn)(e))}))}),[]);var Z=(0,r.useCallback)((function(e){w(e.target.value)}),[j]),k=function(){var e=(0,c.I)(),s=(new Date).getTime(),n={groupId:i,msgUsername:localStorage.getItem("username")||"",content:j,sendTime:s};t((0,x.Kn)({msgUsername:localStorage.getItem("username")||"",content:j,sendTime:s})),e.emit("sendGroupMessageEvent",n),w("")};return(0,h.jsxs)("div",{className:"flex flex-col items-center h-full",children:[(0,h.jsxs)("div",{className:"flex justify-between w-[57.25rem] h-[3.5rem] px-4 py-1 bg-white",children:[(0,h.jsxs)("div",{className:"flex items-center w-[46.25rem] ",children:[(0,h.jsx)("img",{className:"w-10 h-10 rounded-full mr-4",src:null===y||void 0===y?void 0:y.groupAvatar}),(0,h.jsx)("div",{className:"flex flex-col justify-between",children:(0,h.jsx)("div",{children:null===y||void 0===y?void 0:y.groupName})})]}),(0,h.jsxs)("div",{className:"flex items-center ",children:[(0,h.jsx)("img",{className:"w-10 h-10 cursor-pointer",src:u.Z}),(0,h.jsx)("img",{className:"w-10 h-10 cursor-pointer",src:f.Z}),(0,h.jsx)("img",{className:"w-10 h-10 cursor-pointer",src:m.Z})]})]}),(0,h.jsxs)("div",{className:" relative w-[43.375rem] h-[41.5rem] bg-transparent",children:[(0,h.jsx)("div",{className:"flex flex-col justify-end h-[36.5rem] pb-4 overflow-auto",children:M.map((function(e,s){return(0,h.jsx)("div",{className:"flex  w-full mb-4 ".concat(e.msgUsername===localStorage.getItem("username")?"justify-end ":"justify-start"),children:(0,h.jsxs)("div",{className:"flex flex-col max-w-[25.125rem] px-3 py-1 rounded-xl ".concat(e.msgUsername===localStorage.getItem("username")?"bg-[#78E378]":"bg-white"),children:[(0,h.jsx)("div",{children:e.msgUsername}),(0,h.jsx)("div",{children:e.content}),(0,h.jsx)("div",{className:"flex justify-end mt-1 text-xs",children:o()(e.sendTime).format("YYYY.MM.DD hh.mm")})]})},s)}))}),(0,h.jsxs)("div",{className:"absolute bottom-6 w-full h-14 ",onKeyDown:function(e){"Enter"===e.code&&k()},children:[(0,h.jsx)("img",{className:"absolute left-4 top-4 cursor-pointer",src:d.Z}),(0,h.jsx)("input",{className:"w-full h-full px-14 py-[1.125rem] rounded-xl bg-white outline-none",type:"text",value:j,onChange:Z}),(0,h.jsx)("img",{className:"absolute right-4 top-4 cursor-pointer",src:g.Z,onClick:function(){k()}})]})]})]})};s.default=(0,r.memo)(p)}}]);
//# sourceMappingURL=309.0c388170.chunk.js.map