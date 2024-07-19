package np.com.healthcareapp.model;

public class doctor {
    private String name;

    private String speciality;

    private String degree;

    private String image;

    private String description;




    public doctor(String name, String speciality, String degree, String image, String description) {
        this.name = name;
        this.speciality = speciality;
        this.degree = degree;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public String getDescription() {return description;}

    public void setDescription(String description) { this.description = description;}

}
