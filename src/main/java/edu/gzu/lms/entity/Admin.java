package edu.gzu.lms.entity;

public class Admin {
    private int adminId;
    private String password;
    private String username;

    public Admin() {
    }

    public Admin(int adminId, String password, String username) {
        this.adminId = adminId;
        this.password = password;
        this.username = username;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
