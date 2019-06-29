package com.poissonn.controller;

import com.poissonn.constance.ResultCode;
import com.poissonn.util.ResultInfo;
import com.poissonn.util.ResultUtil;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * 处理controller层的返回类型
 */
public class BaseController {

    public ResultInfo process(Supplier fun){
        try {
            Object obj = fun.get();
            if (obj instanceof ResultInfo){
                //处理ResultInfo返回类型的
                return (ResultInfo) obj;
            }else if (obj instanceof ArrayList){
                //处理ArrayList返回类型的
                return ResultUtil.getSuccessResult(obj,((ArrayList) obj).size());
            }
            //其他
            return ResultUtil.getSuccessResult(obj,0);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.getFailureResult3(e.getMessage());
        }
    }

}
