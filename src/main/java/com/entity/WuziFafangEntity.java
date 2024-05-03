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
 * 物资发放
 *
 * @author 
 * @email
 */
@TableName("wuzi_fafang")
public class WuziFafangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuziFafangEntity() {

	}

	public WuziFafangEntity(T t) {
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
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 物资
     */
    @ColumnInfo(comment="物资",type="int(11)")
    @TableField(value = "wuzi_id")

    private Integer wuziId;


    /**
     * 物资发放编号
     */
    @ColumnInfo(comment="物资发放编号",type="varchar(200)")
    @TableField(value = "wuzi_fafang_uuid_number")

    private String wuziFafangUuidNumber;


    /**
     * 发放数量
     */
    @ColumnInfo(comment="发放数量",type="int(11)")
    @TableField(value = "wuzi_fafang_number")

    private Integer wuziFafangNumber;


    /**
     * 发放时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发放时间",type="timestamp")
    @TableField(value = "ruku_time")

    private Date rukuTime;


    /**
     * 发放位置
     */
    @ColumnInfo(comment="发放位置",type="varchar(200)")
    @TableField(value = "wuzi_fafang_address")

    private String wuziFafangAddress;


    /**
     * 发放缘由
     */
    @ColumnInfo(comment="发放缘由",type="longtext")
    @TableField(value = "wuzi_fafang_content")

    private String wuziFafangContent;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "wuzi_fafang_beizhu_content")

    private String wuziFafangBeizhuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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

    @Override
    public String toString() {
        return "WuziFafang{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", wuziId=" + wuziId +
            ", wuziFafangUuidNumber=" + wuziFafangUuidNumber +
            ", wuziFafangNumber=" + wuziFafangNumber +
            ", rukuTime=" + DateUtil.convertString(rukuTime,"yyyy-MM-dd") +
            ", wuziFafangAddress=" + wuziFafangAddress +
            ", wuziFafangContent=" + wuziFafangContent +
            ", wuziFafangBeizhuContent=" + wuziFafangBeizhuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
