!function(){"use strict";var e,n={},t={};function r(e){var a=t[e];if(void 0!==a)return a.exports;var c=t[e]={id:e,loaded:!1,exports:{}};return n[e].call(c.exports,c,c.exports,r),c.loaded=!0,c.exports}r.m=n,e=[],r.O=function(n,t,a,c){if(!t){var o=1/0;for(d=0;d<e.length;d++){t=e[d][0],a=e[d][1],c=e[d][2];for(var u=!0,i=0;i<t.length;i++)(!1&c||o>=c)&&Object.keys(r.O).every(function(e){return r.O[e](t[i])})?t.splice(i--,1):(u=!1,c<o&&(o=c));if(u){e.splice(d--,1);var f=a();void 0!==f&&(n=f)}}return n}c=c||0;for(var d=e.length;d>0&&e[d-1][2]>c;d--)e[d]=e[d-1];e[d]=[t,a,c]},r.n=function(e){var n=e&&e.__esModule?function(){return e.default}:function(){return e};return r.d(n,{a:n}),n},r.d=function(e,n){for(var t in n)r.o(n,t)&&!r.o(e,t)&&Object.defineProperty(e,t,{enumerable:!0,get:n[t]})},r.f={},r.e=function(e){return Promise.all(Object.keys(r.f).reduce(function(n,t){return r.f[t](e,n),n},[]))},r.u=function(e){return(592===e?"common":e)+"-es5."+{57:"8fc1ef550c3f781cd88b",58:"066c90fe39538ee6c91a",126:"24556dba51d0bda26e74",215:"683c243524b649caa19d",292:"d9e8f23e57cd12daae20",298:"152003e7ba0bc8228639",322:"e8cc2ce699d96744e7d2",389:"9e2c3adc3fecafe7bb62",392:"effd07f5da8513352682",432:"a503c647ae2d6d9a0536",486:"3927bf182b31fd65f595",561:"a131808fa84e35cd7834",592:"6166b2ca22b78d8b9730",792:"06b4e8e4be48a898669b",820:"1f47bba9bd095878fa35",827:"51c4fce11eba0c8e156e",858:"ba0cd7b42426d3669807",877:"70450a6a65d5a140c6ca",887:"ecc31b7474ab33c10326",892:"d7c11d5b777fb546c289",907:"029506889d4c19c9e0ec",918:"4a87baa0804a64542ceb",929:"857071ed6cfea3a87b90",953:"8e31ed3830ec9c7f73b0"}[e]+".js"},r.miniCssF=function(e){return"styles.c17f1107be94b079b6e1.css"},r.o=function(e,n){return Object.prototype.hasOwnProperty.call(e,n)},function(){var e={},n="bs2-pj-banking-uis-web:";r.l=function(t,a,c,o){if(e[t])e[t].push(a);else{var u,i;if(void 0!==c)for(var f=document.getElementsByTagName("script"),d=0;d<f.length;d++){var b=f[d];if(b.getAttribute("src")==t||b.getAttribute("data-webpack")==n+c){u=b;break}}u||(i=!0,(u=document.createElement("script")).charset="utf-8",u.timeout=120,r.nc&&u.setAttribute("nonce",r.nc),u.setAttribute("data-webpack",n+c),u.src=r.tu(t)),e[t]=[a];var l=function(n,r){u.onerror=u.onload=null,clearTimeout(s);var a=e[t];if(delete e[t],u.parentNode&&u.parentNode.removeChild(u),a&&a.forEach(function(e){return e(r)}),n)return n(r)},s=setTimeout(l.bind(null,void 0,{type:"timeout",target:u}),12e4);u.onerror=l.bind(null,u.onerror),u.onload=l.bind(null,u.onload),i&&document.head.appendChild(u)}}}(),r.r=function(e){"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},r.nmd=function(e){return e.paths=[],e.children||(e.children=[]),e},function(){var e;r.tu=function(n){return void 0===e&&(e={createScriptURL:function(e){return e}},"undefined"!=typeof trustedTypes&&trustedTypes.createPolicy&&(e=trustedTypes.createPolicy("angular#bundler",e))),e.createScriptURL(n)}}(),r.p="",function(){var e={666:0};r.f.j=function(n,t){var a=r.o(e,n)?e[n]:void 0;if(0!==a)if(a)t.push(a[2]);else if(666!=n){var c=new Promise(function(t,r){a=e[n]=[t,r]});t.push(a[2]=c);var o=r.p+r.u(n),u=new Error;r.l(o,function(t){if(r.o(e,n)&&(0!==(a=e[n])&&(e[n]=void 0),a)){var c=t&&("load"===t.type?"missing":t.type),o=t&&t.target&&t.target.src;u.message="Loading chunk "+n+" failed.\n("+c+": "+o+")",u.name="ChunkLoadError",u.type=c,u.request=o,a[1](u)}},"chunk-"+n,n)}else e[n]=0},r.O.j=function(n){return 0===e[n]};var n=function(n,t){var a,c,o=t[0],u=t[1],i=t[2],f=0;for(a in u)r.o(u,a)&&(r.m[a]=u[a]);if(i)var d=i(r);for(n&&n(t);f<o.length;f++)r.o(e,c=o[f])&&e[c]&&e[c][0](),e[o[f]]=0;return r.O(d)},t=self.webpackChunkbs2_pj_banking_uis_web=self.webpackChunkbs2_pj_banking_uis_web||[];t.forEach(n.bind(null,0)),t.push=n.bind(null,t.push.bind(t))}()}();