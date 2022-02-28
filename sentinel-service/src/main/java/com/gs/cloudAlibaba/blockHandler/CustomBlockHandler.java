package com.gs.cloudAlibaba.blockHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import demo.entity.Result;

public class CustomBlockHandler {

    //static不能少
    public static Result<String> handleException(int id, String name, BlockException exception) {
        Result<String> result = new Result<String>("直接熔断", 500);
        return result;
    }


}
