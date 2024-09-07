
package np.com.healthcareapp.retrofit;


        import android.content.Context;

        import com.chuckerteam.chucker.api.ChuckerInterceptor;

        import okhttp3.OkHttpClient;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static Retrofit retrofit = null;
    private static final String base_url = "https://63ed-2400-1a00-b070-ce7b-ec22-5206-f3e9-4e4d.ngrok-free.app/";

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


