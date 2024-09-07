package np.com.healthcareapp.model;

import java.util.ArrayList;

public class DoctorModel {
    String status;


    ArrayList<Doctors> doctors;

    public DoctorModel() {
    }

    public DoctorModel(String status, ArrayList<Doctors> doctors) {
        this.status = status;
        this.doctors = doctors;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctors> doctors) {
        this.doctors = doctors;
    }

    public class Doctors {
        String id, name, specialist, description, image, appointment_time;

        public Doctors() {
        }

        public Doctors(String id, String name, String specialist, String description, String image, String appointment_time) {
            this.id = id;
            this.name = name;
            this.specialist = specialist;
            this.description = description;
            this.image = image;
            this.appointment_time = appointment_time;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getAppointment_time() {
            return appointment_time;
        }

        public void setAppointment_time(String appointment_time) {
            this.appointment_time = appointment_time;
        }
    }
}
