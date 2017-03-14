package services;

import com.qiniu.util.Auth;
import models.QiniuTokenResponse;
import org.springframework.stereotype.Service;

/**
 * Created by wangjin on 17/3/13.
 */
@Service
public class QiniuService {

    public QiniuTokenResponse getToken(String key){
        String accessKey = "g64691NccWIGl9-vmdU7_eZBqJqQ-w195-7osHi6";
        String secretKey = "MgzzjGg_QkgXhF5WsWJPJHDqFTvtrTGvYuFNUTKH";
        String bucket = "nothinghappen";

        Auth auth = Auth.create(accessKey, secretKey);
        String token = auth.uploadToken(bucket, key);
        QiniuTokenResponse res = new QiniuTokenResponse();
        res.setBuckethost("ompl028lw.bkt.clouddn.com");
        res.setUptoken(token);
        return res;
    }

}
