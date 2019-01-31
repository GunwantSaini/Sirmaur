package gtconline.test.sirmaur.Ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import gtconline.test.sirmaur.Pojo.AboutInfo;
import gtconline.test.sirmaur.Adapter.AboutInfoAdapter;
import gtconline.test.sirmaur.R;

public class AboutAcitvity extends AppCompatActivity {

    ArrayList<AboutInfo> aboutInfoList;
    RecyclerView mainRv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_acitvity);

        aboutInfoList=new ArrayList<>();

        fillAboutList();

        mainRv = findViewById(R.id.main_rv);
        mainRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mainRv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mainRv.setAdapter(new AboutInfoAdapter(aboutInfoList));

    }



    public void fillAboutList()
    {
        aboutInfoList.add(new AboutInfo("Origin","About the origin of the name, “Sirmaur” there are quite a few surmises.  One view being that the state derived its name as Sirmaur because of the   senior position it held amongst the princely hill states. Another version is that at the earliest times the   capital of the state was at Sirmaur and the state was so called after the name of the capital. But, how the word Sirmaur originated is not known. Third version being that the  state was  founded by  Raja  Rasaloo of Jaisalmer whose one of the  ancestor’s  name was Sirmaur and who belonged to Rasaloo family.  Beyond this, nothing definite is traceable."));
        aboutInfoList.add(new AboutInfo("Legends of Sirmaur","The legend goes that during the earliest history of Sirmaur State when Raja Madan Singh used to rule, a woman knowing necromancy presented before the Raja and talked about her acrobatic skill.  Raja being susceptible about it, promised her half of his kingdom  if she displayed her skill by crossing over the river Giri by means of acrobatic rope.   To his surprise, she succeeded in crossing and when she was returning on the rope one of the courtiers of the Raja feeling apprehensive, cut the rope and consequently the woman was drowned in the river.  This treachery on the part of Raja resulted in a flood, which swept the town, and the entire princely family perished leaving the state without a ruler.  "));

    }


}
