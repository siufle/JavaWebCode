function ajax(option) {
    let xmlHttpRequest;
    if (window.ActiveXObject) {//检测window中是否存在ActiveXObject对象
        xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        xmlHttpRequest = new XMLHttpRequest();
    }
    xmlHttpRequest.onreadystatechange = function () {
        if (xmlHttpRequest.readyState === 4) {//就绪状态为4时表示已经将服务器传输回来的信息读取完毕
            if (xmlHttpRequest.status >= 200 && xmlHttpRequest.status < 300) {//HTTP状态码为200的时候说明该请求处理完成
                let result = xmlHttpRequest.responseText;
                if(typeof option.success === 'function'){
                    option.success(result);//调用传递进来的函数
                }
            }else{
                if(typeof option.error === 'function'){
                    option.error(xmlHttpRequest.responseText);//调用传递进来的函数
                }
            }
        }
    }
    if(option.method.toLowerCase() === 'get'){
        let param = "?";
        let keys = Object.keys(option.data);//获取对象中所有属性名的集合
        keys.forEach(key => {
            param += key + "=" + option.data[key] + "&";
        })
        param = param.substring(0, param.length - 1);
        option.url += param;
    }
    xmlHttpRequest.open(option.method, option.url, true)
    //get请求发送数据是在url地址后面进行拼接
    if(option.contentType){//contentType不为null和undefined则设置请求头
        xmlHttpRequest.setRequestHeader("content-type",option.contentType)
    }
    let dataInfo = null;
    //post请求发送数据需要在方法中
    if(option.method.toLowerCase() === 'post'){
        dataInfo = option.data;
        if(option.contentType && option.contentType.indexOf("application/x-www-form-urlencoded") >= 0){
            let param = "";
            let keys = Object.keys(option.data);//获取对象中所有属性名的集合
            keys.forEach(key => {
                param += key + "=" + option.data[key] + "&";
            })
            param = param.substring(0, param.length - 1);
            dataInfo = param;
        }
    }
    xmlHttpRequest.send(dataInfo);
}