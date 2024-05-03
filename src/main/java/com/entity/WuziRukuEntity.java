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
 * 物资入库
 *
 * @author 
 * @email
 */
@TableName("wuzi_ruku")
public class WuziRukuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuziRukuEntity() {

	}

	public WuziRukuEntity(T t) {
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
     * 物资入库编号
     */
    @ColumnInfo(comment="物资入库编号",type="varchar(200)")
    @TableField(value = "wuzi_ruku_uuid_number")

    private String wuziRukuUuidNumber;


    /**
     * 入库数量
     */
    @ColumnInfo(comment="入库数量",type="int(11)")
    @TableField(value = "wuzi_ruku_number")

    private Integer wuziRukuNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="入库时间",type="timestamp")
    @TableField(value = "ruku_time")

    private Date rukuTime;


    /**
     * 入库备注
     */
    @ColumnInfo(comment="入库备注",type="longtext")
    @TableField(value = "wuzi_ruku_content")

    private String wuziRukuContent;


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

    @Override
    public String toString() {
        return "WuziRuku{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", wuziId=" + wuziId +
            ", wuziRukuUuidNumber=" + wuziRukuUuidNumber +
            ", wuziRukuNumber=" + wuziRukuNumber +
            ", rukuTime=" + DateUtil.convertString(rukuTime,"yyyy-MM-dd") +
            ", wuziRukuContent=" + wuziRukuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
