package gtconline.test.sirmaur.Ui.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import gtconline.test.sirmaur.Adapter.ImportantLinkAdapter;
import gtconline.test.sirmaur.Pojo.ImportntLinkInfo;
import gtconline.test.sirmaur.R;
import gtconline.test.sirmaur.RecyclerItemClickHandler;

public class ImportantLinks extends AppCompatActivity {

    RecyclerView impLinksView;

    ArrayList<ImportntLinkInfo> importntLinksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_links);

        impLinksView=findViewById(R.id.impLinksView);
        importntLinksList=new ArrayList<>();

        fillImportantLinks();

        impLinksView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        impLinksView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        impLinksView.setAdapter(new ImportantLinkAdapter(importntLinksList,this));


        RecyclerItemClickHandler.addTo(impLinksView).setOnItemClickListener(new RecyclerItemClickHandler.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + importntLinksList.get(position).getLinkName()));
                // Toast.makeText(context,"item called",Toast.LENGTH_SHORT).show();
                startActivity(browserIntent);
            }
        });

    }


    public void fillImportantLinks()
    {
        importntLinksList.add(new ImportntLinkInfo("www.mahamayabalasundariji.in"));
        importntLinksList.add(new ImportntLinkInfo("www.himachal.nic.in"));
        importntLinksList.add(new ImportntLinkInfo("www.edistrict.hp.gov.in"));
        importntLinksList.add(new ImportntLinkInfo("www.hpsirmaur.nic.in"));


    }

}
