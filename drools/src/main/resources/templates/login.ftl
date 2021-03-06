<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
  <meta  charset="UTF-8" />
  <title>XX后台管理系统</title>
  <base id="base" href="${base}">
  <link rel="stylesheet" href="${base}/static/css/login.css" />
  <link rel="stylesheet" href="${base}/static/font-awesome/css/font-awesome.min.css" />
</head>
<body>
<div class="logo_box">
  <h1>XX后台管理系统</h1>
  <form action="login" method="post" autocomplete="off">
    <div class="input_outer">
      <i class="fa fa-user-o u_user"></i>
      <input required="required" name="userName" class="text" placeholder="输入账号" type="text" />
    </div>
    <div class="input_outer">
      <i class="fa fa-eye u_user"></i>
      <input required="required" placeholder="请输入密码" name="password" class="text" type="password" />
    </div>
    <div class="mb2">
      <button class="act-but submit" style="color: #FFFFFF">登录</button>
    </div>
  <#if error??>
    <div style="text-align:center;padding: 10px;">${error}</div>
  </#if>

  </form>
</div>
</body>
</html>
