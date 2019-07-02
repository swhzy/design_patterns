package com.swh.design.delegate.simple;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IExecuter{
    public Map<String,IExecuter> executerMap = new HashMap<>();

    public Leader() {
        executerMap.put("注册",new ExecuterA());
        executerMap.put("登录",new ExecuterB());

    }

    @Override
    public void executer(String com) {
        executerMap.get(com).executer(com);
    }
}
