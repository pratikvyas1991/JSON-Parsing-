package trial.jsonparsingsimple.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import trial.jsonparsingsimple.R;

/**
 * Created by Vyas on 3/21/2016.
 */
public class AsyncTaskSimpleExample extends Activity {
    Button mStartBtn;
    TextView mMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_task);
        mMessage=(TextView)findViewById(R.id.tv_async_message);
    }
    private class BackGroundWork extends AsyncTask<Integer,Integer,Integer>{
        @Override
        protected Integer doInBackground(Integer... params) {
            Toast.makeText(getApplicationContext(),"Hello Miss ME ",Toast.LENGTH_LONG).show();
            return null;
        }
    }
}
