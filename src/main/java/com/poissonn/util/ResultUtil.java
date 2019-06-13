package com.poissonn.util;

import com.poissonn.constance.ResultCode;

public class ResultUtil {

    public ResultUtil() {
    }

    public static ResultInfo getSuccessResult(Object data){
        ResultInfo rel = new ResultInfo();
        rel.setCode(ResultCode.SUCCESS.getCode());
        rel.setMessage(ResultCode.SUCCESS.getMessage());
        rel.setData(data);
        return rel;
    }
}
