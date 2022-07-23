package hutool.http;

import cn.hutool.http.HttpConnection;
import cn.hutool.http.HttpResponse;

import java.nio.charset.Charset;

/**
 * @Auther d
 * @Date 2022/2/12 9:45
 * @Describe
 **/
public class RR extends HttpResponse {

    /**
     * 构造
     *
     * @param httpConnection {@link HttpConnection}
     * @param charset        编码，从请求编码中获取默认编码
     * @param isAsync        是否异步
     * @param isIgnoreBody   是否忽略读取响应体
     * @since 3.1.2
     */
    protected RR(HttpConnection httpConnection, Charset charset, boolean isAsync, boolean isIgnoreBody) {
        super(httpConnection, charset, isAsync, isIgnoreBody);
    }

    @Override
    public String toString() {
        int status = 0;
        try {
            status = HttpResponse.class.newInstance().getStatus();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("状态码======"+status);
        return super.toString();
    }
}
