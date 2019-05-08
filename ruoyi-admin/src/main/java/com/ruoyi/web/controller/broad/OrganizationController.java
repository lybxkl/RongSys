package com.ruoyi.web.controller.broad;

import java.util.List;
import java.util.Map;

import com.ruoyi.broad.domain.Area;
import com.ruoyi.broad.service.IAreaService;
import com.ruoyi.common.support.Convert;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.broad.domain.Organization;
import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 终端信息操作处理
 *
 * @author 张鸿权
 * @date 2019-02-17
 */
@Controller
@RequestMapping("/broad/organization")
public class OrganizationController extends BaseController
{
	private String prefix = "broad/organization";

	@Autowired
	private IOrganizationService organizationService;
	@Autowired
	private IAreaService areaService;
	@Autowired
	private ISysUserService sysUserService;
	@RequiresPermissions("broad:organization:view")
	@GetMapping()
	public String organization()
	{
		return prefix + "/organization";
	}

	/**
	 * 查询终端信息列表
	 */
	@RequiresPermissions("broad:organization:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Organization organization)
	{
		SysUser currentUser = ShiroUtils.getSysUser();//从session中获取当前登陆用户的userid
		Long userid =  currentUser.getUserId();
		int returnId = new Long(userid).intValue();
		int roleid = sysUserService.selectRoleid(returnId);//通过所获取的userid去广播用户表中查询用户所属区域的Roleid
		if(organization.getAid() == null && (roleid == 1)) {
			startPage() ;
			List<Organization> list = organizationService.selectOrganizationList(organization);
			return getDataTable(list);
		}else if(organization.getAid() != null){
			startPage() ;
			List<Organization> list = organizationService.selectOrganizationList(organization);
			return getDataTable(list);
		}else{
			String aid;
			aid = sysUserService.selectAid(returnId);//通过所获取的userid去广播用户表中查询用户所属区域的Aid
			organization.setAid(aid);
			startPage() ;
			List<Organization> list = organizationService.selectOrganizationList(organization);
			return getDataTable(list);
		}

	}


	/**
	 * 导出终端信息列表
	 */
	@RequiresPermissions("broad:organization:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Organization organization)
	{
		List<Organization> list = organizationService.selectOrganizationList(organization);
		ExcelUtil<Organization> util = new ExcelUtil<Organization>(Organization.class);
		return util.exportExcel(list, "organization");
	}

	/**
	 * 新增终端信息
	 */
	@GetMapping("/add")
	public String add()
	{
		return prefix + "/add";
	}

	/**
	 * 新增保存终端信息
	 */
	@RequiresPermissions("broad:organization:add")
	@Log(title = "终端信息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Organization organization)
	{
		SysUser currentUser = ShiroUtils.getSysUser();//从session中获取当前登陆用户的userid
		Long userid =  currentUser.getUserId();
		organization.setUserid(String.valueOf(userid));
		SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
		Date date = new Date();// 获取当前时间
		organization.setCreatedtime(sdf.format(date));
		organizationService.insertOrganizationPic(organization);
		return toAjax(organizationService.insertOrganization(organization));
	}

	/**
	 * 修改终端信息
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") String tid, ModelMap mmap)
	{
		Organization organization = organizationService.selectOrganizationById(tid);
		mmap.put("organization", organization);
		return prefix + "/edit";
	}

	/**
	 * 修改保存终端信息
	 */
	@RequiresPermissions("broad:organization:edit")
	@Log(title = "终端信息", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Organization organization)
	{
		return toAjax(organizationService.updateOrganization(organization));
	}

	/**
	 * 删除终端信息
	 */
	@RequiresPermissions("broad:organization:remove")
	@Log(title = "终端信息", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(organizationService.deleteOrganizationByIds(ids));
	}

	/**
	 * 选择部门树
	 */
	@GetMapping("/selectOrganizationTree/{aid}")
	public String selectOrganizationTree(@PathVariable("aid") String aid, ModelMap mmap)
	{
		mmap.put("organization", areaService.selectAreaById(aid));
		/*return prefix + "/tree";*/
		return prefix + "/listProBroadTree";
	}

	/**
	 * 加载节目单播出终端选择列表树
	 */
	@GetMapping("/listProBroadTree")
	@ResponseBody
	public List<Map<String, Object>> listProBroadTree()
	{
		List<Map<String, Object>> tree = areaService.selectAreaTree(new Area());
		return tree;
	}

	/**
	 * 查询节目单终端列表
	 */
	@PostMapping("/listProBroad")
	@ResponseBody
	public TableDataInfo listProBroad(Organization organization)
	{
		startPage() ;
		List<Organization> list = organizationService.selectProBroadList(organization);
		return getDataTable(list);
	}


	/**
	 * 加载部门列表树
	 */
	@GetMapping("/treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData()
	{
		SysUser currentUser = ShiroUtils.getSysUser();//从session中获取当前登陆用户的userid
		Long userid =  currentUser.getUserId();
		int returnId = new Long(userid).intValue();
		int roleid = sysUserService.selectRoleid(returnId);//通过所获取的userid去广播用户表中查询用户所属区域的Roleid
		if(roleid == 1) {
			List<Map<String, Object>> tree = areaService.selectAreaTree(new Area());
			return tree;
		}else {
			String aid;
			aid = sysUserService.selectAid(returnId);//通过所获取的userid去广播用户表中查询用户所属区域的Aid
			Area update_area = new Area() ;
			update_area.setAid(aid);
			List<Map<String, Object>> tree = areaService.selectAreaTree(update_area);
			return tree;
		}
	}

	/**
	 * 选择区域树
	 */
	@GetMapping("/selectAidTree")
	public String selectAidTree()
	{
		return prefix + "/aidTree";
	}

    /**
     * 设置终端的RDS码
     */
    @PostMapping( "/rdsSet")
    @ResponseBody
    public AjaxResult rdsSetUrl(String ids, String number)
    {
        return toAjax(organizationService.updateRdsByIds(ids,number));
    }

    /**
     * 设置终端的fmfrequency码
     */
    @PostMapping( "/fmfrequencySet")
    @ResponseBody
    public AjaxResult fmfrequencySet(String ids, String number)
    {
        return toAjax(organizationService.updateFmfrequencyByIds(ids,number));
    }

	@PostMapping( "/isuseSet")
	@ResponseBody
	public AjaxResult isuseSet(String tid, Boolean isuse)
	{
		return toAjax(organizationService.updateIsuseByTid(tid,isuse));
	}
}
