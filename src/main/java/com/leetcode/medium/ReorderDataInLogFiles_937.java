package com.leetcode.medium;

import java.util.*;


/*
The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
 */
public class ReorderDataInLogFiles_937 {

    public String[] reorderLogFiles(String[] logs) {

        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        // first separate letter logs and digit logs
        separateLetterLogsFromDigitLogs(logs, letterLogs, digitLogs);
        // second sort letter logs by 2 criteria
        sortLetterLogs(letterLogs);
        //The digit-logs maintain their relative ordering. So we will not do any things
        // merge letter with digits in result
        return generateOutput(letterLogs, digitLogs);

    }


    private static void separateLetterLogsFromDigitLogs(String[] logs, List<String> letterLogs, List<String> digitLogs) {
        // we can identify the letter logs by look at the last character
        for (String log : logs)
            if (Character.isDigit(log.charAt(log.length() - 1)))
                digitLogs.add(log);
            else
                letterLogs.add(log);
    }
    private static void sortLetterLogs(List<String> letterLogs) {
        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String letter1, String letter2) {
                // "let1 art can" we need just from her "art can"
                String firstLetter = letter1.substring(letter1.indexOf(" ") + 1);
                String secondLetter = letter2.substring(letter2.indexOf(" ") + 1);
                // if to letters are the same then we need to compare with the identifier
                return firstLetter.equals(secondLetter) ? letter1.compareTo(letter2) : firstLetter.compareTo(secondLetter);
            }
        });
    }
    private static String[] generateOutput(List<String> letterLogs, List<String> digitLogs) {
        String[] logsSorted = new String[letterLogs.size() + digitLogs.size()];
        int counter = 0;
        for (; counter < letterLogs.size(); counter++)
            logsSorted[counter] = letterLogs.get(counter);


        for (String digitLog : digitLogs)
            logsSorted[counter++] = digitLog;


        return logsSorted;
    }



    public static void main(String[] args) {
        ReorderDataInLogFiles_937 reorderDataInLogFiles_937 = new ReorderDataInLogFiles_937();
        String[] strings = reorderDataInLogFiles_937.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"});
        System.out.println(Arrays.asList(strings));
        // ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
        String[] strings1 = reorderDataInLogFiles_937.reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"});
        System.out.println(Arrays.asList(strings1));
        // ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
    }
}
