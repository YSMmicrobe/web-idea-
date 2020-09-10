package com.baizhi.config;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000119624813";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCiEzgD0i4nC4f+aV8/G0uB7KU7xpJDc5yRrFM1cAkf5DsJij1mNPN/kxEX+bR90VkNcQCYR42/R7kol5BJt4bwKK/iu0WeNrCVZ8cyoMICNsV9oSYCK3WOGGamPTznA332bFUWQ4rpnVktWJQeo0fX1GemJmZtKzgQvTRnGPLf31QBOvxNbltGqPa3i7qsRbG1rm/Z5K2nElYbIO0Oq7veJP39q8WbKrCtUqa7h2FJ3ngVd0lGoHhHMXZS2SEzSfbj8VEv0lKJ6zSGNT20y8yqKiN7wF2WFE9bwvItfKZf+Lr3SwWbOuacyHJdsfZiACq7g4eri4uau43iNFDomdrxAgMBAAECggEAGCJigfcnVjsaWiEYxM3stYEmrbsJBrBNjUeq8FcplK0ouWfzcqfJ5qJgtkBBx0aISz8bhpGJIwWsJcZD/yYsGtEEN/AJEuEz9FuKxxg3K5s6V1XK0iHklG8/wdt2mTPk6vAAz5rpMZZztBPvooxP42zGrnAjang4Fg4Gop+NcxaSwbF6iERW19nzXVy5Xv2UyQcN1Oh8wClUjvSMAXeHTJycMyavxEV1rz1IRN69NCXlFX7U2ATrqdNPYhg4rePC6pIBYedgCW3dHgj/PHhs3SHdnFjcjgOyBda0oY9NSpuDW9D7UpliSFBXudJ4sLyre2NtMuqRZpe6VBOLVKRwnQKBgQDOCfhGk/sBd2FMDf6sMijQSeobaBQhCvj8g/joCHFxvDsrkkI419CyJuXBpvrj5/dlqgq111EqKR5+UsRom6GOFQf8h1lYr9kdxyINVM881a3mpCkepv0e7QZiKZBGzKIV+9MMUCCw0sAziQTCohFlf+C/anKFBWVk0tcGDHGFrwKBgQDJYCgu5clPkvo/8QgKQtfDvIOKP3DCGz6N9/oCZpc8g6gq7urTA5aXfjB4ALePpJvHiu5j4TdWVbaZhw5TiwdSlLRKWenazE0mQJSPHQZPuup/kj8pI2QZ296gOEjYgiKgfOplHmJaDM2QHrmR/x3Z+yjW73FrfpBLAnYmXblxXwKBgFR+ii6HaRxE1MXXx2TefRZN+Y+bswWJ9mm3xU+ChuNZifpoVHfzKUal5Prxe1oTOsWaYiIIVuSvUC4Fyz4K9MnLnibVarKQCr3HeBN3gDU2e8Zl8+b6HDuegEupN92Q9beGOhqGkaFyDBgWTLl0tSWmt4hIIwaiG96pCD0WxUdJAoGANvVVQidYX60/OwAvL426kSL7y1kxDuick+ZfhxQ0pkFQPhdiYyCRktrPo5CeiEdmdHkIQp4OmjNeWFwxnr9Myk7nPXt4hUxIqe3qHXzQYiYjJZnmPvX3tc753UQ/LUem56Hv3pUCRo1D9NdN0fiMTxdqt+41SB8MhkwvrpzZpYUCgYBaIBazBYvhooJD+abV7C23hUAhtAu7wJ0AdMHuS8QcP5FTRjJz0lOBR2WDpn2gZkG8jfdEW1OAUsxMO2IX3mNUwYfOuix3Jp3UEIHU0RAXPSbRXAbn0gM4PLhBNVeqJvQ0C0/rpkIdie3HsE1h7PTC0utzfdxBHmLhND31Jam7sQ==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwIoQVhZqgL4nxuTMpCZ/xNuf0A8jY3Cc0FNQSd78N6hgG9j2N+r8/Hv8LnWT+C7tAswSsNlu1B7EoS8sMQuKW0kV07JgZRJJariSMLbj5N0OWA0npCF6D+FPkULxZiaI+dk1FduYOaWTmSFL41QwPJbqTRhejIpHGWjd9/vLJxR3VKFcquHnOK1KU1njf8JTq8JSZPoCq4FAenhTjLVumDn/xD4TSYvBF2S9YhB1WXvrqMuIq92JPI7bQawU3CkX4/b2pHGzA1JJML+U4fspAemw1WWkbrpUvwsRC7glA7k8tj6J5uTPDPmwNk5Kwbiy6eePw2LUzAqp9EGHWRfktwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=124这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8989/DangDangWang/order/pay";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8989/DangDangWang/order/pay";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关          沙箱环境下需要替换为：                "https://openapi.alipaydev.com/gateway.do"
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }
}


