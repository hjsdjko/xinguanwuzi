package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 物资捐赠
 *
 * @author 
 * @email
 */
@TableName("wuzi_juanzeng")
public class WuziJuanzengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuziJuanzengEntity() {

	}

	public WuziJuanzengEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 捐赠编号
     */
    @ColumnInfo(comment="捐赠编号",type="varchar(200)")
    @TableField(value = "wuzi_juanzeng_uuid_number")

    private String wuziJuanzengUuidNumber;


    /**
     * 物资
     */
    @ColumnInfo(comment="物资",type="int(11)")
    @TableField(value = "wuzi_id")

    private Integer wuziId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 捐赠缘由
     */
    @ColumnInfo(comment="捐赠缘由",type="longtext")
    @TableField(value = "wuzi_juanzeng_text")

    private String wuziJuanzengText;


    /**
     * 捐赠数量
     */
    @ColumnInfo(comment="捐赠数量",type="int(11)")
    @TableField(value = "wuzi_juanzeng_number")

    private Integer wuziJuanzengNumber;


    /**
     * 物资捐赠时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="物资捐赠时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 捐赠状态
     */
    @ColumnInfo(comment="捐赠状态",type="int(11)")
    @TableField(value = "wuzi_juanzeng_yesno_types")

    private Integer wuziJuanzengYesnoTypes;


    /**
     * 捐赠回复
     */
    @ColumnInfo(comment="捐赠回复",type="longtext")
    @TableField(value = "wuzi_juanzeng_yesno_text")

    private String wuziJuanzengYesnoText;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="回复时间",type="timestamp")
    @TableField(value = "wuzi_juanzeng_shenhe_time")

    private Date wuziJuanzengShenheTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WuziJuanzeng{" +
            ", id=" + id +
            ", wuziJuanzengUuidNumber=" + wuziJuanzengUuidNumber +
            ", wuziId=" + wuziId +
            ", yonghuId=" + yonghuId +
            ", wuziJuanzengText=" + wuziJuanzengText +
            ", wuziJuanzengNumber=" + wuziJuanzengNumber +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", wuziJuanzengYesnoTypes=" + wuziJuanzengYesnoTypes +
            ", wuziJuanzengYesnoText=" + wuziJuanzengYesnoText +
            ", wuziJuanzengShenheTime=" + DateUtil.convertString(wuziJuanzengShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
