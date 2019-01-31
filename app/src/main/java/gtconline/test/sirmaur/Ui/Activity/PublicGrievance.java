
package gtconline.test.sirmaur.Ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import gtconline.test.sirmaur.R;

public class PublicGrievance extends AppCompatActivity {

    TextView showInfo;
    EditText numberEt,emailEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_gr);


        showInfo=findViewById(R.id.showInfoEt);

        numberEt=findViewById(R.id.numberEt);

        emailEt=findViewById(R.id.emailEt);




    }
}
