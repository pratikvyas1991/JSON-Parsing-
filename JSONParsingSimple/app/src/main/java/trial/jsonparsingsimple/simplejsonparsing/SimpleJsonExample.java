package trial.jsonparsingsimple.simplejsonparsing;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONObject;

import trial.jsonparsingsimple.R;

/**
 * Created by Vyas on 3/20/2016.
 */
public class SimpleJsonExample extends Activity {

    //InInitialization of Widgets

    Button  btnStart;

    //A simple JSON Object Named Employee

    public static final String JSON_STRING="{\"employee\":{\"name\":\"Sachin\",\"salary\":56000}}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_json_parsing);
        btnStart=(Button)findViewById(R.id.btnSimpleJsonStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"Start button Clicked !!!",Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonObjectEmployee = (new JSONObject(JSON_STRING)).getJSONObject("employee");
//                    jsonObjectEmployee
                    String empName = jsonObjectEmployee.getString("name");
                    int empSalary = jsonObjectEmployee.getInt("salary");
                    Log.d("@@@@@@@@@@@@@@@@", "**************");
                    Log.d("Name : ", empName);
                    Log.d("Salary : ", String.valueOf(empSalary));
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
//                try{
//                    JSONObject emp=(new JSONObject(JSON_STRING)).getJSONObject("employee");
//                    String empname=emp.getString("name");
//                    int empsalary=emp.getInt("salary");
//
//                    String str="Employee Name:"+empname+"\n"+"Employee Salary:"+empsalary;
//                    Log.d("###########","$$$$$$$$$$$$$$$$$$$$");
//                    Log.d("value",str);
//
//                }catch (Exception e) {e.printStackTrace();}
//            }
            }
        });

    }
}
