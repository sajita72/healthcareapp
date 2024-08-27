package np.com.healthcareapp.service;

import np.com.healthcareapp.remote.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Login {

    @POST("/api/login")
    Call<UserModel> postLogin(@Body UserModel userModel);

}
