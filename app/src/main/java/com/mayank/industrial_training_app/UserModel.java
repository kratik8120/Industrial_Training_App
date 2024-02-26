package com.mayank.industrial_training_app;

import java.io.Serializable;

public class UserModel implements Serializable {

    String S_name,S_roll_no,S_Mode,S_Url,S_Section,S_Project,S_Technology,S_Organisation,S_Phone
            ,S_duration;

    public UserModel() {
    }

    public UserModel(String s_name, String s_roll_no, String s_Mode, String s_Url, String s_Section, String s_Project, String s_Technology, String s_Organisation, String s_Phone, String s_duration) {
        S_name = s_name;
        S_roll_no = s_roll_no;
        S_Mode = s_Mode;
        S_Url = s_Url;
        S_Section = s_Section;
        S_Project = s_Project;
        S_Technology = s_Technology;
        S_Organisation = s_Organisation;
        S_Phone = s_Phone;
        S_duration = s_duration;
    }

    public String getS_name() {
        return S_name;
    }

    public String getS_roll_no() {
        return S_roll_no;
    }

    public String getS_Mode() {
        return S_Mode;
    }

    public String getS_Url() {
        return S_Url;
    }

    public String getS_Section() {
        return S_Section;
    }

    public String getS_Project() {
        return S_Project;
    }

    public String getS_Technology() {
        return S_Technology;
    }

    public String getS_Organisation() {
        return S_Organisation;
    }

    public String getS_Phone() {
        return S_Phone;
    }

    public String getS_duration() {
        return S_duration;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public void setS_roll_no(String s_roll_no) {
        S_roll_no = s_roll_no;
    }

    public void setS_Mode(String s_Mode) {
        S_Mode = s_Mode;
    }

    public void setS_Url(String s_Url) {
        S_Url = s_Url;
    }

    public void setS_Section(String s_Section) {
        S_Section = s_Section;
    }

    public void setS_Project(String s_Project) {
        S_Project = s_Project;
    }

    public void setS_Technology(String s_Technology) {
        S_Technology = s_Technology;
    }

    public void setS_Organisation(String s_Organisation) {
        S_Organisation = s_Organisation;
    }

    public void setS_Phone(String s_Phone) {
        S_Phone = s_Phone;
    }

    public void setS_duration(String s_duration) {
        S_duration = s_duration;
    }
}
