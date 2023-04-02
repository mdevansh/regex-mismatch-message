package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Example input email address with invalid format
        String email = "invalid.email@address!";

        // Example regular expression for email validation with alphanumeric and @ symbol only
        String patternStr = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";

        // Generate custom error message based on regular expression
        String errorMessage = generateErrorMessage(email, patternStr);

        // Display error message if it is not null
        if (errorMessage != null) {
            System.out.println(errorMessage);

        }
    }


    public static String generateErrorMessage(String input, String patternStr) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {


            Set aa = new HashSet();
            HashMap zz = new HashMap();
            zz.put("A-Z", "uppercase");
            zz.put("a-z", "lowercase");
            zz.put("0-9", "numbers");
            String allowedChars = patternStr
//                    .replaceAll("[^\\w\\s]", "")
                    ;
//            Extract allowed characters from pattern

            Set as = new HashSet();

            zz.keySet()
                    .forEach(a -> {
                        if (StringUtils.contains(allowedChars, (String) a)) {
                            aa.add(zz.get(a));
                            StringUtils.replace((String) a, allowedChars, "");
                        }
                    });

            Stream.of(allowedChars).forEach(a -> aa.add(a));


            boolean a = false, b, c = false;

//            if(StringUtils.contains(allowedChars, "A-Z"))
//                a= true;
//
//            if(a)
//                aa.add("Uppercase alphabets");
            return String.format("Invalid input format. Please enter a value containing only %s",
                    String.join(", ", aa));
        } else {
            return null; // Return null if input matches pattern
        }
    }
}