package com.example.vadim.myapplication;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vadim on 01.01.2018.
 */

class Add {
    private String path1 = "base.txt";
    private String path2 = "curPhrases.txt";

    private String getAll() throws IOException {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> all = readPhrases(new Scanner(new File(path1)));
        ArrayList<String> extra = readPhrases(new Scanner(new File(path2)));

        for (String string : all) {
            sb.append(string);
            sb.append("\n");
        }

        for (String string : extra) {
            all.add(string);
            sb.append(string);
            sb.append("\n");
        }

        writePhrases(all, new PrintWriter(new File(path1)));
        return sb.toString();
    }

    private ArrayList<String> readPhrases(Scanner from) {
        ArrayList<String> ans = new ArrayList<>();
        while (from.hasNextLine()) {
            ans.add(from.nextLine());
        }
        from.close();
        return ans;
    }

    private void writePhrases(ArrayList<String> what, PrintWriter to) {
        for (String string : what) {
            to.println(string);
        }
        to.close();
    }

    void add(String phrase, String who) throws IOException{
        ArrayList<String> phrases = readPhrases(new Scanner(new File(path2)));
        phrases.add("\"" + phrase + "\"" + " (c) " + who);
        writePhrases(phrases, new PrintWriter(new File(path2)));
    }
}