package alhdo.xyz.ifiedt.UI.activities;

import android.os.Bundle;

import alhdo.xyz.ifiedt.R;
import alhdo.xyz.ifiedt.UI.fragments.CourseFragment;
import alhdo.xyz.ifiedt.UI.fragments.EdtFragment;
import alhdo.xyz.ifiedt.UI.fragments.PlacesFragment;
import alhdo.xyz.ifiedt.UI.fragments.TodayFragment;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new TodayFragment());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

    }

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.navigation_today:
                fragment = new TodayFragment();
            break;
            case R.id.navigation_edt:
                fragment = new EdtFragment();
                break;
            case R.id.navigation_course:
                fragment = new CourseFragment();
                break;
            case R.id.navigation_place:
                fragment = new PlacesFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
