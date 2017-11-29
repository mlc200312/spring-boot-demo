package lab.springboot.demo.crawler;

import java.io.File;
import java.io.IOException;

import jodd.io.FileUtil;
import jodd.io.NetUtil;
import jodd.jerry.Jerry;
import jodd.jerry.JerryFunction;
import jodd.util.SystemUtil;

public class JerryHtmlTool {

	public static void main(String[] args) throws IOException {

//		Jerry.jerry("").$(cssSelector, context);
		
		// download the page super-efficiently
		File file = new File(SystemUtil.tempDir(), "localhost_7777_pharmacy_toUpdateJsp.action_pid=1.html");
		NetUtil.downloadFile("http://localhost:7777/pharmacy_toUpdateJsp.action", file);

		// create Jerry, i.e. document context
		Jerry doc = Jerry.jerry(FileUtil.readString(file));

		// parse
		doc.$("input").each(new JerryFunction() {
			public Boolean onNode(Jerry $this, int index) {
				System.out.println("-----");
				System.out.println($this.$("div.album_title").text());
				System.out.println($this.$("div.album_artist").text().trim());
				return true;
			}
		});
	}

}
