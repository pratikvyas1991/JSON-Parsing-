package trial.jsonparsingsimple.webservice;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Interceptor;
import java.io.IOException;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Vyas on 3/28/2016.
 */
public class StudentServiceClass {

    static StudentServiceInterface mStudentServiceInterface;

    public static final String mBaseUrl=HttpConstants.BASE_URL_GEONAME;

    public static StudentServiceInterface connection(){
        if(mStudentServiceInterface==null){
            HttpLoggingInterceptor mHttpLoggingInterceptor=new HttpLoggingInterceptor();
            mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient mOkHttpClient = new OkHttpClient();
            mOkHttpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response=chain.proceed(chain.request());
                    return response;
                }
            });
            Retrofit mRetrofit = new Retrofit.Builder()
                    .client(mOkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(mBaseUrl)
                    .build();
            mStudentServiceInterface = mRetrofit.create(StudentServiceInterface.class);
        }
        return mStudentServiceInterface;
    }
}
