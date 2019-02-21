package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.Organization;

import java.util.List;
import java.util.Map;

/**
 * 终端地域 服务层
 * 
 * @author 张超
 * @date 2019-01-17
 */
public interface IOrganizationService
{
	/**
     * 查询终端地域信息
     * 
     * @param aid 终端地域ID
     * @return 终端地域信息
     */
	public Organization selectOrganizationById(String aid);

	/**
	 * 查询终端地区树
	 *
	 * @param organization 部门信息
	 * @return 所有部门信息
	 */
	public List<Map<String, Object>> selectOrganizationTree(Organization organization);


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
     * 删除终端地域信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrganizationByIds(String ids);
	
}
