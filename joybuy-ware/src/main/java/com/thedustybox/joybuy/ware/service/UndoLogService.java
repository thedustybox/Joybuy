package com.thedustybox.joybuy.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author zhengshenhao
 * @email zhengshenhao@gmail.com
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

