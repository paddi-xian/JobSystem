window.onload = function(){
    //获取u_name的span标签
    var u_nameErrorSpan = document.getElementById("u_nameError");
    //给用户名绑定blur事件
    var u_nameElt = document.getElementById("u_name");
    u_nameElt.onblur = function(){
        //获取用户名
        var u_name = u_nameElt.value;
        //去除前后空白
        u_name = u_name.trim();
        if(u_name === ""){
            //用户名为空
            u_nameErrorSpan.innerText = "用户名不能为空";
        }else{
            //用户名不为空
            //继续判断长度[6-14]
            if(u_name.length < 2 || u_name.length > 10){
                //用户名长度非法
                u_nameErrorSpan.innerText = "用户名长度必须在[2-10]之间";
            }else{
                //用户名长度合法
                //继续判断是否含有特殊符号
                var regExp = /^[\u4e00-\u9fa5a-zA-Z0-9]+$/;
                var ok = regExp.test(u_name);
                if(ok){
                    //用户名最终合法
                }else{
                    //用户名含有特殊符号
                    u_nameErrorSpan.innerText = "用户名只能由汉字或数字或字母组成";
                }
            }
        }
    }
    //给u_name这个文本框绑定获得焦点事件
    u_nameElt.onfocus = function(){
        //清空非法的value
        if(u_nameErrorSpan.innerText != ""){
            u_nameElt.value = "";
        }
        //清空span
        u_nameErrorSpan.innerText = "";
    }

    //获取密码错误提示的span标签
    var u_passErrorSpan = document.getElementById("u_passError");
    //获取确认密码对象
    var u_pass2Elt = document.getElementById("u_pass2");
    //绑定blur事件
    u_pass2Elt.onblur = function(){
        //获取密码和确认密码
        var u_passElt = document.getElementById("u_pass");
        var u_pass = u_passElt.value;
        var u_pass2 = u_pass2Elt.value;
        if(u_pass != u_pass2){
            //密码不一致
            u_passErrorSpan.innerText = "密码不一致";
        }else{
            //密码一致
            //u_passErrorSpan.innerText = "密码一致";
        }
    }
    //绑定focus事件
    u_pass2Elt.onfocus = function(){
        if(u_passErrorSpan.innerText != ""){
            u_pass2Elt.value = "";
        }
        u_passErrorSpan.innerText = "";
    }

    //获取telephone的span
    var telephoneSpan = document.getElementById("telephoneError");
    //给telephone绑定blur事件
    var telephoneElt = document.getElementById("telephone");
    telephoneElt.onblur = function(){
        //获取telephone
        var telephone = telephoneElt.value;
        //编写telephone的正则
        var telephoneRegEXp = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
        var ok = telephoneRegEXp.test(telephone);
        if(ok){
            //手机号合法
        }else{
            //不合法
            telephoneSpan.innerText="手机号不合法";
        }
    }
    //给telephoneElt绑定focus
    telephoneElt.onfocus = function(){
        if(telephoneSpan.innerText != ""){
            telephoneElt.value = "";
        }
        telephoneSpan.innerText = "";
    }


    //给提交按钮绑定鼠标单击事件
    var submitBtnElt = document.getElementById("btn");
    btn.onclick = function(){
        //不需要人工操作，使用纯JS代码触发事件
        u_nameElt.focus();
        u_nameElt.blur();

        u_pass2Elt.focus();
        u_pass2Elt.blur();

        telephoneElt.focus();
        telephoneElt.blur();
    }
}

