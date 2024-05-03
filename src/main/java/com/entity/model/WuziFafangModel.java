package com.entity.model;

import com.entity.WuziFafangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资发放
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuziFafangModel implements Serializable {
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
     * 物资发放编号
     */
    private String wuziFafangUuidNumber;


    /**
     * 发放数量
     */
    private Integer wuziFafangNumber;


    /**
     * 发放时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date rukuTime;


    /**
     * 发放位置
     */
    private String wuziFafangAddress;


    /**
     * 发放缘由
     */
    private String wuziFafangContent;


    /**
     * 备注
     */
    private String wuziFafangBeizhuContent;


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
	 * 获取：物资发放编号
	 */
    public String getWuziFafangUuidNumber() {
        return wuziFafangUuidNumber;
    }


    /**
	 * 设置：物资发放编号
	 */
    public void setWuziFafangUuidNumber(String wuziFafangUuidNumber) {
        this.wuziFafangUuidNumber = wuziFafangUuidNumber;
    }
    /**
	 * 获取：发放数量
	 */
    public Integer getWuziFafangNumber() {
        return wuziFafangNumber;
    }


    /**
	 * 设置：发放数量
	 */
    public void setWuziFafangNumber(Integer wuziFafangNumber) {
        this.wuziFafangNumber = wuziFafangNumber;
    }
    /**
	 * 获取：发放时间
	 */
    public Date getRukuTime() {
        return rukuTime;
    }


    /**
	 * 设置：发放时间
	 */
    public void setRukuTime(Date rukuTime) {
        this.rukuTime = rukuTime;
    }
    /**
	 * 获取：发放位置
	 */
    public String getWuziFafangAddress() {
        return wuziFafangAddress;
    }


    /**
	 * 设置：发放位置
	 */
    public void setWuziFafangAddress(String wuziFafangAddress) {
        this.wuziFafangAddress = wuziFafangAddress;
    }
    /**
	 * 获取：发放缘由
	 */
    public String getWuziFafangContent() {
        return wuziFafangContent;
    }


    /**
	 * 设置：发放缘由
	 */
    public void setWuziFafangContent(String wuziFafangContent) {
        this.wuziFafangContent = wuziFafangContent;
    }
    /**
	 * 获取：备注
	 */
    public String getWuziFafangBeizhuContent() {
        return wuziFafangBeizhuContent;
    }


    /**
	 * 设置：备注
	 */
    public void setWuziFafangBeizhuContent(String wuziFafangBeizhuContent) {
        this.wuziFafangBeizhuContent = wuziFafangBeizhuContent;
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
