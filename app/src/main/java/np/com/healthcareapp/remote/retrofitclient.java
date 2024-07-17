package np.com.healthcareapp.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitclient {

    private static Retrofit retrofit = null;
    public static Retrofit getClient(String baseUrl){
        if (retrofit != null){
            if (retrofit.baseUrl().toString().equalsIgnoreCase(baseUrl)){
                return retrofit;
            }
        }

        retrofit = new Retrofit.Builder()
                .baseUrl("https://4221-2400-1a00-bc10-7487-95e3-85b-f94a-180c.ngrok-free.app/api/")
//                    .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
