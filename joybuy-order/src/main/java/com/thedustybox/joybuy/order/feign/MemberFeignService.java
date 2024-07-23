package com.thedustybox.joybuy.order.feign;

import com.thedustybox.joybuy.common.utils.R;
import com.thedustybox.joybuy.order.vo.MemberAddressVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author thedustybox
 * @email thedustybox@qq.com
 */
@FeignClient("gulimall-member")
public interface MemberFeignService {

    /**
     * 查询当前用户的全部收货地址
     * @param memberId
     * @return
     */
    @GetMapping(value = "/member/memberreceiveaddress/{memberId}/address")
    List<MemberAddressVo> getAddress(@PathVariable("memberId") Long memberId);


    @RequestMapping("/member/memberreceiveaddress/test1")
    R test1();

}
