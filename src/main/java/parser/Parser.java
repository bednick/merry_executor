package parser;

import bricks.Command;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class Parser implements IParser {
    private List<Command> lines;
    private StringBuilder builder;
    private String nextLine;

    public Parser() {
        nextLine = null;
        lines = new ArrayList<>();
        builder = new StringBuilder();
    }

    @Override
    public void load(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
        readLine(reader);
        while (nextLine != null) {
            if (nextLine.isEmpty() || nextLine.startsWith("##")) {
                readLine(reader);
                continue;
            }
            String[] spl = nextLine.split("#")[0].split(";");
            lines.add(new Command(
                    new HashSet<String>(Arrays.stream(spl[0].split(" "))
                            .filter(l->!l.isEmpty()).collect(Collectors.toSet())),
                    new HashSet<String>(Arrays.stream(spl[1].split(" "))
                            .filter(l->!l.isEmpty()).collect(Collectors.toSet())),
                    spl[2].trim(),
                    Integer.parseInt(nextLine.split("#")[1].trim())
            ));
            readLine(reader);
        }
    }

    @Override
    public Collection<Command> getData() {
        return lines;
    }

    private void readLine(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.endsWith("\\")) {
                builder.append(line);
                builder.deleteCharAt(builder.length()-1);
                builder.append(' ');
            } else {
                if (builder.length() > 0) {
                    builder.append(line);
                    line = builder.toString();
                    builder.delete(0, builder.length());
                }
                nextLine = line.trim();
                return;
            }
        }
        if (builder.length() > 0) {
            line = builder.toString();
            builder.deleteCharAt(builder.length()-1);
        }
        if (line != null){
            line = line.trim();
        }
        nextLine = line;
    }
}
