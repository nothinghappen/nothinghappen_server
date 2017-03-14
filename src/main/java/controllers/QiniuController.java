package controllers;

import com.qiniu.util.Auth;
import models.QiniuTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.QiniuService;

/**
 * Created by wangjin on 17/3/13.
 */
@Controller
@RequestMapping("/")
public class QiniuController {

    private QiniuService qiniuService;

    @Autowired
    public void setQiniuService(QiniuService qiniuService) {
        this.qiniuService = qiniuService;
    }

    @RequestMapping(value = "/uptoken",method = RequestMethod.GET)
    @ResponseBody
    public QiniuTokenResponse getUpToken(@RequestParam String key){
        return qiniuService.getToken(key);
    }

}
