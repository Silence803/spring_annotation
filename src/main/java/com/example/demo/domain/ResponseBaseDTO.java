package com.example.demo.domain;

/**
 * Created by daniel.luo on 2018/5/21.
 */
public class ResponseBaseDTO {
    private String status;
    private Object data;
    private String desc;
    private boolean success;

    public String getStatus() {
        return status;
    }

    public ResponseBaseDTO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseBaseDTO setData(Object data) {
        this.data = data;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public ResponseBaseDTO setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResponseBaseDTO(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public ResponseBaseDTO(String status, String desc, Object data) {
        this.status = status;
        this.data = data;
        this.desc = desc;
    }

    public ResponseBaseDTO(String status, String desc, Object data, boolean success) {
        this.status = status;
        this.data = data;
        this.desc = desc;
        this.success = success;
    }

    public ResponseBaseDTO() {
        super();
    }

    public static ResponseBaseDTO New() {
        return new ResponseBaseDTO();
    }
}
