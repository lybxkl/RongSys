package com.ruoyi.village.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 党员值班表 tb_partywork
 * 
 * @author 张鸿权
 * @date 2019-01-20
 */
public class Partywork extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 数据编号 */
	private Integer id;
	/** 党员小组 */
	private String grouptype;
	/** 党员姓名 */
	private String uname;
	/** 值班时间 */
	private String worktime;
	/** 值班地点 */
	private String address;
	/** 值班要求 */
	private String content;
	/** 排班人 */
	private String admin;
	/** 备注 */
	private String note;
	/** 添加时间 */
	private Date adddate;
	/** 地域编号 */
	private String aid;
	/** 是否有效 */
	private String remark;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setGrouptype(String grouptype) 
	{
		this.grouptype = grouptype;
	}

	public String getGrouptype() 
	{
		return grouptype;
	}
	public void setUname(String uname) 
	{
		this.uname = uname;
	}

	public String getUname() 
	{
		return uname;
	}
	public void setWorktime(String worktime) 
	{
		this.worktime = worktime;
	}

	public String getWorktime() 
	{
		return worktime;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setAdmin(String admin) 
	{
		this.admin = admin;
	}

	public String getAdmin() 
	{
		return admin;
	}
	public void setNote(String note) 
	{
		this.note = note;
	}

	public String getNote() 
	{
		return note;
	}
	public void setAdddate(Date adddate) 
	{
		this.adddate = adddate;
	}

	public Date getAdddate() 
	{
		return adddate;
	}
	public void setAid(String aid) 
	{
		this.aid = aid;
	}

	public String getAid() 
	{
		return aid;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("grouptype", getGrouptype())
            .append("uname", getUname())
            .append("worktime", getWorktime())
            .append("address", getAddress())
            .append("content", getContent())
            .append("admin", getAdmin())
            .append("note", getNote())
            .append("adddate", getAdddate())
            .append("aid", getAid())
            .append("remark", getRemark())
            .toString();
    }
}
