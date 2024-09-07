package np.com.healthcareapp.service;

import np.com.healthcareapp.remote.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostOTP {


    @POST("/api/email-verification")
    Call<UserModel> postOTP(@Body UserModel userModel);
}

