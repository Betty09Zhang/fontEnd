(function(){
				function Game(map){
					this.map=map;
					this.food=new Food();
					this.snake=new snake();
					that=this;
				}
				
				Game.prototype.runInit=function(map,food){
					//蛇向右移动 定时器定时
					var timeId=setInterval(function(){
					
					//先清除所有   在初始化
					this.snake.move(food,map);
					this.snake.init(map);
					
					
					//蛇碰到周围墙壁game over!
					var headX=this.snake.body[0].x;
					var headY=this.snake.body[0].y;
					if( headX>=parseInt(map.offsetWidth/this.snake.width) || headX<0 ){
		
					    clearInterval(timeId);
						alert("游戏结束！");
						}
					
					if( headY>=parseInt(map.offsetHeight/this.snake.height) || headY<0){
						clearInterval(timeId);
						alert("游戏结束！");
						}
					}.bind(that),150);
				}
				//获取键盘按下键：
				Game.prototype.keydown=function(){
					document.addEventListener("keydown",function(e){
						switch(e.keyCode){
							case 37:this.snake.direction="left"; break;
							case 38:this.snake.direction="top";break;
          					case 39:this.snake.direction="right";break;
          					case 40:this.snake.direction="bottom";break;
						}
					}.bind(that),false);
				}
				
				//游戏初始化：
				Game.prototype.init=function(map){
					this.food.init(this.map);
					this.snake.init(this.map);
					this.runInit(this.map,this.food);
					this.keydown();
				}
				
				window.Game=Game;
				
			}());
			