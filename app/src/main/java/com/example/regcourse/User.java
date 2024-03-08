package com.example.regcourse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private static final String REGISTRATION_NUMBER_PATTERN = "^[A-Za-z]{1}\\d{3}-\\d{2}-\\d{4}/\\d{4}$";
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.dkut\\.ac\\.ke$";

    private String registrationNumber;
    private String name;
    private String email;
    private List<String> courses;
    private Map<String, Integer> marks;
    // Add an empty constructor for Firebase
    public User() {
    }

    public User(String registrationNumber, String name, String email, List<String> courses) {
        validateRegistrationNumber(registrationNumber);
        validateEmail(email);

        this.registrationNumber = registrationNumber;
        this.name = name;
        this.email = email;
        this.courses = courses;
        this.marks = new HashMap<>();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getCourses() {
        return courses;
    }
    public void addMark(String unit, int mark) {
        marks.put(unit, mark);
    }
    public Map<String, Integer> getMarks() {
        return marks;
    }


    public boolean isSameEmail(String otherEmail) {
        return email.equalsIgnoreCase(otherEmail);
    }

    private void validateRegistrationNumber(String registrationNumber) {
        Pattern pattern = Pattern.compile(REGISTRATION_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(registrationNumber);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid registration number format. Please follow the format C026-01-1039/2021");
        }
    }

    private void validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid email format. Please follow the format user@students.dkut.ac.ke");
        }
    }
}
