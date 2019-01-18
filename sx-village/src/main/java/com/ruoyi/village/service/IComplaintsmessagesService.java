package com.ruoyi.village.service;

import com.ruoyi.village.domain.Complaintsmessages;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 投诉咨询Service
 * @author: Mr.Liu
 * @create: 2019-01-14 15:37
 **/

public interface IComplaintsmessagesService {

    /**
     * 查询投诉咨询记录列表
     *
     * @return
     */
    public List<Complaintsmessages> selectComplaintsList(Complaintsmessages complaintmessages);

    /**
     * 根据fbid删除数据
     * @param fbid
     */
    public int deleteComplaintsByids(String fbid);

    /**
     * 添加投诉咨询数据
     * @param complaintsmessages
     * @return
     */
    public int insertcomplaintsmessages(Complaintsmessages complaintsmessages);
    /**
     * 根据fbid选择数据
     * @param fbid
     * @return
     */
    public Complaintsmessages selectByfbid(Integer fbid);
    /**
     * 保存用户修改
     * @param complaintsmessages
     * @return
     */
    public int updateComplaintsmessages(Complaintsmessages complaintsmessages);

}
