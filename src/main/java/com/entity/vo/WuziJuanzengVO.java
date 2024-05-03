package com.entity.vo;

import com.entity.WuziJuanzengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资捐赠
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzi_juanzeng")
public class WuziJuanzengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 捐赠编号
     */

    @TableField(value = "wuzi_juanzeng_uuid_number")
    private String wuziJuanzengUuidNumber;


    /**
     * 物资
     */

    @TableField(value = "wuzi_id")
    private Integer wuziId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 捐赠缘由
     */

    @TableField(value = "wuzi_juanzeng_text")
    private String wuziJuanzengText;


    /**
     * 捐赠数量
     */

    @TableField(value = "wuzi_juanzeng_number")
    private Integer wuziJuanzengNumber;


    /**
     * 物资捐赠时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 捐赠状态
     */

    @TableField(value = "wuzi_juanzeng_yesno_types")
    private Integer wuziJuanzengYesnoTypes;


    /**
     * 捐赠回复
     */

    @TableField(value = "wuzi_juanzeng_yesno_text")
    private String wuziJuanzengYesnoText;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "wuzi_juanzeng_shenhe_time")
    private Date wuziJuanzengShenheTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：捐赠编号
	 */
    public String getWuziJuanzengUuidNumber() {
        return wuziJuanzengUuidNumber;
    }


    /**
	 * 获取：捐赠编号
	 */

    public void setWuziJuanzengUuidNumber(String wuziJuanzengUuidNumber) {
        this.wuziJuanzengUuidNumber = wuziJuanzengUuidNumber;
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：捐赠缘由
	 */
    public String getWuziJuanzengText() {
        return wuziJuanzengText;
    }


    /**
	 * 获取：捐赠缘由
	 */

    public void setWuziJuanzengText(String wuziJuanzengText) {
        this.wuziJuanzengText = wuziJuanzengText;
    }
    /**
	 * 设置：捐赠数量
	 */
    public Integer getWuziJuanzengNumber() {
        return wuziJuanzengNumber;
    }


    /**
	 * 获取：捐赠数量
	 */

    public void setWuziJuanzengNumber(Integer wuziJuanzengNumber) {
        this.wuziJuanzengNumber = wuziJuanzengNumber;
    }
    /**
	 * 设置：物资捐赠时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：物资捐赠时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：捐赠状态
	 */
    public Integer getWuziJuanzengYesnoTypes() {
        return wuziJuanzengYesnoTypes;
    }


    /**
	 * 获取：捐赠状态
	 */

    public void setWuziJuanzengYesnoTypes(Integer wuziJuanzengYesnoTypes) {
        this.wuziJuanzengYesnoTypes = wuziJuanzengYesnoTypes;
    }
    /**
	 * 设置：捐赠回复
	 */
    public String getWuziJuanzengYesnoText() {
        return wuziJuanzengYesnoText;
    }


    /**
	 * 获取：捐赠回复
	 */

    public void setWuziJuanzengYesnoText(String wuziJuanzengYesnoText) {
        this.wuziJuanzengYesnoText = wuziJuanzengYesnoText;
    }
    /**
	 * 设置：回复时间
	 */
    public Date getWuziJuanzengShenheTime() {
        return wuziJuanzengShenheTime;
    }


    /**
	 * 获取：回复时间
	 */

    public void setWuziJuanzengShenheTime(Date wuziJuanzengShenheTime) {
        this.wuziJuanzengShenheTime = wuziJuanzengShenheTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
