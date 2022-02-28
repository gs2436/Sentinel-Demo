package demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private T data;

    private String message;

    private Integer code;

    /**
     * 必须要有
     */
    public Result() {

    }

    public Result(T data, Integer code) {
        this.data = data;
        this.code = code;
    }



}
