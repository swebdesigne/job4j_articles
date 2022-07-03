package ood.dip;

public class User {
    private int id;
    private String userName;
    private String pswd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", userName='" + userName + '\''
                + ", pswd='" + pswd + '\''
                + '}';
    }
}
