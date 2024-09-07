package np.com.healthcareapp.service;

import np.com.healthcareapp.model.MyBookingModel;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface MyBooking {


    @GET("/api/mybookings")
    Call<MyBookingModel> getDoctors(@Header("Authorization") String token);
    @DELETE("/api/appointment/{id}")
    Call<MyBookingModel> deleteAppointment(@Header("Authorization") String token, @Path("id") String id);
}
