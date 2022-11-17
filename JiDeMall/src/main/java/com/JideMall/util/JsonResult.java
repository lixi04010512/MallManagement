package com.JideMall.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * json格式进行响应
 */
@Data

public class JsonResult<E> implements Serializable {
    private Integer state;
    private String msg;
    private E data;

    public JsonResult(Integer state){
        this.state=state;
    }
    public JsonResult(Throwable e){
        this.msg=e.getMessage();
    }
    public JsonResult(){
    }
    public JsonResult(Integer state,E data){
        this.state=state;
        this.data=data;
    }
}
