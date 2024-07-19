
package np.com.healthcareapp.remote;

    public class apiutils {

        private String status, token, email, password;


        public apiutils() {
        }

        public apiutils(String status, String token, String email, String password) {
            this.status = status;
            this.token = token;
            this.email = email;
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
            return email;
        }

        public void setPhone_number(String user_name) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
