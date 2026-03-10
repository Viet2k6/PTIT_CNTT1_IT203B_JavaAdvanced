import java.util.*;
import java.util.stream.Collectors;

public class Bai6 {
    public static void main(String[] args) {
        record Post(String title, List<String> tags) {}
        List<Post> posts = Arrays.asList(
                new Post("Java", Arrays.asList("java", "backend")),
                new Post("Python", Arrays.asList("python", "data"))
        );

        List<String> allTags = posts.stream()
                .flatMap(p -> p.tags().stream())
                .collect(Collectors.toList());
        System.out.println(allTags);
    }
}
