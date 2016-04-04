package trial.jsonparsingsimple.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import trial.jsonparsingsimple.R;
import trial.jsonparsingsimple.model.GeonameModel;
import trial.jsonparsingsimple.model.GeonameResponse;
import trial.jsonparsingsimple.webservice.StudentServiceClass;
import trial.jsonparsingsimple.webservice.StudentServiceInterface;

/**
 * Created by Vyas on 4/3/2016.
 */
public class RestrofitGeoNames extends Activity implements View.OnClickListener {
    Button mStartBtn;
    GeonameResponse mGeonameResponse;
    List<GeonameModel> cityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.layout_retrofit);
        mStartBtn=(Button)findViewById(R.id.btn_start);
        mStartBtn.setOnClickListener(this);
        super.onCreate(savedInstanceState);
        cityList = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                Toast.makeText(getApplicationContext(),"I Am Clicked ",Toast.LENGTH_LONG).show();
                getCities();
                break;
        }
    }
    public void temp(){
        Log.d("Hello ","There");
    }
    public void getCities(){
        StudentServiceInterface studentServiceInterface = StudentServiceClass.connection();
        Call<GeonameResponse> call = studentServiceInterface.getCities(44.1,-9.9,-22.4,55.2,"de","demo");
        call.enqueue(new Callback<GeonameResponse>() {
            @Override
            public void onResponse(Response<GeonameResponse> response, Retrofit retrofit) {
                if(response.isSuccess()){
                    mGeonameResponse = response.body();
                    cityList=mGeonameResponse.getGeonames();
                    printCityDetails(cityList);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.d("@@@@@@@@@@","##########");
                Log.d("Error : ",t.getMessage());
            }
        });
    }
    public void printCityDetails(List<GeonameModel> mycityList){
        Log.d("@@@@@---Sucess----@@@@","@@@--Response--@@");
        for (GeonameModel model:mycityList){
            Log.d("geo Name ID : ",model.getGeonameId().toString());
            Log.d("country Code : ",model.getCountrycode());
            Log.d("Topony Name : ",model.getToponymName());
        }
    }
}
