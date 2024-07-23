package com.thedustybox.joybuy.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author zhengshenhao
 * @email zhengshenhao@gmail.com
 * @date 2024-06-09 19:54:45
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

