package np.com.healthcareapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MyBookingModel {
    ArrayList<Message> message;
    String success;
    String error;
    public MyBookingModel() {
    }

    public MyBookingModel(ArrayList<Message> message, String success, String error) {
        this.message = message;
        this.success = success;
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public MyBookingModel(ArrayList<Message> message) {
        this.message = message;
    }

    public ArrayList<Message> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<Message> message) {
        this.message = message;
    }

    public class Message{
        String id,doctor_name,date_appointment,time_appointment;
        Doctor doctor;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDoctor_name() {
            return doctor_name;
        }

        public void setDoctor_name(String doctor_name) {
            this.doctor_name = doctor_name;
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


        public Message(String id, String doctor_name, String date_appointment, String time_appointment){
            this.id = id;
            this.doctor_name = doctor_name;
            this.date_appointment = date_appointment;
            this.time_appointment = time_appointment;
        }




        public Doctor getDoctor() {
            return doctor;
        }
        public void setDoctor(Doctor doctor) {
            this.doctor = doctor;
        }


        public class Doctor{
            String id,name,specialist,description;

            public Doctor(String id, String name, String specialist, String description) {
                this.id = id;
                this.name = name;
                this.specialist = specialist;
                this.description = description;
            }

            public String getId() {
                return id;
            }


            public void setId(String id) {
                this.id = id;
            }




            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSpecialist() {
                return specialist;
            }

            public void setSpecialist(String specialist) {
                this.specialist = specialist;
            }
        }
    }


}
