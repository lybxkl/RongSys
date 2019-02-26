package com.ruoyi.broad.mapper;

import com.ruoyi.broad.domain.Organization;
import java.util.List;

/**
 * 终端地域 数据层
 *
 * @author 张鸿权
 * @date 2019-02-17
 */
public interface OrganizationMapper
{
	/**
	 * 查询终端地域信息
	 *
	 * @param tid 终端地域ID
	 * @return 终端地域信息
	 */
	public Organization selectOrganizationById(String tid);

	/**
	 * 查询终端地域列表
	 *
	 * @param organization 终端地域信息
	 * @return 终端地域集合
	 */
	public List<Organization> selectOrganizationList(Organization organization);

	/**
	 * 新增终端地域
	 *
	 * @param organization 终端地域信息
	 * @return 结果
	 */
	public int insertOrganization(Organization organization);

	/**
	 * 修改终端地域
	 *
	 * @param organization 终端地域信息
	 * @return 结果
	 */
	public int updateOrganization(Organization organization);

	/**
	 * 删除终端地域
	 *
	 * @param tid 终端地域ID
	 * @return 结果
	 */
	public int deleteOrganizationById(String tid);

	/**
	 * 批量删除终端地域
	 *
	 * @param tids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteOrganizationByIds(String[] tids);

}