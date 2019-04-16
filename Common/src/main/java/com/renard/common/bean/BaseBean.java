package com.renard.common.bean;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
public class BaseBean<D> {

    @Override
    public String toString() {
        return "BaseBean{" +
                "data=" + data +
                ", type=" + type +
                ", code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }

    /**
     * code : 200
     * desc : 成功
     * data : null
     */

    private D data;

    private String extraInfo;

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    //        用于表示当前的请求所属
    private int type;

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    private int code=200;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
