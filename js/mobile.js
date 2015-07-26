var browser={ 
    versions:function(){   
           var u = navigator.userAgent, app = navigator.appVersion;   
           return {//移动终端浏览器版本信息   
                trident: u.indexOf('Trident') > -1, //IE内核  
                presto: u.indexOf('Presto') > -1, //opera内核  
                webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核  
                gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核  
                mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端  
                ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端  
                android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器  
                iPhone: u.indexOf('iPhone') > -1 , //是否为iPhone或者QQHD浏览器  
                iPad: u.indexOf('iPad') > -1, //是否iPad    
                webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部  
            };  
         }()
}   
  
if( browser.versions.android || browser.versions.iPhone){   //判断移动端浏览器 
	$(".note-content-list ul li").click(function(event){   //点击显示内容
		$(".note-content").hide();
		$(".note-detail").fadeIn();
	});

	$(".note-detail-closeBtn").bind("touchend", function(event){   //触摸关闭内容
		$(".note-detail").hide();
		$(".note-detail").animate({scrollTop: "0"},"fast");
		$(".note-content").fadeIn();
	}); 

  //滑动的角度
  function GetSlideAngle(dx, dy) {
      return Math.atan2(dy, dx) * 180 / Math.PI;
  }
 
  //根据起点和终点返回方向 1：向上，2：向下，3：向左，4：向右, 0：未滑动
  function GetSlideDirection(startX, startY, endX, endY) {
      var dy = startY - endY;
      var dx = endX - startX;
      var result = 0;
 
      //如果滑动距离太短
      if(Math.abs(dx) < 50 && Math.abs(dy) < 50) {
                  return result;
      }
 
      var angle = GetSlideAngle(dx, dy);
      if(angle >= -45 && angle < 45) {
                  result = 4;
      }else if (angle >= 45 && angle < 135) {
                  result = 1;
      }else if (angle >= -135 && angle < -45) {
                  result = 2;
      }
      else if ((angle >= 135 && angle <= 180) || (angle >= -180 && angle < -135)) {
          result = 3;
      }
 
      return result;
  }
 
  //滑动的初始位置
  var startX, startY;
  document.addEventListener("touchstart",function (event) {
      startX = event.touches[0].pageX;
      startY = event.touches[0].pageY;  
  }, false);

  $(".note-category-showBtn").bind("touchend", function(event){   //触摸显示侧边栏
    var ulHeight=$(".note-category").height()-$(".note-cat-top").outerHeight()-
                 $(".note-cat-bottom").outerHeight();
    $(".note-cat-list").css("height", ulHeight);   //计算列表高度，决定列表是否显示滚动条
		$("#hover-content").removeClass("dis-none");
    $(".note-category").fadeIn();
    $('body').css('overflow', 'hidden'); //显示侧边栏时禁止后面内容滚动 
	});

  //向左滑动隐藏侧边栏
	document.addEventListener("touchend",function (event) {
      var endX, endY;
      endX = event.changedTouches[0].pageX;
      endY = event.changedTouches[0].pageY;
      var direction = GetSlideDirection(startX, startY, endX, endY);
      if(direction==3){
        $("#hover-content").addClass("dis-none");
				$(".note-category").fadeOut();
        $('body').css('overflow', 'auto');
      }
  }, false);  
}      
