package trial.jsonparsingsimple.webservice;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import trial.jsonparsingsimple.model.GeonameResponse;
import trial.jsonparsingsimple.model.StudentModel;
import trial.jsonparsingsimple.model.StudentResponse;

/**
 * Created by Vyas on 3/28/2016.
 */
public interface StudentServiceInterface {
    @GET(HttpConstants.DETAILS_URL)
    Call<StudentResponse>getDetails();

    @GET(HttpConstants.CITIESJSON)
    Call<GeonameResponse>getCities(@Query("north")double north,@Query("south")double south,@Query("east")double east,@Query("west")double west,@Query("lang")String lang,@Query("username")String username);
}