package np.com.healthcareapp.remote;

public class apiutils {

    public static final String BASE_URL = " https://4221-2400-1a00-bc10-7487-95e3-85b-f94a-180c.ngrok-free.app/api/";

    public static  ocemservice getocemservice(){

        return retrofitclient.getClient(BASE_URL).create(ocemservice.class);
    }
}
