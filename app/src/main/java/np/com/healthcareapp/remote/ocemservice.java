package np.com.healthcareapp.remote;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ocemservice {

    @POST("/register")
    Call<ResponseBody> validateregistration(
            @Query("user") String user,
            @Query("email") String email,
            @Query("password") String password
    );
}
