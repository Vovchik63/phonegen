import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    public static List<String> convertCodesToList(String fileName) throws IOException, URISyntaxException {
        List result;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource(fileName);
        Path path = Paths.get(url.toURI());
        var lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        result = lines.stream().map(e -> e.split(","))
                .flatMap(Stream::of).collect(Collectors.toList());

        return result;
    }
}