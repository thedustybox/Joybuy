package com.thedustybox.joybuy.member.dao;

import com.thedustybox.joybuy.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zhengshenhao
 * @email zhengshenhao@gmail.com
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
