package trial.jsonparsingsimple.simplejsonparsing;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import trial.jsonparsingsimple.R;

/**
 * Created by Vyas on 3/20/2016.
 */
public class JSONFromAssetsFile extends Activity {
    Button startAssestFileBtn;
    StringBuilder rowStudents=new StringBuilder();
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_json_parsing);
        startAssestFileBtn = (Button) findViewById(R.id.btnSimpleJsonStart);
        startAssestFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("**************","&&&&&&&&&&");
//                Log.d("String Value : ",getJSONFromAssest());
                  final String jsonInput=getJSONFromAssest();
                  try {
//                      JSONObject jsonObject= new JSONObject(jsonInput);
                      JSONArray jsonArray= new JSONArray(jsonInput);
                      Log.d("Length of An Array : ",String.valueOf(jsonArray.length()));
                      Log.d("Values::::::::::","##########");
//                     ArrayList<ArrayList<String>> studentList= new ArrayList();
                      for(int i=0;i<jsonArray.length();i++){

                              JSONObject jsonObject=jsonArray.getJSONObject(i);
                          String name=jsonObject.getString("Name");
                          String id=String.valueOf(jsonObject.getInt("Id"));
                          Log.d("ID : ",id);
                          Log.d("Name : ",name);
                      }
//                      for (String value:studentList){
//                          Log.d(" Name ",value);
//                      }
                  }catch (Exception ar){
                      ar.printStackTrace();
                  }
            }
        });
      }
        public String getJSONFromAssest(){
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("student_information.json")));
                String dataStudents;
                while ((dataStudents = bufferedReader.readLine()) != null) {
                    rowStudents.append(dataStudents);
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }finally {
                try {
                    bufferedReader.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            return rowStudents.toString();
    }
}
