package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ForumEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 论坛
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 帖子类型的值
	*/
	@ColumnInfo(comment="帖子类型的字典表值",type="varchar(200)")
	private String forumValue;
	/**
	* 帖子状态的值
	*/
	@ColumnInfo(comment="帖子状态的字典表值",type="varchar(200)")
	private String forumStateValue;

	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
	//级联表 员工
		/**
		* 工号
		*/

		@ColumnInfo(comment="工号",type="varchar(200)")
		private String yuangongUuidNumber;
		/**
		* 员工姓名
		*/

		@ColumnInfo(comment="员工姓名",type="varchar(200)")
		private String yuangongName;
		/**
		* 员工手机号
		*/

		@ColumnInfo(comment="员工手机号",type="varchar(200)")
		private String yuangongPhone;
		/**
		* 员工身份证号
		*/

		@ColumnInfo(comment="员工身份证号",type="varchar(200)")
		private String yuangongIdNumber;
		/**
		* 员工头像
		*/

		@ColumnInfo(comment="员工头像",type="varchar(200)")
		private String yuangongPhoto;
		/**
		* 员工邮箱
		*/

		@ColumnInfo(comment="员工邮箱",type="varchar(200)")
		private String yuangongEmail;
	//级联表 管理员
		/**
		* 用户名
		*/
		@ColumnInfo(comment="用户名",type="varchar(100)")
		private String uusername;
		/**
		* 密码
		*/
		@ColumnInfo(comment="密码",type="varchar(100)")
		private String upassword;
		/**
		* 角色
		*/
		@ColumnInfo(comment="角色",type="varchar(100)")
		private String urole;
		/**
		* 新增时间
		*/
		@ColumnInfo(comment="新增时间",type="timestamp")
		private Date uaddtime;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer jinyongTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String jinyongValue;


	public ForumView() {

	}

	public ForumView(ForumEntity forumEntity) {
		try {
			BeanUtils.copyProperties(this, forumEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 帖子类型的值
	*/
	public String getForumValue() {
		return forumValue;
	}
	/**
	* 设置： 帖子类型的值
	*/
	public void setForumValue(String forumValue) {
		this.forumValue = forumValue;
	}
	//当前表的
	/**
	* 获取： 帖子状态的值
	*/
	public String getForumStateValue() {
		return forumStateValue;
	}
	/**
	* 设置： 帖子状态的值
	*/
	public void setForumStateValue(String forumStateValue) {
		this.forumStateValue = forumStateValue;
	}


	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
	//级联表的get和set 员工

		/**
		* 获取： 工号
		*/
		public String getYuangongUuidNumber() {
			return yuangongUuidNumber;
		}
		/**
		* 设置： 工号
		*/
		public void setYuangongUuidNumber(String yuangongUuidNumber) {
			this.yuangongUuidNumber = yuangongUuidNumber;
		}

		/**
		* 获取： 员工姓名
		*/
		public String getYuangongName() {
			return yuangongName;
		}
		/**
		* 设置： 员工姓名
		*/
		public void setYuangongName(String yuangongName) {
			this.yuangongName = yuangongName;
		}

		/**
		* 获取： 员工手机号
		*/
		public String getYuangongPhone() {
			return yuangongPhone;
		}
		/**
		* 设置： 员工手机号
		*/
		public void setYuangongPhone(String yuangongPhone) {
			this.yuangongPhone = yuangongPhone;
		}

		/**
		* 获取： 员工身份证号
		*/
		public String getYuangongIdNumber() {
			return yuangongIdNumber;
		}
		/**
		* 设置： 员工身份证号
		*/
		public void setYuangongIdNumber(String yuangongIdNumber) {
			this.yuangongIdNumber = yuangongIdNumber;
		}

		/**
		* 获取： 员工头像
		*/
		public String getYuangongPhoto() {
			return yuangongPhoto;
		}
		/**
		* 设置： 员工头像
		*/
		public void setYuangongPhoto(String yuangongPhoto) {
			this.yuangongPhoto = yuangongPhoto;
		}

		/**
		* 获取： 员工邮箱
		*/
		public String getYuangongEmail() {
			return yuangongEmail;
		}
		/**
		* 设置： 员工邮箱
		*/
		public void setYuangongEmail(String yuangongEmail) {
			this.yuangongEmail = yuangongEmail;
		}
	//级联表的get和set 管理员
		/**
		* 获取： 用户名
		*/
		public String getUusername() {
			return uusername;
		}
		/**
		* 设置： 用户名
		*/
		public void setUusername(String uusername) {
			this.uusername = uusername;
		}
		/**
		* 获取： 密码
		*/
		public String getUpassword() {
			return upassword;
		}
		/**
		* 设置： 密码
		*/
		public void setUpassword(String upassword) {
			this.upassword = upassword;
		}
		/**
		* 获取： 角色
		*/
		public String getUrole() {
			return urole;
		}
		/**
		* 设置： 角色
		*/
		public void setUrole(String urole) {
			this.urole = urole;
		}
		/**
		* 获取： 新增时间
		*/
		public Date getUaddtime() {
			return uaddtime;
		}
		/**
		* 设置： 新增时间
		*/
		public void setUaddtime(Date uaddtime) {
			this.uaddtime = uaddtime;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getJinyongTypes() {
			return jinyongTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
			}
				public String getJinyongValue() {
				return jinyongValue;
				}
				public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
				}

	@Override
	public String toString() {
		return "ForumView{" +
			", forumValue=" + forumValue +
			", forumStateValue=" + forumStateValue +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yuangongUuidNumber=" + yuangongUuidNumber +
			", yuangongName=" + yuangongName +
			", yuangongPhone=" + yuangongPhone +
			", yuangongIdNumber=" + yuangongIdNumber +
			", yuangongPhoto=" + yuangongPhoto +
			", yuangongEmail=" + yuangongEmail +
			"} " + super.toString();
	}
}
