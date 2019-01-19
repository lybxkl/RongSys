package com.ruoyi.broad.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 广播用户表 broaduser
 * 
 * @author 张超
 * @date 2019-01-18
 */
public class Broaduser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 广播用户编号 */
	private String userid;
	/** 广播用户姓名 */
	private String uname;
	/** 广播用户身份等级 */
	private String userlevel;
	/** 广播用户手机号码 */
	private String uphone;
	/** 广播用户地址 */
	private String uaddress;
	/** 账号状态 */
	private String isuse;
	/** 用户最后登录时间 */
	private String lastdate;
	/** 管理区域 */
	private String aname;

	public void setUserid(String userid) 
	{
		this.userid = userid;
	}

	public String getUserid() 
	{
		return userid;
	}
	public void setUname(String uname) 
	{
		this.uname = uname;
	}

	public String getUname() 
	{
		return uname;
	}
	public void setUserlevel(String userlevel) 
	{
		this.userlevel = userlevel;
	}

	public String getUserlevel() 
	{
		return userlevel;
	}
	public void setUphone(String uphone) 
	{
		this.uphone = uphone;
	}

	public String getUphone() 
	{
		return uphone;
	}
	public void setUaddress(String uaddress) 
	{
		this.uaddress = uaddress;
	}

	public String getUaddress() 
	{
		return uaddress;
	}
	public void setIsuse(String isuse) 
	{
		this.isuse = isuse;
	}

	public String getIsuse() 
	{
		return isuse;
	}
	public void setLastdate(String lastdate) 
	{
		this.lastdate = lastdate;
	}

	public String getLastdate() 
	{
		return lastdate;
	}
	public void setAname(String aname) 
	{
		this.aname = aname;
	}

	public String getAname() 
	{
		return aname;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userid", getUserid())
            .append("uname", getUname())
            .append("userlevel", getUserlevel())
            .append("uphone", getUphone())
            .append("uaddress", getUaddress())
            .append("isuse", getIsuse())
            .append("lastdate", getLastdate())
            .append("aname", getAname())
            .toString();
    }
}
