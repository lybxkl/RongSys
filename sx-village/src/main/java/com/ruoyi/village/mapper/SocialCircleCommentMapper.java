package com.ruoyi.village.mapper;

import com.ruoyi.village.domain.SocialCircleComment;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 暮云圈 评论 数据
 * @author: Mr.Liu
 * @create: 2019-01-18 09:32
 **/

public interface SocialCircleCommentMapper {

    /**
     * 根据暮云圈pcid 搜索所有评论
     * @param pcid
     * @return
     */
    List<SocialCircleComment> selectAllByPcid(Integer pcid);
}
