/**
 * author boxizen
 * since  2015/07/26
 * desc   项目控制器
 */
$(function() {

  /* 开启/取消全屏效果 */
  var startFullScreen = function() {
    $('.note-detail').addClass('fullscreen');
    $(".note-detail-top").addClass('fullscreen');
    $('.note-category').addClass('fullscreen');
    $('.note-content').addClass('fullscreen');
  }
  var cancelFullScreen = function() {
    $('.note-detail').removeClass('fullscreen');
    $(".note-detail-top").removeClass('fullscreen');
    $('.note-category').removeClass('fullscreen');
    $('.note-content').removeClass('fullscreen');
  }

  /* 获取文章列表 */
  var getPostByCat = function(cid) {
    var postArr = new Array();
    var postList = JSON.parse(localStorage.postList);
    var index = 0;
    for(var i =0 ; i<postList.length; i++){
      var catId = postList[i].catId;
      if(catId == cid){
        postArr[index] = postList[i];
        index++;
      }
    }
    var itemTpl = $('#noteListTmpl').html();
    if(postArr.length == 0){
      $('.note-content-tips').removeClass('hidden');
    }
    else{
      $('.note-content-tips').addClass('hidden');
    }
    var html = studyTplEngine(postArr,itemTpl,2);
    $('.note-content-list ul').html(html);
  }
  
  /* 新建笔记按钮 */
  $('.note-content-addBtn a').bind({
    click: function() {

      return false;
    }
  });

  /* 分类列表 */
  $('.note-cat-list ul li a').bind({
    click: function() {
      $('.note-cat-list ul li a').removeClass('active');
      $(this).addClass('active');
      getPostByCat($(this).attr("data-id"));
      return false;
    }
  });

  /* 文章列表 */
  $('.note-content-list ul li a').bind({
    click: function() {
        $('.note-content-list ul li a').removeClass('active');
        $(this).addClass('active');
        return false;
    }
  });

  /* 关闭笔记按钮 */
  $('.note-detail-closeBtn a').bind({
    mouseenter: function() {
      $(this).addClass('spin');
      startFullScreen();
    },
    mouseleave: function() {
      $(this).removeClass('spin');
      cancelFullScreen();
    }
  });



});
