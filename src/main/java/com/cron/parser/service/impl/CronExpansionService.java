package com.cron.parser.service.impl;

import java.util.*;

public class CronExpansionService {

    public static String expandCron(String input, int minValue, int maxValue) {
        StringBuilder result = new StringBuilder();
        String[] specificInputs = input.split(",");
        Set<Integer> resultSet = new HashSet<>();

        for(String specificInput : specificInputs) {
            Set<Integer>  set = expandIndividualExpression(specificInput, minValue, maxValue);
            resultSet.addAll(set);
        }

        List<Integer> list = new ArrayList<>(resultSet);
        Collections.sort(list);

        for(Integer num : list) {
            result.append(num + " ");
        }

        return result.toString().trim();
    }

    private static Set<Integer> expandIndividualExpression(String input, int minValue, int maxValue) {
        Set<Integer> set = new HashSet<>();

        int dividerIndex = input.indexOf("/");
        int divider = 1;
        if(dividerIndex != -1) {
            divider = Integer.parseInt(input.substring(dividerIndex+1));
            input = input.substring(0, dividerIndex);
        }

        int hyphenIndex = input.indexOf("-");
        if(hyphenIndex != -1) {
            String[] dividedInput = input.split("-");
            minValue = Integer.parseInt(dividedInput[0]);
            maxValue = Integer.parseInt(dividedInput[1]);
        }

        // for range inputs
        if(input.equals("*") || hyphenIndex != -1) {
            while(minValue<=maxValue) {
                if(dividerIndex == -1 || (minValue % divider) == 0) {
                    set.add(minValue);
                }
                minValue++;
            }
        } else if(dividerIndex != -1) {
            minValue = Integer.parseInt(input.substring(0,dividerIndex));
            while(minValue<=maxValue) {
                if((minValue % divider) == 0) {
                    set.add(minValue);
                }
                minValue++;
            }
        } else {
            set.add(Integer.parseInt(input));
        }

        return set;
    }

}
