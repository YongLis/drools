/**
 * 系统公共，js。理论上只存放公共业务代码。
 */
$(function () {
  //全局ajax设置
  $.ajaxSetup({
    statusCode: {
      401: function () {
        $.messager.alert("权限提醒", "您没有权限访问此资源！");
      },
      402: function () {
        $.messager.alert("登录提醒", "登录超时，请重新登录！", 'info', function () {
          //location.replace("/login");
          window.top.location.replace("/login");
        });
      }
    }
  });

  // 绑定菜单事件
  $(".crm-menu").on('click', 'li', function () {
//    if (!$(this).hasClass('selected')) {
      // 获取center对应的panel对象
	  this.dataset.text = this.innerHTML;
      // 刷新center区域
//      center.panel("refresh", this.dataset.url);
      addEasyuiTab({ id: getRandomNumByDef(),title : this.innerHTML, href : this.dataset.url, closable : true});
      // 选中状态
      $(this).siblings('.selected').toggleClass().end().addClass('selected');
//    }
  });

    $('#index_tabs').tabs({ onContextMenu : function(e, title, index) {
            e.preventDefault();
            $('#mm').menu('show', { left : e.pageX, top : e.pageY }).data("tabTitle", title);
        } });

    $('#mm').menu({ onClick : function(item) {
            closeTab(item.name);
        } });

    function closeTab(type) {
        $('#index_tabs').tabs(type);
    }

  //查看和修改用户信息
  $("#public_change_info").on('click', function () {
    var form;
    var dialog = $("<div/>", {class: 'noflow'}).dialog({
      title: "我的资料",
      iconCls: 'fa fa-user',
      height: 320,
      width: 420,
      href: '/change/info',
      modal: true,
      onClose: function () {
        $(this).dialog("destroy");
      },
      onLoad: function () {
        //窗口表单加载成功时执行
        form = $("#public_change_info_form", this);
      },
      buttons: [{
        iconCls: 'fa fa-save',
        text: '保存',
        handler: function () {
          if (form.form('validate')) {
            $.post("/change/info", form.serialize(), function (res) {
              if (res.success) {
                dialog.dialog('close');
                location.replace('/');
              } else {
                $.messager.alert("系统提示", res.message);
              }
            })
          }
        }
      }]
    });

    /**
     * 上传头像
     */
    dialog.on('click', '#avatar-file', function () {
      //清除上一轮已经选择的文件
      this.value = "";
    }).on('change', '#avatar-file', function () {
      //上传头像，h5的搞法
      var formData = new FormData();
      formData.append('file', this.files.item(0));
      formData.append('type', "AVATAR");
      $.ajax("/attachment/upload", {
        type: 'post',
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        complete: function (res) {
          var result = res.responseJSON;
          if (result.success) {
            $(".avatar-set", dialog).attr('src', result.data.filePath);
            $("#member-avatar", dialog).val(result.data.filePath);
          } else {
            $.messager.alert("系统提示", result.message);
          }
        }
      })
    });
  });

  //修改密码
  $("#public_change_password").on('click', function () {
    var form;
    var dialog = $("<div/>", {class: 'noflow'}).dialog({
      title: "修改密码",
      iconCls: 'fa fa-lock',
      height: 220,
      width: 420,
      href: '/change/password',
      modal: true,
      onClose: function () {
        $(this).dialog("destroy");
      },
      onLoad: function () {
        //窗口表单加载成功时执行
        form = $("#public_change_password_form", this);
      },
      buttons: [{
        iconCls: 'fa fa-repeat',
        text: '确认修改',
        handler: function () {
          if (form.form('validate')) {
            $.post("/change/password", form.serialize(), function (res) {
              if (res.success) {
                dialog.dialog('close');
                location.replace('/logout');
              } else {
                $.messager.alert("系统提示", res.message);
              }
            })
          }
        }
      }]
    });
  });


//获取一个json格式的表单值
function formToJson(formObj, ignoreNull){
    //默认剔除空值
    if (typeof ignoreNull === 'undefined') {
        ignoreNull = true
    }
    if (formObj.length <= 1) {
        return formBuildJson(formObj[0], ignoreNull);
    } else {
        //多表单的情况
        var forms = {};
        formObj.forEach(function (form, index) {
            var fName = $(form).attr('name');
            var key = fName ? fName : 'form' + index;
            forms[key] = formBuildJson(form, ignoreNull);
        });
        return forms;
    }
}

function formBuildJson(form, ignoreNull) {
    var formData = new FormData(form);
    var json = {};
    formData.forEach(function (val, key) {
        if (!val && ignoreNull) {
            return
        }
        if (json[key]) {
            if (!$.isArray(json[key])) {
                json[key] = [json[key]]
            }
            json[key].push(val);
        } else {
            json[key] = val;
        }
    });
    return json;
}

/**
 * 页面Ajax请求结果处理
 * @param result
 * @returns
 */
function ajaxResult(result){
	var map = result;
	if(typeof(result)=="object" ){
		map = result;
	}else{
		map = $.parseJSON(result);
	}
	var msg = map.message;
	if(map.isError){
		msg = "<div style='font-size:16px'><img src='/static/easyui/themes/icons/cancel.png' height='16' width='16'/>  <span>"+(msg ? msg :'操作失败！')+" </span></div>";
	}else{
		msg = "<div style='font-size:16px'><img src='/static/easyui/themes/icons/ok.png' height='16' width='16'/> <span>"+(msg ? msg :'操作成功！')+"</span></div>";
	}
	if(msg != ""){
		layerMsg(msg);
	}
}
/**
 * 页面Ajax请求结果处理
 * @param jsonResult
 * @returns
 */
function ajaxJsonResult(jsonResult){
    var msg = jsonResult.message;
    if(jsonResult.isError){
        msg = "<div style='font-size:16px'><img src='/static/easyui/themes/icons/cancel.png' height='16' width='16'/>  <span>"+(msg ? msg :'操作失败！')+" </span></div>";
    }else{
        msg = "<div style='font-size:16px'><img src='/static/easyui/themes/icons/ok.png' height='16' width='16'/> <span>"+(msg ? msg :'操作成功！')+"</span></div>";
    }
    if(msg != ""){
        layerMsg(msg);
    }
}
/**
 * 浏览器居中显示弹出信息
 * @param message
 * @returns
 */
function layerMsg(message){
	layer.msg(message);
}
/**
 * 浏览器右下角弹出信息框
 * @param message
 * @returns
 */
function showMsg(message){
	  $.messager.show({
        title: "<div style='font-size:14px'>系统提示</div>",
        msg: message ,
        showType: 'slide',      //设置显示类型
        width:200,                           //设置弹框的宽度和高度
        height:120,
        timeout: 5000      //设置停留时间，1000毫秒
    });
}

/**
 * 格式化日期， 默认为yyyy/MM/dd hh:mm:ss
 *
 * @param date
 *            待格式化的日期
 * @param format
 *            日期格式
 * @return 格式化不成功返回undefined
 */
function formatDate(date, format) {
    if (typeof date == "string" && date.trim() == "") {
        return undefined;
    }
    var d = new Date(date);
    // console.log(d);
    if (format) {
        return d.formatDate(format);
    } else {
        return d.formatDate("yyyy/MM/dd hh:mm:ss");
    }
};

function formatTime(date) {
    var year = date.getFullYear();
    var month = date.getMonth()+1, month = month < 10 ? '0' + month : month;
    var day = date.getDate(), day =day < 10 ? '0' + day : day;
    return year + '-' + month + '-' + day;
}

function addDate(date,days){
    var d=new Date(date);
    d.setDate(d.getDate()+days);
    return d;
}
/**
 * 扩展Date，增加格式化日期方法
 *
 * @param format
 * @returns
 */
Date.prototype.formatDate = function(format) {
    var o = { "M+" : this.getMonth() + 1, // month
        "d+" : this.getDate(), // day
        "h+" : this.getHours(), // hour
        "m+" : this.getMinutes(), // minute
        "s+" : this.getSeconds(), // second
        "q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
        "S" : this.getMilliseconds()
        // millisecond
    };
    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for ( var k in o)
        if (new RegExp("(" + k + ")").test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
};

var tabIndex = 1;
function addEasyuiTab(opts,refreshIfExists) {
    var workspace = $('#index_tabs');
    var title = opts.title;
    if(opts.newTab){
        title = title + tabIndex;
        tabIndex++;
    }
    opts.title = title;
    addNewEasyuiTab(opts, refreshIfExists);
}
function addNewEasyuiTab(opts,refreshIfExists) {
    var workspace = $('#index_tabs');
    var title = opts.title;

    if ($(workspace).tabs('exists', title)) {
        if (refreshIfExists) {
            //刷新tabs
            var refresh_tab = title ? $(workspace).tabs('getTab',title) : $(workspace).tabs('getSelected');
            if(refresh_tab && refresh_tab.find('iframe').length > 0){
                var _refresh_ifram = refresh_tab.find('iframe')[0];
                var refresh_url = opts.href?opts.href:_refresh_ifram.src;
                _refresh_ifram.contentWindow.location.href=refresh_url;
            }
        }
        $(workspace).tabs('select', title);
    } else {
        //新增tabs
        var content;
        var queryParams = "";
        if(opts.queryParams){
            $.each(opts.queryParams, function(key, val) {
                queryParams = queryParams + key + "=" + val + "&";
            });
        }
        queryParams = queryParams+"random=" + getRandomNumByDef();

        if (opts.href){
            content = '<iframe scrolling="no" frameborder="0"  src="'+opts.href+'?'+ queryParams +'" style="width:100%;height:100%;"></iframe>';
        } else {
            content = '未实现';
        }
        $(workspace).tabs('add',{
            id:opts.id,
            title:title,
            closable:opts.closable,
            content:content,
            selected:opts.selected
        });
    }
}

/**
 * 关闭Easyui标签页，如果title参数为undefined，关闭当前页
 *
 * @param title
 *            要关闭标签的标题
 */
function closeEasyuiTab(title) {
    var workspace = $('#index_tabs');
    if (title) {
        $(workspace).tabs('close', title);
    } else {
        var tab = $(workspace).tabs('getSelected');
        var index = $(workspace).tabs('getTabIndex', tab);
        $(workspace).tabs('close', index);
    }
}


/**
 * 生成随机数字
 * @returns
 */
function getRandomNumByDef(){
	  return getRandomNum(1e5,999999);
}
function getRandomNum(a,b){
	  switch(arguments.length){
	  	case 1:return parseInt(Math.random()*a+1);
	  	case 2:return parseInt(Math.random()*(b-a+1)+a);
	  	default:return 0}
}

/**
 * 获取商户名称列表
 * @returns
 */
function getMerchants(){
    var array = new Array();
    $.ajax({
        url: '/dictionary/merchants',
        method: 'POST',
        dataType: 'json',
        async : false,
        success: function (data) {
            for(var i=0; i<data.length; i++){
                var object = data[i];
                var merchants = new Object();
                merchants.name = object.name;
                merchants.merchantId = object.merchantId;
                array = add2Array(array, merchants);
            }
        }
    });
     return array
}
function add2Array(array, object) {
    //var array = new Array();
  //  console.log("add object="+JSON.stringify(object)+", array={}"+JSON.stringify(array))
    if(array.length == 0){
        array.push(object)
    }
    else{
        var isContained = false;
        for(var i=0; i<array.length; i++){
            var tmp = array[i];
            if(tmp.name == object.name){
                var newMerchantId = tmp.merchantId+","+object.merchantId;
                tmp.merchantId = newMerchantId;
                array[i] = tmp;
                isContained = true;
            }
        }
        if(!isContained) {
            array.push(object);
        }
    }
    return array;
}

function getPageId() {
    var pageId = 0;
    $.ajax({
        url: '/warn/getPageId',
        method: 'GET',
        dataType: 'json',
        async:false,
        success: function (data) {
            pageId = data;
        }
    });
    return pageId;
}
