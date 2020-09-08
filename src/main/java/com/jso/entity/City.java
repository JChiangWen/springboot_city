package com.jso.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * (city)实体类
 *
 * @author jso
 * @since 2020-08-31 11:05:55
 * @description 由 Mybatisplus Code Generator 自动生成的代码
 */
@TableName("city")
public class City extends Model<City> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * pid
     */
    @TableId(type = IdType.AUTO)
	private Integer pid;
    /**
     * pname
     */
    private String pname;
    /**
     * fid
     */
    private Integer fid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

}