package gtconline.test.sirmaur.Ui.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.HashMap;

import gtconline.test.sirmaur.R;
import gtconline.test.sirmaur.WhereToStay;

public class HomeAvitvity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    ImageView originImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_avitvity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        originImage=findViewById(R.id.aboutImage);

        Bitmap icon = BitmapFactory.decodeResource(getResources(),
                R.drawable.nahan11);

        originImage.setImageBitmap(adjustedContrast(icon,-15));




        fillImagesHorizontalScroll();

    }


    public void fillImagesHorizontalScroll()
    {
        int images[]={R.drawable.nahan1,R.drawable.nahan2,R.drawable.nahan3,R.drawable.nahan4,R.drawable.nahan5,R.drawable.nahan6,R.drawable.nahan7,R.drawable.nahan8,R.drawable.nahan8,R.drawable.nahan10};
        LinearLayout layout = findViewById(R.id.linear_images);
        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(800,600
            );
            imageView.setLayoutParams(params);
            imageView.setMaxHeight(20);
            imageView.setMaxWidth(20);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(),images[i]));
         //   imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            layout.addView(imageView);
        }
    }


    private Bitmap adjustedContrast(Bitmap src, double value) {
        // image size
        int width = src.getWidth();
        int height = src.getHeight();
        // create output bitmap

        // create a mutable empty bitmap
        Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());

        // create a canvas so that we can draw the bmOut Bitmap from source bitmap
        Canvas c = new Canvas();
        c.setBitmap(bmOut);

        // draw bitmap to bmOut from src bitmap so we can modify it
        c.drawBitmap(src, 0, 0, new Paint(Color.BLACK));


        // color information
        int A, R, G, B;
        int pixel;
        // get contrast value
        // get contrast value
        double contrast = Math.pow((100 + value) / 100, 2);

        // scan through all pixels
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                // get pixel color
                pixel = src.getPixel(x, y);
                A = Color.alpha(pixel);
                // apply filter contrast for every channel R, G, B
                R = Color.red(pixel);
                R = (int) (((((R / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if (R < 0) {
                    R = 0;
                } else if (R > 255) {
                    R = 255;
                }

                G = Color.green(pixel);
                G = (int) (((((G / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if (G < 0) {
                    G = 0;
                } else if (G > 255) {
                    G = 255;
                }

                B = Color.blue(pixel);
                B = (int) (((((B / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                if (B < 0) {
                    B = 0;
                } else if (B > 255) {
                    B = 255;
                }

                // set new pixel color to output bitmap
                bmOut.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }
        return bmOut;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            startActivity(new Intent(HomeAvitvity.this,AboutAcitvity.class));
        } else if (id == R.id.nav_howToReach) {
            
            startActivity(new Intent(HomeAvitvity.this,HowToReachActivity.class));

        } else if (id == R.id.nav_whereToStay) {

            startActivity(new Intent(HomeAvitvity.this,WhereToStay.class));

        } else if (id == R.id.nav_impContacts) {

            startActivity(new Intent(HomeAvitvity.this,ImpContacts.class));

        } else if (id == R.id.nav_excursions) {

            startActivity(new Intent(HomeAvitvity.this,Excursions.class));

        } else if (id == R.id.nav_gallery) {

            startActivity(new Intent(HomeAvitvity.this,GalleryActivity.class));
        }
        else if(id==R.id.nav_impLinks){
            startActivity(new Intent(HomeAvitvity.this,ImportantLinks.class));
        }
        else if(id == R.id.nav_publicGrievance)
        {
            startActivity(new Intent(HomeAvitvity.this,PublicGrievance.class));
        }

        else if(id==R.id.nav_admin)
        {
            startActivity(new Intent(HomeAvitvity.this,AdminLogin.class));
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
