package gtconline.test.sirmaur.Ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import gtconline.test.sirmaur.Adapter.GridAdapter;
import gtconline.test.sirmaur.R;

public class ImpContacts extends AppCompatActivity {

    GridView impContactsView;
    ArrayList impContactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imp_contacts);

        impContactsView=findViewById(R.id.impContactsView);

        impContactsList=new ArrayList();

        fillImpContactsList();

        impContactsView.setAdapter(new GridAdapter(this,impContactsList));


    }

    public void fillImpContactsList()
    {
        impContactsList.add("Administration");
        impContactsList.add("Revenue Officers");
        impContactsList.add("Police Helpline");
        impContactsList.add("Medical Helpline");
        impContactsList.add("Fire Brigade");
        impContactsList.add("Filling Stations/Petrol Pumps");
        impContactsList.add("Panchayati Raj and Urban Rural Development");
        impContactsList.add("Forest Department");
        impContactsList.add("Education Department");
        impContactsList.add("IPH Department");
        impContactsList.add("PWD Department");
        impContactsList.add("Electricity Department");
        impContactsList.add("Other Department");

    }


}
