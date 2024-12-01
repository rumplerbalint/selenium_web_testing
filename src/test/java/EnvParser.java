import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class EnvParser {
    private Map<String, String> envVars = new HashMap<>();
    private String envPath = ".env";

    public EnvParser()
    {
        try {
            Files.lines(Paths.get(envPath)).forEach(line -> {
                // Ignore comments and blank lines
                if (line.trim().isEmpty() || line.startsWith("#")) return;

                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    envVars.put(parts[0].trim(), parts[1].trim());
                }
            });
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEnvVar(String key)
    {
        return envVars.get(key);
    }
}
