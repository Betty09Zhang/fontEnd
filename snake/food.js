(function(){
				
				//创建数组，存储食物
				var elements=[];
				function Food(width,height,x,y,color){
					//设置默认值。坐标宽高和颜色
					this.width=width||20;
					this.height=height||20;
					this.x=x||0;
					this.y=y||0;
					this.backgroundColor=color||"green";
				}
				//随机产生食物方法。蛇吃掉食物，食物将消失，将地图作为参数传入
				Food.prototype.init=function(map){
					
					remove();
					var div=document.createElement("div");
					
					div.style.width=this.width+"px";
					div.style.height=this.height+"px";
					div.style.position="absolute";
					div.style.backgroundColor=this.backgroundColor;
					this.x=parseInt(Math.random()*(map.offsetWidth)/(this.width));  //0~49
					this.y=parseInt(Math.random()*map.offsetHeight/this.height);
					
					div.style.top=this.y*this.width+"px";
					div.style.left=this.x*this.height+"px";
					
					
					map.appendChild(div);
					
					
					elements.push(div);
				}
				//食物消失函数，私有
				 function remove() {
			      //elements数组中有这个食物
			      for (var i = 0; i < elements.length; i++) {
			        var ele = elements[i];
			        //找到这个子元素的父级元素,然后删除这个子元素
			        ele.parentNode.removeChild(ele);
			        //再次把elements中的这个子元素也要删除
			        elements.splice(i, 1);
			      }
			    }
				
				window.Food=Food;
			}());
			