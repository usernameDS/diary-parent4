package com.kmu.manager.util;

/**
 * 网络传输的实体类，将来，传输数据，使用这个类来进行传输
 * 包含我们传输时，所用到的信息
 * @作者：boge 时间：2020/7/19 14:41
 */
public class ResultEntity<T> {
    //final:常量
    public static  final String  CODE_SUCCESS = "SUCCESS";
    public static  final String  CODE_FAILED = "FAILED";

    //设定状态码，前端可以根据状态码，判断成功、失败的响应
    private String code;

    //回显的消息
    private String msg;

    //回显的数据
    T data;
    public static  ResultEntity successWithData(Object data){
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_SUCCESS;
        objectResultEntity.setData(data);
        return objectResultEntity;
    }
    public static ResultEntity failedWithData(Object data){
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_FAILED;
        objectResultEntity.setData(data);
        return objectResultEntity;
    }
    public static  ResultEntity successWithData(String msg,Object data){
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_SUCCESS;
        objectResultEntity.setMsg(msg);
        objectResultEntity.setData(data);
        return objectResultEntity;
    }
    public static ResultEntity failedWithData(String msg,Object data){
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_FAILED;
        objectResultEntity.setMsg(msg);
        objectResultEntity.setData(data);
        return objectResultEntity;
    }

    //要么是成功，要么是失败
    public static ResultEntity success(){
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_SUCCESS;
        return objectResultEntity;
    }
   public static ResultEntity failed(){
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_SUCCESS;
        return objectResultEntity;
    }

    public ResultEntity(String code,String msg,T data){
        this.code = code;
        this.msg= msg;
        this.data=data;
    }

    public ResultEntity(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
