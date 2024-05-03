package com.entity.model;

import com.entity.WuziRukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资入库
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuziRukuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 物资
     */
    private Integer wuziId;


    /**
     * 物资入库编号
     */
    private String wuziRukuUuidNumber;


    /**
     * 入库数量
     */
    private Integer wuziRukuNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date rukuTime;


    /**
     * 入库备注
     */
    private String wuziRukuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：物资
	 */
    public Integer getWuziId() {
        return wuziId;
    }


    /**
	 * 设置：物资
	 */
    public void setWuziId(Integer wuziId) {
        this.wuziId = wuziId;
    }
    /**
	 * 获取：物资入库编号
	 */
    public String getWuziRukuUuidNumber() {
        return wuziRukuUuidNumber;
    }


    /**
	 * 设置：物资入库编号
	 */
    public void setWuziRukuUuidNumber(String wuziRukuUuidNumber) {
        this.wuziRukuUuidNumber = wuziRukuUuidNumber;
    }
    /**
	 * 获取：入库数量
	 */
    public Integer getWuziRukuNumber() {
        return wuziRukuNumber;
    }


    /**
	 * 设置：入库数量
	 */
    public void setWuziRukuNumber(Integer wuziRukuNumber) {
        this.wuziRukuNumber = wuziRukuNumber;
    }
    /**
	 * 获取：入库时间
	 */
    public Date getRukuTime() {
        return rukuTime;
    }


    /**
	 * 设置：入库时间
	 */
    public void setRukuTime(Date rukuTime) {
        this.rukuTime = rukuTime;
    }
    /**
	 * 获取：入库备注
	 */
    public String getWuziRukuContent() {
        return wuziRukuContent;
    }


    /**
	 * 设置：入库备注
	 */
    public void setWuziRukuContent(String wuziRukuContent) {
        this.wuziRukuContent = wuziRukuContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
