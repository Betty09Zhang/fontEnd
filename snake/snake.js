(function(){
				var elements=[];
				function Snake(width,height,direction){
					this.width=width || 20;
					this.height=height||20;
					this.direction=direction || "right";
					
					//是一个数组，存放身体；
					this.body=[
						{x:3,y:3,color:"red"},
						{x:2,y:3,color:"yellow"},
						{x:1,y:3,color:"yellow"}
					];
					
						
				}
				Snake.prototype.init=function(map){
					remove();
					//初始化身体部分
//					var arr=new Array(2,3,4);
//					for(var i in arr){
//						console.log(arr[i]);
//					}
					for(var i=0;i<=this.body.length-1;i++){
//						console.log(this.body[i]);
						var div=document.createElement("div");
						map.appendChild(div);
						div.style.top=this.body[i].y*this.height+"px";
						div.style.left=this.body[i].x*this.width+"px";
						div.style.width=this.width+"px";
						div.style.height=this.height+"px";
						div.style.backgroundColor=this.body[i].color;
						div.style.position="absolute";
						elements.push(div);
					}
				}
				//蛇移动方法：移动同时 body坐标会改变  改变头部坐标 ,前一个div给后一个div
				Snake.prototype.move=function(food,map){
					i=this.body.length-1;
					for(;i>0;i--){
						this.body[i].x=this.body[i-1].x;
						this.body[i].y=this.body[i-1].y;
					}
					switch(this.direction){
						//
						case "right":
							this.body[0].x=this.body[0].x+1;
							console.log(this.body[0].color);
							break;
							
						case "left":
							
							this.body[0].x=this.body[0].x-1;
							break;
						case "top":
							this.body[0].y=this.body[0].y-1;
							break;
						case "bottom":
							this.body[0].y=this.body[0].y+1;
							break;
						
						
					}
					//在移动的过程中，蛇头碰到食物，即坐标相同时，在body最后一个元素后面追加一个相同的div
					var headX=this.body[0].x;
					var headY=this.body[0].y;
					console.log("food.x:"+food.x+"  food.y:"+food.y);
					console.log("headx:"+headX+"  heady:"+headY);
					if(food.x==headX&&food.y==headY){
						console.log(food.x==food.y);
						
						var last=this.body[this.body.length-1];
						this.body.push({
							x:last.x,
							y:last.y,
							color:last.color
						});
						
						//初始化食物；
						food.init(map);
						
					}
				}
				
				function remove(){
					var i=elements.length-1;
					for(;i>=0;i--){
						var par=elements[i].parentNode;
						par.removeChild(elements[i]);
						elements.splice(i,1);
					}
				}
				
				
				window.snake=Snake;
				
			}());
			