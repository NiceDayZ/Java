package com.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RequestService {
    public boolean writeInRepository(RequestType requestType){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
        LocalDateTime timestamp = LocalDateTime.now();

        String text = (requestType.getKey() + ' ').repeat(requestType.getValue()) + "% " + timestamp.format(dtf).toString();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("repository.txt", true));
            writer.append(text);
            writer.append('\n');
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public List<String> readFromRepository(){
        List<String> lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("repository.txt"))) {
            for(String line; (line = br.readLine()) != null; ) {
                lines.add(line);
            }
            // line is not visible here.
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public String formatHTML(List<String> lines){
        String html = "<table><th style=\"border: 1px solid;\">Key</th><th style=\"border: 1px solid;\">Timestamp</th>";

        Collections.sort(lines);

        for(String line: lines){
            String[] row = line.split(" % ");
            html = html.concat("<tr><td style=\"border: 1px solid;\">" + row[0] + "</td>" + "<td style=\"border: 1px solid;\">" + row[1] + "</td></tr>");
        }

        return html;
    }

    public String formatJSON(List<String> lines){
        String json = "[";

        Collections.sort(lines);

        for(String line: lines){
            String[] row = line.split(" % ");
            json = json.concat("{\"key\":" + row[0] + ", \"timestamp\":" + "\"" + row[1] + "\"" + "},");
        }

        json = removeLastChar(json);
        json = json.concat("]");

        return json;
    }

    private static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }


}
