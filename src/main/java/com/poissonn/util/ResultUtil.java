package com.poissonn.util;

import com.poissonn.constance.ResultCode;

public class ResultUtil {

    public ResultUtil() {
    }

    //返回表格数据成功模板
    public static ResultInfo getSuccessResult(Object data,int count){
        ResultInfo rel = new ResultInfo();
        rel.setCode(ResultCode.SUCCESS.getCode());
        rel.setMsg(ResultCode.SUCCESS.getMessage());
        rel.setCount(count);
        rel.setData(data);
        return rel;
    }

    public static ResultInfo getFailureResult(){
        ResultInfo rel = new ResultInfo();
        rel.setCode(ResultCode.FAILURE.getCode());
        rel.setMsg(ResultCode.FAILURE.getMessage());
        rel.setCount(0);
        rel.setData(null);
        return rel;
    }

    public static ResultInfo getFailureResult1(Object obj,int code,String msg,int count){
        ResultInfo rel = new ResultInfo();
        rel.setCode(code);
        rel.setMsg(msg);
        rel.setCount(count);
        rel.setData(obj);
        return rel;
    }

    public static ResultInfo getFailureResult3(String msg){
        ResultInfo rel = new ResultInfo();
        rel.setCode(ResultCode.FAILURE.getCode());
        rel.setMsg(msg);
        rel.setCount(0);
        rel.setData(null);
        return rel;
    }


}
