package np.com.healthcareapp.remote;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ocemservice {

    @POST("/login")
    Call<apiutils> postLogin(@Body apiutils apiutils);
}