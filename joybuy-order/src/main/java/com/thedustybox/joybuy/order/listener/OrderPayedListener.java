package com.thedustybox.joybuy.order.listener;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.thedustybox.joybuy.order.config.AlipayTemplate;
import com.thedustybox.joybuy.order.service.OrderService;
import com.thedustybox.joybuy.order.vo.PayAsyncVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 订单支付成功监听器
 * @Created: with IntelliJ IDEA.
 * @author: thedustybox
 * @createTime: 2024-07-08 17:39
 **/

@RestController
public class OrderPayedListener {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AlipayTemplate alipayTemplate;

//    @PostMapping(value = "/payed/notify")
//    public String handleAlipayed(HttpServletRequest request){
//
//        Map<String, String[]> map = request.getParameterMap();
//        for(String key:map.keySet()){
//            String value = request.getParameter(key);
//            System.out.println("参数名"+key+"==>参数值"+map);
//        }
//        System.out.println("支付宝异步通知收到了" + map);
//        return "success";
//    }
//    @GetMapping(value = "/payed/notify")
//    public String gethandleAlipayed(HttpServletRequest request){
//
//        Map<String, String[]> map = request.getParameterMap();
//        System.out.println("支付宝异步通知收到了" + map);
//        return "success";
//    }

    @PostMapping(value = "/payed/notify")
    public String handleAlipayed(PayAsyncVo asyncVo, HttpServletRequest request) throws AlipayApiException, UnsupportedEncodingException {
        // 只要收到支付宝的异步通知，返回 success 支付宝便不再通知
        // 获取支付宝POST过来反馈信息
        //TODO 需要验签
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, alipayTemplate.getAlipay_public_key(),
                alipayTemplate.getCharset(), alipayTemplate.getSign_type()); //调用SDK验证签名

        if (signVerified) {
            System.out.println("签名验证成功...");
            //去修改订单状态
            String result = orderService.handlePayResult(asyncVo);
            return result;
        } else {
            System.out.println("签名验证失败...");
            return "error";
        }
    }

    //微信的异步通知，现不实现
//    @PostMapping(value = "/pay/notify")
//    public String asyncNotify(@RequestBody String notifyData) {
//        //异步通知结果
//        return orderService.asyncNotify(notifyData);
//    }

}
