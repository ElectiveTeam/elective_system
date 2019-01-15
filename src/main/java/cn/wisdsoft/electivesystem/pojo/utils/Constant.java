package cn.wisdsoft.electivesystem.pojo.utils;

import java.util.UUID;

/**
 * @Description: TODO
 * @Author: SongJunWei
 * @CreateDate: 2019/1/8 10:45
 * @Version: 1.0
 */
public class Constant {
    /**
     * 数据请求返回码
     */
    public static final int RESCODE_SUCCESS = 1000;				//成功
    public static final int RESCODE_SUCCESS_MSG = 1001;			//成功(有返回信息)
    public static final int RESCODE_EXCEPTION = 1002;			//请求抛出异常
    public static final int RESCODE_NOLOGIN = 1003;				//未登陆状态
    public static final int RESCODE_NOEXIST = 1004;				//查询结果为空
    public static final int RESCODE_NOAUTH = 1005;				//无操作权限

    /**
     * jwt
     */
    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
//    public static final String JWT_ID = JWT_SECRET.substring(5,10);
    public static final int JWT_TTL = 20*1000; // 60*60*1000;  //millisecond
    public static final int JWT_REFRESH_INTERVAL = 18*1000; //55*60*1000;  //millisecond
    public static final int JWT_REFRESH_TTL = 60*1000; // 12*60*60*1000;  //millisecond
}
