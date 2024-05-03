package com.entity.model;

import com.entity.WuziJuanzengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资捐赠
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuziJuanzengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 捐赠编号
     */
    private String wuziJuanzengUuidNumber;


    /**
     * 物资
     */
    private Integer wuziId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 捐赠缘由
     */
    private String wuziJuanzengText;


    /**
     * 捐赠数量
     */
    private Integer wuziJuanzengNumber;


    /**
     * 物资捐赠时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 捐赠状态
     */
    private Integer wuziJuanzengYesnoTypes;


    /**
     * 捐赠回复
     */
    private String wuziJuanzengYesnoText;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date wuziJuanzengShenheTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：捐赠编号
	 */
    public String getWuziJuanzengUuidNumber() {
        return wuziJuanzengUuidNumber;
    }


    /**
	 * 设置：捐赠编号
	 */
    public void setWuziJuanzengUuidNumber(String wuziJuanzengUuidNumber) {
        this.wuziJuanzengUuidNumber = wuziJuanzengUuidNumber;
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：捐赠缘由
	 */
    public String getWuziJuanzengText() {
        return wuziJuanzengText;
    }


    /**
	 * 设置：捐赠缘由
	 */
    public void setWuziJuanzengText(String wuziJuanzengText) {
        this.wuziJuanzengText = wuziJuanzengText;
    }
    /**
	 * 获取：捐赠数量
	 */
    public Integer getWuziJuanzengNumber() {
        return wuziJuanzengNumber;
    }


    /**
	 * 设置：捐赠数量
	 */
    public void setWuziJuanzengNumber(Integer wuziJuanzengNumber) {
        this.wuziJuanzengNumber = wuziJuanzengNumber;
    }
    /**
	 * 获取：物资捐赠时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：物资捐赠时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：捐赠状态
	 */
    public Integer getWuziJuanzengYesnoTypes() {
        return wuziJuanzengYesnoTypes;
    }


    /**
	 * 设置：捐赠状态
	 */
    public void setWuziJuanzengYesnoTypes(Integer wuziJuanzengYesnoTypes) {
        this.wuziJuanzengYesnoTypes = wuziJuanzengYesnoTypes;
    }
    /**
	 * 获取：捐赠回复
	 */
    public String getWuziJuanzengYesnoText() {
        return wuziJuanzengYesnoText;
    }


    /**
	 * 设置：捐赠回复
	 */
    public void setWuziJuanzengYesnoText(String wuziJuanzengYesnoText) {
        this.wuziJuanzengYesnoText = wuziJuanzengYesnoText;
    }
    /**
	 * 获取：回复时间
	 */
    public Date getWuziJuanzengShenheTime() {
        return wuziJuanzengShenheTime;
    }


    /**
	 * 设置：回复时间
	 */
    public void setWuziJuanzengShenheTime(Date wuziJuanzengShenheTime) {
        this.wuziJuanzengShenheTime = wuziJuanzengShenheTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
