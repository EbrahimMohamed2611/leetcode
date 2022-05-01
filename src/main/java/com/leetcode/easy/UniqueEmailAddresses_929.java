package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class UniqueEmailAddresses_929 {
    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"})); //2
        System.out.println(numUniqueEmails(new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"})); //3
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"})); //2
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"})); //1
//        System.out.println(removeAllCharAfterPlu("test.email+alex@leetcode.com"));
//        System.out.println(removeDotPeriod("test.e.mail+bob.cathy@leetcode.com"));
    }


    /**
     * Time O(N^2)
     * Space O(N)
     * Runtime: 8 ms, faster than 95.57% of Java online submissions for Unique Email Addresses.
     * Memory Usage: 42.2 MB, less than 94.38% of Java online submissions for Unique Email Addresses.
     * Another Approach
     */
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails) {
            StringBuilder sb = new StringBuilder();
            for(char c: email.toCharArray()) {
                if (c == '.') continue;
                if (c == '+') break;
                if (c == '@') break;
                sb.append(c);
            }
            String cur = sb + email.substring(email.indexOf('@'));
            set.add(cur);
        }
        return set.size();
    }

    /**
     * Runtime: 10 ms, faster than 90.99% of Java online submissions for Unique Email Addresses.
     * Memory Usage: 46.6 MB, less than 60.21% of Java online submissions for Unique Email Addresses.
     * @param emails
     * @return
     */
    public static int numUniqueEmails3(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            StringBuilder newEmail = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
               if(c == '.')
                   continue;
               else if(c == '+'){
                   while (email.charAt(i) != '@')
                       i++;
                   newEmail.append(email.substring(i));
                   i = email.length();
               }else if(c == '@'){
                   newEmail.append(email.substring(i));
                   i = email.length();
               }
               else{
                   newEmail.append(c);
               }
            }
            uniqueEmails.add(newEmail.toString());
        }
        return uniqueEmails.size();
    }

    /**
     * Simple Version using hashSet (using string built-in function
     */

    public static int numUniqueEmails1(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String localName = email.split("@")[0]; // To extract localName
            String domain = email.split("@")[1]; // To extract domain
            localName = localName.replaceAll("\\.", "");
            localName = localName.split("\\+")[0];

            uniqueEmails.add(localName +"@"+ domain);
        }
        return uniqueEmails.size();
    }

    /**
     * Runtime: 22 ms, faster than 57.82% of Java online submissions for Unique Email Addresses.
     * Memory Usage: 42.9 MB, less than 81.60% of Java online submissions for Unique Email Addresses.
     *
     * @param emails
     * @return
     */
    public static int numUniqueEmails2(String[] emails) {
        Set<String> filteredEmails = new HashSet<>();
        for (String email : emails) {
            String emailWithoutPeriods = removeDotPeriod(email);
            String filteredEmail = removeAllCharAfterPlus(emailWithoutPeriods);
            filteredEmails.add(filteredEmail);
        }
        return filteredEmails.size();
    }

    private static String removeDotPeriod(String email) {
        int atIndex = email.indexOf("@");
        String beforeAt = email.substring(0, atIndex);
        String afterAt = email.substring(atIndex);

        return beforeAt.replaceAll("\\.", "") + afterAt;
    }

    private static String removeAllCharAfterPlus(String emailWithPlus) {
        int plusIndex = emailWithPlus.indexOf("+");
        int atIndex = emailWithPlus.indexOf("@");
        if (plusIndex == -1)
            return emailWithPlus;
        else {
            String fromAtToEnd = emailWithPlus.substring(atIndex);
            String fromStartToPlus = emailWithPlus.substring(0, plusIndex);
            return fromStartToPlus + fromAtToEnd;
        }
    }
}
