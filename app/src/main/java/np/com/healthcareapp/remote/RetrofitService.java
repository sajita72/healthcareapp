
package np.com.healthcareapp.remote;

import android.content.Context;

import com.chuckerteam.chucker.api.ChuckerInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static Retrofit retrofit = null;
    private static final String base_url = "https://4221-2400-1a00-bc10-7487-95e3-85b-f94a-180c.ngrok-free.app/api/";


    private RetrofitService() {}

    public static Retrofit getService(Context context) {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new ChuckerInterceptor(context))
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
