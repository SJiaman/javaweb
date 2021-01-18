package edu.gzu.lms.entity;

import java.sql.Date;

public class Reader {
    private int readerId;
    private String readerName;
    private String sex;
    private Date birth;
    private String address;
    private String phone;
    private String password;

    public Reader() {
    }

    public Reader(int readerId, String readerName, String sex, Date birth, String address, String phone,String password) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.sex = sex;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
        this.password = password;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ReaderInfo{" +
                "readerId=" + readerId +
                ", readerName='" + readerName + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
