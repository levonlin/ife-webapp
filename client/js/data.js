/**
 * author boxizen
 * since  2015/07/26
 * desc   项目模型层
 */

/* 测试数据 catObj:目录测试数据，*/
var catObj = '[{"id":"cat1","name":"设计","count":234},{"id":"cat2","name":"体育锻炼","count":3},{"id":"cat3","name":"HTML5","count":29},{"id":"cat4","name":"语文","count":89},{"id":"cat5","name":"数学","count":89},{"id":"cat5","name":"英语","count":1}]';
var postObj = '[{"id":"p1","catId":"cat1","title":"图片排版与字体排版","detail":"如果两张图片风格、内容、色调相近，颜色的安排符合某种规律，那么观众的眼睛就会非常流畅地路过你的图片，走到下一个关注点那里，这叫做对齐；观众的关注点就会停留在..."},{"id":"p2","catId":"cat1","title":"图片排版与字体排版","detail":"如果两张图片风格、内容、色调相近，颜色的安排符合某种规律，那么观众的眼睛就会非常流畅地路过你的图片，走到下一个关注点那里，这叫做对齐；观众的关注点就会停留在..."}]';

/* 简略的模版渲染 */
studyTplEngine = function(obj, itemTpl, tag) {
  var catHtml = '';
  var regId = new RegExp("\\${data.id}", "g");
  if (tag == 1) {
    var regName = new RegExp("\\${data.name}", "g");
    var regNum = new RegExp("\\${data.num}", "g");

    for (var i = 0; i < obj.length; i++) {
      var idTpl = itemTpl.replace(regId, obj[i].id);
      var nameTpl = idTpl.replace(regName, obj[i].name);
      var html = nameTpl.replace(regNum, obj[i].count);
      catHtml += html;
    }
  } else {
    var regTitle = new RegExp("\\${data.title}", "g");
    var regDetail = new RegExp("\\${data.detail}", "g");

    for (var i = 0; i < obj.length; i++) {
      var idTpl = itemTpl.replace(regId, obj[i].id);
      var titleTpl = idTpl.replace(regTitle, obj[i].title);
      var html = titleTpl.replace(regDetail, obj[i].detail);
      catHtml += html;
    }
  }
  return catHtml;
}

if (window.localStorage) {

  //初始化用户
  if (localStorage.user != null) {
    
  }
  else {
    localStorage.user = "user";
  }

  // 初始化笔记分类
  if (localStorage.catList != null) {
    var catStr = localStorage.catList;
    var obj = JSON.parse(catStr);
    var itemTpl = $('#noteCatItemTmpl').html();
    var html = studyTplEngine(obj, itemTpl, 1);
    $('.note-cat-list ul').html(html);
  }
  else {
    localStorage.catList = catObj;
  }

  // 初始化文章
  if (localStorage.noteList != null) {
    var postStr = localStorage.postList;
    var obj = JSON.parse(postStr);
    var itemTpl = $('#noteListTmpl').html();
    var html = studyTplEngine(obj, itemTpl, 2);
    $('.note-content-list ul').html(html);
  }
  else {
    localStorage.postList = postObj;
  }

} else {
  alert('您的浏览器不支持本地存储');
}
