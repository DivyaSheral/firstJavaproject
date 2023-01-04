import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    SoftAssert s;

    @Test(priority = 1)
    public void workingWithStreams() throws IOException {
      /*  String[] names = {"Divya", "Rahul", "Kiaza","Divya","Anuja","Zoya"};
        List namesList = Arrays.asList(names);
        Stream nameStream = namesList.stream();
        nameStream.sorted().forEach(s -> System.out.println(s));
        nameStream.distinct().forEach(s->System.out.println(s));
        namesList.stream().filter(s->s.*/
        ArrayList<String> names = new ArrayList<String>();
        names.add("Divya");
        names.add("Aditi");
        names.add("Kiara");
        names.add("Akshara");
        names.add("Kashi");
        names.add("Hashi");
        names.add("Kiran");
        names.add("Ishanvi");
        names.add("Dhruvi");
        names.stream().filter(s->s.startsWith("K")).sorted().forEach(s->System.out.println(s));
        long count = names.stream().filter(s -> s.startsWith("K")).sorted().count();
        System.out.println(count);

     // names.stream().anyMatch(s -> s.contains("ar"));
        names.stream().filter(s->s.length()<6).limit(2).forEach(s->System.out.println(s));




    }
}
