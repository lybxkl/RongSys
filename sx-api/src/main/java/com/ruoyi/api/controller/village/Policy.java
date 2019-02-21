package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.broad.domain.Managementgps;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.Policyinfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.village.service.IPolicyinfoService;

import java.util.List;

/**
 * 村务模块中公告功能的接口
 *
 * @author 张超
*/
@RestController
@RequestMapping("/api/policy")
@CrossOrigin
@Api(value = "村务模块 - 公告功能API类")
public class Policy extends BaseController {

    @Autowired
    private IPolicyinfoService policyinfoService;


    /**
        * 返回最近的十条政策公告
        * @author 张超 teavamc
        * @date 2019/1/25
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @GetMapping("/ten")
    @CrossOrigin
    @ApiOperation(value = "返回最近的十条政策公告")
    public RongApiRes searchten()
    {
        return RongApiService.get_list(policyinfoService.selectpoliclimitten());
    }

}
