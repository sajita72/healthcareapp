package np.com.healthcareapp.service;

import np.com.healthcareapp.model.AppointmentModel;
import np.com.healthcareapp.remote.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Booking {


    @POST("/api/appointment")
    Call<AppointmentModel> postBooking(@Body AppointmentModel appointmentModel);

    @POST("/api/appointment")
    Call<AppointmentModel> postAppointment(@Header("Authorization") String token, @Body AppointmentModel appointmentModel);

}
