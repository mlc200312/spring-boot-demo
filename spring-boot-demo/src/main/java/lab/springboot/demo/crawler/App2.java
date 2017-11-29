package lab.springboot.demo.crawler;

import lab.springboot.demo.crawler.BfsSpider.DoWhat;

public class App2 {

	public static void main(String[] args) {

		BfsSpider crawler = new BfsSpider();

		crawler.crawling(
				new String[] { "http://www.cnblogs.com/GnagWang/archive/2011/02/27/1966606.html" },
				new DoWhat() {

					@Override
					public void analyze(String url) {
						DownTool downTool = new DownTool();
						downTool.getLoader(url);
					}
				});

	}
}
