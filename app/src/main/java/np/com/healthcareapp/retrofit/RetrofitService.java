
package np.com.healthcareapp.retrofit;


        import android.content.Context;

        import com.chuckerteam.chucker.api.ChuckerInterceptor;

        import okhttp3.OkHttpClient;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static Retrofit retrofit = null;
    private static final String base_url = "https://eb33-36-252-104-156.ngrok-free.app/";

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


