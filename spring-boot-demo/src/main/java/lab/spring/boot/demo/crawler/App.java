package lab.spring.boot.demo.crawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

import lab.spring.boot.demo.crawler.BfsSpider.DoWhat;

public class App {

	// main 方法入口
	public static void main(String[] args) {
		// Login.post("http://localhost:7777/login_pharmacyLogin.action",
		// "jiao100", "11111111");
		// Login.loginByPost("http://101.201.77.46/portal/login/login",
		// "test11", "199401024");

		String[] urls = new String[3659];
		for (int i = 3000; i < urls.length; i++) {
			urls[i] = "http://localhost:7777/pharmacy_toUpdateJsp.action?pid="
					+ i;
		}

		BfsSpider crawler = new BfsSpider();
		crawler.crawling(urls, new DoWhat() {

			@Override
			public void analyze(String url) {
				DownTool downTool = new DownTool();
				downTool.setSessionId("F48DCC5D50C53D9606CFD3F90F879796");

				String filePath = downTool.getLoader(url);

				Map<String, String> data = HtmlParserTool.extracInputs(
						filePath, "utf-8");

				if (!data.isEmpty()) {
					App.write(data.toString());
				}
			}
		});
	}

	public static void write(String content) {
		OutputStream out = null;
		try {
			// 根据文件创建文件的输出流
			out = new FileOutputStream(new File("temp/pharmacy-"
					+ UUID.randomUUID() + ".txt"));
			// 把内容转换成字节数组
			byte[] data = content.getBytes();
			// 向文件写入内容
			out.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭输出流
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
