package com.school.registration.constant;

/**
 * @author Md Tofazzal Hossain
 * @created on 27/01/2022
 */

public final class AppConstant {

    private AppConstant() {
    }

    public static final String API_VERSION = "v1";
    public static final String API_REVISION = "1.0";


    public static final String STUDENT_SAVE_SUCCESS = "Student saved successfully.";
    public static final String STUDENT_UPDATE_SUCCESS = "Student updated successfully.";
    public static final String STUDENT_FETCH_SUCCESS = "Student fetched successfully.";
    public static final String STUDENT_DELETE_SUCCESS = "Student deleted successfully.";
    public static final String STUDENT_NOT_FOUND = "Student not found with the id: ";
    public static final String STUDENT_CODE_ALREADY_EXIST = "Student already exist with the code: ";


    public static final String COURSE_SAVE_SUCCESS = "Course saved successfully.";
    public static final String COURSE_UPDATE_SUCCESS = "Course updated successfully.";
    public static final String COURSE_FETCH_SUCCESS = "Course fetched successfully.";
    public static final String COURSE_DELETE_SUCCESS = "Course deleted successfully.";
    public static final String COURSE_NOT_FOUND = "Course not found with the id: ";
    public static final String COURSE_CODE_ALREADY_EXIST = "Course already exist with the code: ";


    public static final String COURSE_STUDENT_SAVE_SUCCESS = "Course student saved successfully.";
    public static final String COURSE_STUDENT_UPDATE_SUCCESS = "Course student updated successfully.";
    public static final String COURSE_STUDENT_FETCH_SUCCESS = "Course student fetched successfully.";
    public static final String COURSE_STUDENT_DELETE_SUCCESS = "Course student deleted successfully.";
    public static final String COURSE_STUDENT_NOT_FOUND = "Course not found with the id: ";
    public static final String COURSE_CODE_ALREADY_EXIST_FOR_THE_STUDENT = "Course code already exist.";
    public static final String COURSE_NAME_ALREADY_EXIST_FOR_THE_STUDENT = "Course name already exist.";
    public static final String COURSE_ALREADY_EXIST_FOR_THE_STUDENT = "Course already exist for the student.";
    public static final String ONE_STUDENT_COULD_NOT_REGISTER_MORE_THAN_FIVE_COURSES = "One student could not register more than five courses!";
    public static final String ONE_COURSE_COULD_NOT_REGISTER_MORE_THAN_FIFTY_STUDENTS = "One student could not register more than five courses!";


    public static final String MAIL_EXCEPTION = "Exception => ";

}
