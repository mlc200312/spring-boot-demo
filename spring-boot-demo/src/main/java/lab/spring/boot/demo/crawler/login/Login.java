package lab.spring.boot.demo.crawler.login;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class Login {

	public static void get(String url, String username, String password,
			Object... os) {

		// 1.生成 HttpClinet对象并设置参数
		HttpClient httpClient = new HttpClient();
		// 设置 HTTP连接超时 5s
		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(5000);
		// 2.生成 GetMethod对象并设置参数
		GetMethod getMethod = new GetMethod(url);
		// 设置 get请求超时 5s
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
		// 设置请求重试处理
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());

		try {
			int statusCode = httpClient.executeMethod(getMethod);
			// 判断访问的状态码
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ getMethod.getStatusLine());
			}
			// 4.处理 HTTP 响应内容
			byte[] responseBody = getMethod.getResponseBody();// 读取为字节数组
			System.out.println(responseBody);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void post(String url, String username, String password,
			Object... os) {

		// 1.生成 HttpClinet对象并设置参数
		HttpClient httpClient = new HttpClient();
		// 设置 HTTP连接超时 5s
		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(5000);
		// 2.生成 PostMethod对象并设置参数
		PostMethod postMethod = new PostMethod(url);
		// 设置 psot请求超时 5s
		postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
		// 设置请求重试处理
		postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());

		postMethod.setParameter("user.userName", username);
		postMethod.setParameter("user.password", password);
		postMethod.setParameter("remember", "no");
		postMethod.setParameter("imageCode", "");

		try {
			int statusCode = httpClient.executeMethod(postMethod);
			// 判断访问的状态码
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ postMethod.getStatusLine());
			}
			// 4.处理 HTTP 响应内容
			byte[] responseBody = postMethod.getResponseBody();// 读取为字节数组
			try {
				DataOutputStream out = new DataOutputStream(
						new FileOutputStream(new File("temp\\login.txt")));
				for (int i = 0; i < responseBody.length; i++)
					out.write(responseBody[i]);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
