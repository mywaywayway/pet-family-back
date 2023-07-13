package com.pet.pro.controller;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.pet.pro.Result;
import com.pet.pro.entity.SmsEntity;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController("SmsController")
@RequestMapping("/sms")
public class SmsController {
    /**
     * 发送短信
     * @param sms 手机号和验证码
     */
    @RequestMapping(value = "/sendCode",method = RequestMethod.POST)
    public void sms(@RequestBody SmsEntity sms){
        int appid = 1400838142;
        String appKey = "d8b1afc371ad9e44b37822b7bd334651";
        int templateId = 1860530;
        String smsSign = "乐学律己2公众号";
        try{
            String[] params ={ sms.getCode() };
            SmsSingleSender sSender  = new SmsSingleSender(appid,appKey);
            SmsSingleSenderResult result = sSender.sendWithParam("86",sms.getPhone_number(),
                    templateId,params,smsSign,"","");
            System.out.println(result);
        }catch (HTTPException | JSONException | IOException e){
            e.printStackTrace();
        }
    }

    @PostMapping("/getKey")
    public Result<?> getKey(){
        String key = RandomStringUtils.randomNumeric(6);
        return Result.success(key,"验证码");
    }


}
