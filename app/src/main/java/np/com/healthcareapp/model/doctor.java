package np.com.healthcareapp.model;

public class doctor {
    private String name;

    private String speciality;

    private String degree;

    private String image;

    private  String description;

    private String price;

    private String location;

    private String number;




    public doctor(String name, String speciality, String degree, String image, String description, String price, String location, String number) {
        this.name = name;
        this.speciality = speciality;
        this.degree = degree;
        this.image = image;
        this.description = description;
        this.price = price;
        this.location = location;
        this.number = number;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}