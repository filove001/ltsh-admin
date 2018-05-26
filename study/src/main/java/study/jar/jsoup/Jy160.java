package study.jar.jsoup;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Jy160 {
    @Test
    public void test() throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
//        String html=Jsoups.get("https://www.91160.com/dep/show/depid-3598.html");
//        System.out.println(html);
//        HttpConnection.
//        Jsoups.checkQuietly();
//        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
//            //信任所有
//            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//                return true;
//            }
//        }).build();
//
////sslContext
////        //ALLOW_ALL_HOSTNAME_VERIFIER:这个主机名验证器基本上是关闭主机名验证的,实现的是一个空操作，并且不会抛出javax.net.ssl.SSLException异常。
////        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1" }, null,
////                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//        //用这个，上面的不用了
//        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
//                sslContext);

        System.out.println(Jsoup.connect("https://www.91160.com/dep/show/depid-3598.html")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36")
                .header("Cookie","__jsluid=b27c497507771416c73d27406e35f987; gr_user_id=e8831ebe-0647-430d-8d7f-07506e94936d; Hm_lvt_c4e8e5b919a5c12647962ea08462e63b=1525830606; __guid=FjprU75af253cd894ad0.40769650; FISKCDDCC=088a4b0d7f2305376b9085e47590c01f; vlstatId=vlstat-1525830631000-1208019148; ip_city=sz; SHADOWMAN=%7B%22key%22%3A%22d87bc738ec309d1415717b6f8971dc97%22%2C%22val%22%3A%22f4086d6aaa8aa37f63e79e1bc5abd548%22%2C%22tm%22%3A1525830650%7D; channel_id=16; location_city_id=2918; _ga=GA1.2.1197190452.1525830756; _gid=GA1.2.1625574869.1525830756; Hm_lpvt_c4e8e5b919a5c12647962ea08462e63b=1525833225; gr_session_id_88c697c1877e5045=9df39ab5-fe87-4dd6-a6ae-54c5baae7daf_true; __jsl_clearance=1525834833.138|0|qOwqWQY1PMmyeYct5wGULOW%2B65Y%3D")
//                .sslSocketFactory( sslContext.getSocketFactory())
                .get());
    }
    @Test
    public void newhealth() throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
//                SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
//            //信任所有
//            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//                return true;
//            }
//        }).build();
        System.out.println(Jsoup.connect("https://www.newhealth.com.cn")
                .header("Accept", "text/html,application/xhtml+xml,application/xml")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language","h-CN,zh;q=0.9")
//                .header("Content-Type", "application/json;charset=UTF-8")

//                .header("Host","www.newhealth.com.cn")
                .header("Connection","keep-alive")
//                .header("keep-alive","false")
//                .header("Cache-Control","max-age=0")
                .header("cookie","JSESSIONID=4133744D1AC27899A194BD5706188700")
//                .followRedirects(true)
                .header("Cache-control","no-cache, no-store")
//                .ignoreContentType(false)
                .header("Upgrade-Insecure-Requests","1")
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36")
                .timeout(150000)
//                .validateTLSCertificates(false)
//                .sslSocketFactory( sslContext.getSocketFactory())
                .get());
    }
}
