package models;

/**
 * Created by wangjin on 17/3/13.
 */
public class QiniuTokenResponse {

    private String buckethost;

    private String uptoken;

    public String getUptoken() {
        return uptoken;
    }

    public void setUptoken(String uptoken) {
        this.uptoken = uptoken;
    }

    public String getBuckethost() {
        return buckethost;
    }

    public void setBuckethost(String buckethost) {
        this.buckethost = buckethost;
    }
}
