var maskWidth = $(window).width();
var maskHeight = $(window).height();
var maskHtml = "<div id='maskLoading' class='panel-body' style='background-color: #E0FFFF;opacity:0.4;filter:alpha(opacity=40); z-index:1000;position:absolute;left:0;width:100%;";
maskHtml += "height:" + maskHeight + "px;top:0'>";
maskHtml += "<div class='panel-header panel=loading' style='position:absolute;cursor:wait;left:" + ((maskWidth / 2) - 100) + "px;top:" + (maskHeight / 2 - 50) + "px;width:150px;height:16px;";
maskHtml += "padding:10px 5px 10px 30px;font-size:12px;border:1px solid #ccc;background-color:white;'>";
maskHtml += "页面加载中，请等待...";
maskHtml += "</div>";
maskHtml += "</div>";
window.onload = function(){
    var _mask = document.getElementById('maskLoading');
    _mask.parentNode.removeChild(_mask);
}
document.write(maskHtml);

function load() {
    $("<div class=\"datagrid-mask\"></div>").css({ display: "block", width: "100%", height: $(window).height() }).appendTo("body");
    $("<div class=\"datagrid-mask-msg\"></div>").html("<span style='display:block;margin-left:-10px;margin-top:-3px'>处理中，请稍候。。。</span>").appendTo("body").css({borderRadius:"23px ", display: "block", left: ($(document.body).outerWidth(true) - 190) / 2, top: ($(window).height() - 45) / 2 });
}

//取消加载层
function disLoad() {
    $(".datagrid-mask").remove();
    $(".datagrid-mask-msg").remove();
}