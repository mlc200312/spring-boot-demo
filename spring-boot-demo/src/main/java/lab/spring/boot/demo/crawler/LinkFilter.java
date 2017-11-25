package lab.spring.boot.demo.crawler;

public class LinkFilter {

	public boolean accept(String linkUrl) {
		if (linkUrl.startsWith("https://") || linkUrl.startsWith("http://"))
			return true;
		else
			return false;
	}

}
