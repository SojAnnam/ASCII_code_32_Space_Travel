package com.codecool.spacetravel.validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class RoomReservationDataValidator {

    public List<String> validateDates(String startDateStringFromUser, String endDateStringFromUser) {

        List<String> errorMessages = new ArrayList<>();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date startDateFromUser = dateformat.parse(startDateStringFromUser);
            Date endDateFromUser = dateformat.parse(endDateStringFromUser);

            String[] startDateElements = startDateStringFromUser.split("/");
            String startDateYear = startDateElements[0];
            String startDateMonth = startDateElements[1];
            String startDateDay = startDateElements[2];

            String[] endDateElements = endDateStringFromUser.split("/");
            String endDateYear = endDateElements[0];
            String endDateMonth = endDateElements[1];
            String endDateDay = endDateElements[2];

            if (startDateFromUser.after(endDateFromUser) || startDateFromUser.equals(endDateFromUser)){
                errorMessages.add("Start date must be earlier than end date.");
            }
            if (startDateFromUser.before(new Date())) {
                errorMessages.add("Start date must be later than current date.");
            }
            if (Integer.parseInt(startDateMonth) < 1 || Integer.parseInt(startDateMonth) > 12 ||
                    Integer.parseInt(endDateMonth) < 1 || Integer.parseInt(endDateMonth) > 12){
                errorMessages.add("Month must be greater than 0 and lesser than 13.");
            }

            int maxDay = 0;
            String[] longMonths = {"01", "03", "05", "07", "08", "10", "12"};
            if (Arrays.asList(longMonths).contains(startDateMonth)) {
                maxDay = 31;
            } else if (startDateDay.equals("02")){
                maxDay = 28;
            } else {
                maxDay = 30;
            }

            if (Integer.parseInt(startDateDay) < 1 ||
                    Integer.parseInt(startDateDay) > maxDay){
                errorMessages.add("Day in start date should be between 1 and " + maxDay + ".");
            }

            if (Arrays.asList(longMonths).contains(endDateMonth)) {
                maxDay = 31;
            } else if (endDateDay.equals("02")){
                maxDay = 28;
            } else {
                maxDay = 30;
            }

            if (Integer.parseInt(endDateDay) < 1 ||
                    Integer.parseInt(endDateDay) > maxDay){
                errorMessages.add("Day in end date should be between 1 and " + maxDay + ".");
            }

        } catch (Exception e){
            errorMessages.add("Invalid date format.");
        }

        return errorMessages;
    }

}
