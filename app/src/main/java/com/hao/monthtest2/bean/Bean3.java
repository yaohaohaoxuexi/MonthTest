package com.hao.monthtest2.bean;

/**
 * Created by Administrator on 2016-11-27.
 */

public class Bean3 {
    private String courseName;
    private String grade;
    private String onlineTime;
    private String teacherAvatar;
    private String teacherName;
    private int registerStudentNum;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getTeacherAvatar() {
        return teacherAvatar;
    }

    public void setTeacherAvatar(String teacherAvatar) {
        this.teacherAvatar = teacherAvatar;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getRegisterStudentNum() {
        return registerStudentNum;
    }

    public void setRegisterStudentNum(int registerStudentNum) {
        this.registerStudentNum = registerStudentNum;
    }

    public Bean3(String courseName, String grade, String onlineTime, String teacherAvatar, String teacherName, int registerStudentNum) {
        this.courseName = courseName;
        this.grade = grade;
        this.onlineTime = onlineTime;
        this.teacherAvatar = teacherAvatar;
        this.teacherName = teacherName;
        this.registerStudentNum = registerStudentNum;
    }

    public Bean3() {
        super();
    }
}
