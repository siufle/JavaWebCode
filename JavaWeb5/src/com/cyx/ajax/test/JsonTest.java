package com.cyx.ajax.test;

import com.alibaba.fastjson.JSONObject;
import com.cyx.ajax.pojo.Agent;

public class JsonTest {
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setAid( 1);
        agent.setAno("ano1");
        agent.setAname("代理商1" );
        agent.setAregion("北京");
        System.out.println(agent.toJson());
        //将一个对象转换为json格式的字符串
        System.out.println(JSONObject.toJSON(agent));
    }
}
