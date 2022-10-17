package com.leetcode.medium;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern_1152 {
    private static class Visited {
        private final int time;
        private final String website;

        public Visited(int time, String website) {
            this.time = time;
            this.website = website;
        }

    }

    /*
    Runtime: 28 ms, faster than 88.37% of Java online submissions for Analyze User Website Visit Pattern.
    Memory Usage: 43.5 MB, less than 86.36% of Java online submissions for Analyze User Website Visit Pattern.
     */
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visited>> userWithSequence = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            userWithSequence.putIfAbsent(username[i], new ArrayList<>());
            userWithSequence.get(username[i]).add(new Visited(timestamp[i], website[i]));
        }
        userWithSequence.forEach((s, visitedList) -> visitedList.sort((visit1, visit2) -> visit1.time - visit2.time));
        // Sequence , Users
        Map<String, Set<String>> listMap = new HashMap<>();
        for (Map.Entry<String, List<Visited>> entry : userWithSequence.entrySet()) {
            String userName = entry.getKey();
            List<Visited> userData = entry.getValue();
            // generate all 3 sequences are possible in the right sequence
            for (int i = 0; i < userData.size() - 2; i++) { // size -2 to enhance the performance and avoid sequence less than 3
                for (int j = i + 1; j < userData.size() - 1; j++) {
                    for (int k = j + 1; k < userData.size(); k++) {
                        String threeSequence = userData.get(i).website + " " +
                                userData.get(j).website + " " +
                                userData.get(k).website;
                        listMap.putIfAbsent(threeSequence, new HashSet<>());
                        listMap.get(threeSequence).add(userName);
                    }
                }
            }
        }

        int currentMax = Integer.MIN_VALUE;
        String mostFrequencySequence = "";
        for (String sequence : listMap.keySet()) {
            if (listMap.get(sequence).size() > currentMax) {
                mostFrequencySequence = sequence;
                currentMax = listMap.get(sequence).size();
            } else if (listMap.get(sequence).size() == currentMax) { // when we need to retrieve in lexicographically
                if (mostFrequencySequence.compareTo(sequence) > 0)
                    mostFrequencySequence = sequence;
            }
        }
        return List.of(mostFrequencySequence.split(" "));
    }
}
