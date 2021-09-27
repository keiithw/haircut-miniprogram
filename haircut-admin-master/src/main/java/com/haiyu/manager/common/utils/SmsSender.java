package com.haiyu.manager.common.utils;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jsms.api.SendSMSResult;
import cn.jsms.api.common.SMSClient;
import cn.jsms.api.common.model.SMSPayload;
import org.springframework.stereotype.Component;

import java.util.Map;


public class SmsSender {

    public static String masterSecret = "****";
    public static String appKey = "****";  // 自己去申请
    public final static int NOTICE_TEMPLATE = 177543;
    public final static int APM_SUCCESS_TEMPLATE = 179836;
    private static SMSClient smsClient = new SMSClient(masterSecret, appKey);

    public static void sendNoticeSms(String phoneNumber, String createdTime, String serveName) {
        SMSPayload payload = SMSPayload.newBuilder()
                .setMobileNumber(phoneNumber) // 手机号码
                .setTempId(NOTICE_TEMPLATE)            // 短信模板ID,需要自己去申请
                .addTempPara("createdTime", createdTime)  // 模板里面的参数
                .addTempPara("serveName", serveName)   // 如果你的短信有多个code就一直添加模板参数          addTempPara
                .build();
        try {
            System.out.println("尝试发送短信"+phoneNumber);
            SendSMSResult res = smsClient.sendTemplateSMS(payload);
            System.out.println(res.toString());
        } catch (APIConnectionException | APIRequestException e) {
            e.printStackTrace();
        }
    }

    public static void sendApmSuccess(Map<String,String> smsParam){
        SMSPayload payload = SMSPayload.newBuilder()
                .setMobileNumber(smsParam.get("phone")) // 手机号码
                .setTempId(APM_SUCCESS_TEMPLATE)            // 短信模板ID,需要自己去申请
                .addTempPara("storeName", smsParam.get("storeName"))  // 模板里面的参数
                .addTempPara("serveName", smsParam.get("serveName"))   // 如果你的短信有多个code就一直添加模板参数          addTempPara
                .build();
        try {
            System.out.println("尝试发送短信"+smsParam.get("phone"));
            SendSMSResult res = smsClient.sendTemplateSMS(payload);
            System.out.println(res.toString());
        } catch (APIConnectionException | APIRequestException e) {
            e.printStackTrace();
        }
    }

}
