function my$(id){
	return document.getElementById(id);
}

//变速变化
function getStyle(ele,attr){
			return window.getComputedStyle?window.getComputedStyle(ele,null)[attr]:ele.currentStyle[attr];
			}

function animate(element,json,fn){
				
				//>0 向上取整   <0 向下取整
				clearInterval(element.timeId);
				
				element.timeId=setInterval(function(){
					var flag=true;
					for(var key in json){
						//转换为整数
						//透明度
					if(key=="opacity"){  //扩大100
						var current=getStyle(element,key);
						var target=json[key];
						current=current*100;
						//目标也要放大100倍
						target=target*100;
					//	console.log("current:"+current+"  target:  "+target);
						var step=(target>current)?(Math.ceil((target-current)/10)):Math.floor((target-current)/10);
					//	console.log("step"+step);
						current+=step;
						//console.log("current:"+current);
						element.style[key]=current/100;
						//console.log(getStyle(my$("dv"),"opacity"));
					}
					else if(key=="zIndex"){
						element.style[key]=json[key];
					}
					else{
						var target=json[key];
						var current=parseInt(getStyle(element,key));
						var step=(target>current)?(Math.ceil((target-current)/10)):Math.floor((target-current)/10);
					
						current+=step;
						//console.log("current:"+current+"KEY:"+key);
						element.style[key]=current+"px";
					}
						//所有属性当中只要有一个未达到目标值，flag就等于false;
						if(current!=target){
							flag=false;
						}
					}
					
					if(flag){
						clearInterval(element.timeId);
						if(fn){
							
							fn();
							console.log("finish");
						}
					}
					
				},20);
			}
	