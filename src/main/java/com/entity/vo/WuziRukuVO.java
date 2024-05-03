package com.entity.vo;

import com.entity.WuziRukuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资入库
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzi_ruku")
public class WuziRukuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 物资
     */

    @TableField(value = "wuzi_id")
    private Integer wuziId;


    /**
     * 物资入库编号
     */

    @TableField(value = "wuzi_ruku_uuid_number")
    private String wuziRukuUuidNumber;


    /**
     * 入库数量
     */

    @TableField(value = "wuzi_ruku_number")
    private Integer wuziRukuNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "ruku_time")
    private Date rukuTime;


    /**
     * 入库备注
     */

    @TableField(value = "wuzi_ruku_content")
    private String wuziRukuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：物资
	 */
    public Integer getWuziId() {
        return wuziId;
    }


    /**
	 * 获取：物资
	 */

    public void setWuziId(Integer wuziId) {
        this.wuziId = wuziId;
    }
    /**
	 * 设置：物资入库编号
	 */
    public String getWuziRukuUuidNumber() {
        return wuziRukuUuidNumber;
    }


    /**
	 * 获取：物资入库编号
	 */

    public void setWuziRukuUuidNumber(String wuziRukuUuidNumber) {
        this.wuziRukuUuidNumber = wuziRukuUuidNumber;
    }
    /**
	 * 设置：入库数量
	 */
    public Integer getWuziRukuNumber() {
        return wuziRukuNumber;
    }


    /**
	 * 获取：入库数量
	 */

    public void setWuziRukuNumber(Integer wuziRukuNumber) {
        this.wuziRukuNumber = wuziRukuNumber;
    }
    /**
	 * 设置：入库时间
	 */
    public Date getRukuTime() {
        return rukuTime;
    }


    /**
	 * 获取：入库时间
	 */

    public void setRukuTime(Date rukuTime) {
        this.rukuTime = rukuTime;
    }
    /**
	 * 设置：入库备注
	 */
    public String getWuziRukuContent() {
        return wuziRukuContent;
    }


    /**
	 * 获取：入库备注
	 */

    public void setWuziRukuContent(String wuziRukuContent) {
        this.wuziRukuContent = wuziRukuContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
