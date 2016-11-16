import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CreateHtmlFromString {
	public static void main(String[] args) {
		String html = "<html>"
						+ "<head>"
							+ "<title>Polytechnic university</title>"
						+ "</head>"
						+ "<body>"
							+ "<h1>Nguyen Van A</h1>"
							+ "<h2>Nguyen Van B</h2>"
							+ "<h3>Nguyen Van C</h3>"
						+ "</body>"
					+ "</html";
		Document document = Jsoup.parse(html);
		String title 	  = document.title();
		String content 	  = document.toString();
		System.out.println("Title:\n\t"    + title);
		System.out.println("Content:\n" + content);
		
		try {
			Document doc = Jsoup.parse(new File("D:\\Javascript\\register.html"), "UTF-8");
			Element form = doc.getElementById("signUp");
			System.out.println("\nFrom action: " + form.attr("action"));
			System.out.println();
			// getElementsByTag ở số nhiều
			Elements elementInput = form.getElementsByTag("input");
			for(Element ele: elementInput)
			{
				String key = ele.attr("name");
				String value = ele.attr("value");
				System.out.println("Key: " + key + " - value: " + value);
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e.toString());
		}
		
		// getLink
		Document docGetLink;
		try {
			docGetLink = Jsoup.connect("http://www.tuoitre.vn").get();
//			System.out.println(docGetLink.toString());
			Elements elementLink = docGetLink.getElementsByTag("a");
			
			for (Element ele: elementLink)
			{
				String href = ele.attr("href");
	            String text = ele.text();
	            System.out.println(text);
	            System.out.println("\t" + href);
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e.toString());
		}
	}
}
