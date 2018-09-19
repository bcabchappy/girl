package com.imooc.demo.exception;

import com.imooc.demo.enums.ResultEnum;

public class GirlException extends RuntimeException {

    //spring对RuntimeException抛出异常才会进行事务回滚，Exception异常不会回滚

    private Integer code;

    public GirlException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
