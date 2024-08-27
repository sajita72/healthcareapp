package np.com.healthcareapp.service;

import np.com.healthcareapp.remote.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;



public interface Register {



    @POST("/api/register")
    Call<UserModel> postRegister(@Body UserModel userModel);
}


