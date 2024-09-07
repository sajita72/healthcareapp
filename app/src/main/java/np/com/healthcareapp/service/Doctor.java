package np.com.healthcareapp.service;

import np.com.healthcareapp.model.DoctorModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Doctor {


    @GET("/api/doctors")
    Call<DoctorModel> getDoctor(@Header("Authorization") String token);
}
