package com.bicubic.amusementpark.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.adapter.FragmentDrawer;
import com.bicubic.amusementpark.fragment.HomeFragment;
import com.bicubic.amusementpark.ride.RidesActivity;


public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        mTitle = (TextView) mToolbar.findViewById(R.id.tv_toolbar_title);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(20);
    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position+1);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 20:

                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                mTitle.setText(title);

                break;
           /* case 0:

                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                mTitle.setText(title);

                break;*/
            case 1:

                startActivity(new Intent(MainActivity.this, RidesActivity.class));

                break;
            case 2:

                startActivity(new Intent(MainActivity.this, GalleryReviewActivity.class));

                break;
            case 3:

                startActivity(new Intent(MainActivity.this, FoodBeveragesActivity.class));

                break;
            case 4:

                startActivity(new Intent(MainActivity.this, SelectDateActivity.class));

                break;
            case 5:

                startActivity(new Intent(MainActivity.this, ReferEarnActivity.class));

                break;
            case 6:

                startActivity(new Intent(MainActivity.this, HotOffersActivity.class));

                break;
            case 7:

                startActivity(new Intent(MainActivity.this, ContactusActivity.class));

                break;
            case 8:

                startActivity(new Intent(MainActivity.this, AboutusActivity.class));

                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
//            if (getSupportActionBar() != null)
//            getSupportActionBar().setTitle(title);
        }
    }
}