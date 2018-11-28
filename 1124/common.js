function my$(id){
	return document.getElementById(id);
}

//变速变化
function animate(element,target){
				//>0 向上取整   <0 向下取整
				clearInterval(element.timeId);
				
				element.timeId=setInterval(function(){
					var current=element.offsetLeft;
					var step=(target>current)?(Math.ceil((target-current)/10)):Math.floor((target-current)/10);
					
					current+=step;
				
					element.style.left=current+"px";
					if(current==target){
						clearInterval(element.timeId);
					}
				},20);
			}