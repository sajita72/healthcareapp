package np.com.healthcareapp.model;

public class AppointmentModel {



    private String token,success,name,age,address, user_id, doctor_id, doctor_name, doctor_specialist,doctor_image, date_appointment, time_appointment, id, error;

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public AppointmentModel() {
    }

    public AppointmentModel(String token, String success, String name, String age, String address, String user_id, String doctor_id, String doctor_name, String doctor_specialist, String doctor_image, String date_appointment, String time_appointment, String id) {
        this.token = token;
        this.success = success;
        this.name = name;
        this.age = age;
        this.address = address;
        this.user_id = user_id;
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.doctor_specialist = doctor_specialist;
        this.doctor_image = doctor_image;
        this.date_appointment = date_appointment;
        this.time_appointment = time_appointment;
        this.id = id;
    }

    public AppointmentModel(String token, String success, String name, String age, String address, String user_id, String doctor_id, String doctor_name, String doctor_specialist, String doctor_image, String date_appointment, String time_appointment, String id, String error) {
        this.token = token;
        this.success = success;
        this.name = name;
        this.age = age;
        this.address = address;
        this.user_id = user_id;
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.doctor_specialist = doctor_specialist;
        this.doctor_image = doctor_image;
        this.date_appointment = date_appointment;
        this.time_appointment = time_appointment;
        this.id = id;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_specialist() {
        return doctor_specialist;
    }

    public void setDoctor_specialist(String doctor_specialist) {
        this.doctor_specialist = doctor_specialist;
    }

    public String getDoctor_image() {
        return doctor_image;
    }

    public void setDoctor_image(String doctor_image) {
        this.doctor_image = doctor_image;
    }

    public String getDate_appointment() {
        return date_appointment;
    }

    public void setDate_appointment(String date_appointment) {
        this.date_appointment = date_appointment;
    }

    public String getTime_appointment() {
        return time_appointment;
    }

    public void setTime_appointment(String time_appointment) {
        this.time_appointment = time_appointment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }









}
