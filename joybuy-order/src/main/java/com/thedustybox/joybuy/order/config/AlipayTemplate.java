package com.thedustybox.joybuy.order.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.thedustybox.joybuy.order.vo.PayVo;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alipay")
@Component
@Data
public class AlipayTemplate {

    //在支付宝创建的应用的id
    private   String app_id = "9021000124678059";

    // 商户私钥，您的PKCS8格式RSA2私钥
    private  String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCwhiN2zdZG2qs6n631VVIta2x8JI9sLj9QwbN43ode4VrMV2XYG6Tlefu0BYs6cbzKGFz44cOg7iWzJ+Eu7v+3+lYaZ1pVq+Myf8vFl+3IVzRX/SAC5J8itcunTk+H9/2zFLzyXz97rtIs2DJqIQp1tZpCuQBYqnFVOnALj/OG6Bejldq/cJeBLaFSaw4EiHN7m3lBO4uQIKkLeJ9Fe2vEi+oIRMMD9LeSoKEYpKasAuxRFML92QYwKcUbgNYnny3fxIbD4TZChTEMr/lDpePZ5KaFNxk79NZhwMe0mi/Tn3T1nyPYnSsdgSIQlQ27VMq6sHh/fBma80MiSkUuGbrJAgMBAAECggEADS3mpe8WSXH4CMd1OHTnTsbPcbFVF/GX/pKHsMWEe9v9aHY5/1mJBS0HUth7HaDyRHBvOJG6hmBhZi/bCyMC6pyBIzWGNBFCRDnwX89JDIUePleCtVSWYQQLsXESVQd55I3u0XW1CqnxvTFjCjNvUXx+iO7BDN2k2oUjammT+AVqNj7OTpimyBW3/U+yIwl1nKM76e1VI37bMFNmVbqK8u2qA13RNjDsT0G6KfEegoIF6xBonNBWm6sP7xg1OLzTF1ehhL/wN6z3qw57S1Iw9WLnPCGZnwF3r4w/aTAd1eTjWZRZhB12y+ml8wE6eW8eamC/1PZuCvDKFbHbwBuxNQKBgQDjMY0K/2EOoJVsQkwaGYUFXnkUV25/IC0tAQ6q1b8sIhDF2pLHvIGaUq9kgWacPGANg/Mwq74he3ajJmkYJDaEGEn+mkyeN2aKsQvH4atfKfhAUlLQzTTJ2Iqb7IDgVIH/8ibHPcfNETjaaEtCN5gLr1nPzQOrNi05K1P7jNvdawKBgQDG5+jeHfoC8+05CaZVJFMUOTzxl6VwbdvM3XDGLd8O2R96+aVlBEOiV26Skbvl7703lUn6r8/lsxhW8vCx+474WsXhI2IApo08TgfKiFsV8tj0xJxN15gXyK3Gn/6S753jl8J+YQV0KNNaTSNeBvnqcY/9hbkz4YMsUDjrZ2fBmwKBgDcLHEbb1KH8mfceoN157VZ9qwwYmrbGDuvmY61UF/sTTckByaoGq8e93KyXBUs4/XSI0XSrR2dJSFcCyVeF/odGczbyHzn95iQX/OiybhiiTHkY+OOJtA5rHjnktNyk3NIr0uVWvH+ceo+/0Ov8GCRMmY/U9dyXRaGiM7iwSdx9AoGBAKGC7rRt4vVC3P3TuByqwktJrxL98Hi6vCA+L7S8ysNjywwwavz72W+ZT0/0xn6PjTX1I31MBaSfKMRxwMDFY/KGwudts8aTd1vggLMUxeGssD8Q51rOFdI6QeFnSXBG4g5MzMGSRrtr6zMIMA/J2mVkkWdrjldyZvE0swNzk+zBAoGAPnBzvGDdxpGVxQiZCszVTkvhTLwrsjma6kveMawdsz7GLNNBlYCcEGS0LJA8r1cNf1tcpEhGO92V5jmRk9iRDQDafgGRDjgM5KMowrPGFFwNzLshAFRJTNRm3cBuUtPAv6kLsxJg5a2S0IYPu8Li2XigV1iskCV2qFK1XUtHvRM=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    private  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgP/Bq7tsam8NWOHeIOveFXrHd/uCTQ7myermDKdFwMRNhVDk3BbtpqksTAPWd7MmycIH8urpBb+KlR/TI6OozI2EnIfPSdJla2lj5iLOyjTHo/bw3Vw1fOUkRgliOQsyO3joHe0bDJWMw9sSkOnAMh/GIT5yv6eS4hg6v1WoM6815rUowYswoVr+ZDBrm00o5UuYhd7E9eZ/r+/fnUzmKQBu8CD0HEfqx9LD9XcbOpLhJorEUF6CGilnudLvyRp3+ztRTgfSwR9RT8xk0Q6+M1pVX4lv7pTqv+NugsUxYaN1pd/REqsbVOajUl6CkF/ez+H+5NHeRlyhx8OnQ+vvnwIDAQAB";
    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    private  String notify_url = "http://u7fd4v.natappfree.cc/payed/notify";;

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页
    private  String return_url =  "http://order.gulimall.com/memberOrder.html";;

    // 签名方式
    private  String sign_type = "RSA2";

    // 字符编码格式
    private  String charset = "utf-8";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    private  String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    public  String pay(@NotNull PayVo vo) throws AlipayApiException {

        //AlipayClient alipayClient = new DefaultAlipayClient(AlipayTemplate.gatewayUrl, AlipayTemplate.app_id, AlipayTemplate.merchant_private_key, "json", AlipayTemplate.charset, AlipayTemplate.alipay_public_key, AlipayTemplate.sign_type);
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,
                app_id, merchant_private_key, "json",
                charset, alipay_public_key, sign_type);

        //2、创建一个支付请求 //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = vo.getOut_trade_no();
        //付款金额，必填
        String total_amount = vo.getTotal_amount();
        //订单名称，必填
        String subject = vo.getSubject();
        //商品描述，可空
        String body = vo.getBody();

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //会收到支付宝的响应，响应的是一个页面，只要浏览器显示这个页面，就会自动来到支付宝的收银台页面
        System.out.println("支付宝的响应："+result);

        return result;

    }
}
