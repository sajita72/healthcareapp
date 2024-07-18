
package np.com.healthcareapp.remote;

public class apiutils {

    private String status, token, user_name, password;


    public apiutils() {
    }

    public apiutils(String status, String token, String username, String password) {
        this.status = status;
        this.token = token;
        this.user_name = username;
        this.password = password;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setPhone_number(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}