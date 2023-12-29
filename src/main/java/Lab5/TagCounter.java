package Lab5;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
public class TagCounter {

    public static void main(String[] args) {
        String url = "https://www.youtube.com";
        System.out.println("Task 5: ");
        try {
            Map<String, Integer> tagFrequencyMap = getTagFrequency(url);

            System.out.println("Результат у лексикографічному порядку:");
            tagFrequencyMap.forEach((key, value) -> System.out.println(key + ": " + value));

            System.out.println("У порядку зростання по частоті появи тегів:");
            tagFrequencyMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> getTagFrequency(String url) throws IOException {
        Map<String, Integer> tagFrequencyMap = new TreeMap<>();

        Document document = Jsoup.connect(url).get();
        Elements elements = document.getAllElements();

        for (Element element : elements) {
            String tagName = element.tagName();
            tagFrequencyMap.put(tagName, tagFrequencyMap.getOrDefault(tagName, 0) + 1);
        }

        return tagFrequencyMap;
    }
}

