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
import trial.jsonparsingsimple.model.StudentModel;
import trial.jsonparsingsimple.model.StudentResponse;
import trial.jsonparsingsimple.webservice.StudentServiceClass;
import trial.jsonparsingsimple.webservice.StudentServiceInterface;

/**
 * Created by Vyas on 3/29/2016.
 */
public class RetrofitExample extends Activity implements View.OnClickListener {

    Button mStartBtn;
    StudentModel mStudentModel;
    StudentResponse mStudentResponse;
    List<StudentModel> studentListN;
    List<StudentModel> myStudentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_retrofit);
        mStartBtn=(Button)findViewById(R.id.btn_start);
        mStartBtn.setOnClickListener(this);
        myStudentList = new ArrayList<StudentModel>();
        studentListN =  new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                getStudentDetails();
                Toast.makeText(getApplicationContext(),"I am Pressed",Toast.LENGTH_LONG).show();
                 break;
        }
    }

    public void getStudentDetails(){
        StudentServiceInterface studentServiceInterface = StudentServiceClass.connection();
        Call<StudentResponse> call=studentServiceInterface.getDetails();
        call.enqueue(new Callback<StudentResponse>() {
            @Override
            public void onResponse(Response<StudentResponse> response, Retrofit retrofit) {
                if(response.isSuccess()){
                    mStudentResponse=response.body();
                    studentListN=mStudentResponse.getStudents();
                    printStudentDetails(studentListN);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.d("################","Failure MEssage");
                Log.d("MEssage",t.getMessage());
            }
        });
    }
    public void printStudentDetails(List<StudentModel> myStudentList){
        Log.d("#############","$$$$$$$$$$$$$");
        for(StudentModel studentModel:myStudentList){
            Log.d("Name : ",studentModel.getName());
            Log.d("Age : ",studentModel.getAge());
        }
    }
}
