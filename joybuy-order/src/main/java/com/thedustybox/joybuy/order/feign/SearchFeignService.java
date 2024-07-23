package com.thedustybox.joybuy.order.feign;

import com.thedustybox.joybuy.common.to.es.SkuEsModel;
import com.thedustybox.joybuy.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@FeignClient("gulimall-search")
public interface SearchFeignService {
    @PostMapping("/search/save/product")
    R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);

    @RequestMapping("/search/test1")
    R test1();


}
