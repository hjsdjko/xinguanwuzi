package com.entity.vo;

import com.entity.WuziFafangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资发放
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzi_fafang")
public class WuziFafangVO implements Serializable {
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
     * 物资发放编号
     */

    @TableField(value = "wuzi_fafang_uuid_number")
    private String wuziFafangUuidNumber;


    /**
     * 发放数量
     */

    @TableField(value = "wuzi_fafang_number")
    private Integer wuziFafangNumber;


    /**
     * 发放时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "ruku_time")
    private Date rukuTime;


    /**
     * 发放位置
     */

    @TableField(value = "wuzi_fafang_address")
    private String wuziFafangAddress;


    /**
     * 发放缘由
     */

    @TableField(value = "wuzi_fafang_content")
    private String wuziFafangContent;


    /**
     * 备注
     */

    @TableField(value = "wuzi_fafang_beizhu_content")
    private String wuziFafangBeizhuContent;


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
	 * 设置：物资发放编号
	 */
    public String getWuziFafangUuidNumber() {
        return wuziFafangUuidNumber;
    }


    /**
	 * 获取：物资发放编号
	 */

    public void setWuziFafangUuidNumber(String wuziFafangUuidNumber) {
        this.wuziFafangUuidNumber = wuziFafangUuidNumber;
    }
    /**
	 * 设置：发放数量
	 */
    public Integer getWuziFafangNumber() {
        return wuziFafangNumber;
    }


    /**
	 * 获取：发放数量
	 */

    public void setWuziFafangNumber(Integer wuziFafangNumber) {
        this.wuziFafangNumber = wuziFafangNumber;
    }
    /**
	 * 设置：发放时间
	 */
    public Date getRukuTime() {
        return rukuTime;
    }


    /**
	 * 获取：发放时间
	 */

    public void setRukuTime(Date rukuTime) {
        this.rukuTime = rukuTime;
    }
    /**
	 * 设置：发放位置
	 */
    public String getWuziFafangAddress() {
        return wuziFafangAddress;
    }


    /**
	 * 获取：发放位置
	 */

    public void setWuziFafangAddress(String wuziFafangAddress) {
        this.wuziFafangAddress = wuziFafangAddress;
    }
    /**
	 * 设置：发放缘由
	 */
    public String getWuziFafangContent() {
        return wuziFafangContent;
    }


    /**
	 * 获取：发放缘由
	 */

    public void setWuziFafangContent(String wuziFafangContent) {
        this.wuziFafangContent = wuziFafangContent;
    }
    /**
	 * 设置：备注
	 */
    public String getWuziFafangBeizhuContent() {
        return wuziFafangBeizhuContent;
    }


    /**
	 * 获取：备注
	 */

    public void setWuziFafangBeizhuContent(String wuziFafangBeizhuContent) {
        this.wuziFafangBeizhuContent = wuziFafangBeizhuContent;
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
