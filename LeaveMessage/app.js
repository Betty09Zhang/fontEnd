var server=require('http').createServer();
var url=require('url');
var file=require('fs');
var rel=require('art-template');

var comments=[{
		name: '张曼',
		message: '加油加加油',
		dateTime: '1992-02225'

	},{
		name: '张曼',
		message: '加油加加油',
		dateTime: '1992-02225'
	},{
		name: '张曼',
		message: '加油加加油',
		dateTime: '1992-02225'
	}];

// 服务器接收请求
server.on('request',function(request,response){
	// 1、请求服务器，默认打开主界面view/index.html
	var objs=url.parse(request.url,true);
	var path=objs.pathname;
	console.log(path)
	//通过get 方法得到的属性值
	var obj=objs.query;

	

	if(path==='/'){
		// 服务器读取对应文档，输出到客户端
		file.readFile('./views/index.html',function(err,data){
			if(err){
				return console.log('读取文件失败');

			}

			// 使用模板引擎，将数据添加到html
			var result=rel.render(data.toString(),{
				comments: comments
			});
			//二进制数转换为字符串
			response.end(result);
		})
		
	}
	//请求以/public开头  访问公共资源
	else if(path.indexOf('/public/')===0){
		console.log(path);
		file.readFile('.'+ path,function(err,data){

			if(err){
				return console.log('读取文件失败');

			}
			response.end(data);
		})
	}
	else if(path==='/post'){
		console.log(path);
		file.readFile('./views/post.html',function(err,data){

			if(err){
				return console.log('读取文件失败');

			}
			response.end(data);
		})
	}
	else if(path==='/pinglun'){
		console.log(path);
		obj.dateTime=new Date();
		comments.unshift(obj);

		// 如果客户端发现收到服务器的响应的状态码是 302 就会自动去响应头中找 Location ，然后对该地址发起新的请求
		//通过重定向   重新渲染模板
		response.statusCode=302;
		response.setHeader('Location','/');
		response.end();
		
		
	}



});
	server.listen('3000',function(){
	  console.log('服务器打开')
	})
