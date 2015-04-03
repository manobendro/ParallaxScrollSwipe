package parallax.scroll.swipe.effect;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;

import parallax.scroll.swipe.effect.adapter.ViewPagerAdapter;
import parallax.scroll.swipe.effect.fragment.CityFragment;
import parallax.scroll.swipe.effect.model.City;


public class MainActivity extends FragmentActivity implements CityFragment.OnFragmentInteractionListener {

    private ViewPager pager;

    private ArrayList<Fragment> fragments = new ArrayList<>();

    private ArrayList<City> cityList = new ArrayList<>();

    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList.add(new City("London", getString(R.string.london), R.drawable.london));
        cityList.add(new City("Bangkok", getString(R.string.bangkok), R.drawable.bangkok));
        cityList.add(new City("Paris", getString(R.string.paris), R.drawable.paris));
        cityList.add(new City("Singapore", getString(R.string.singapore), R.drawable.singapore));
        cityList.add(new City("New York", getString(R.string.newyork), R.drawable.newyork));
        cityList.add(new City("Istanbul", getString(R.string.istanbul), R.drawable.istanbul));
        cityList.add(new City("Hong kong", getString(R.string.hongkong), R.drawable.hongkong));
        cityList.add(new City("Barcelona", getString(R.string.barcelona), R.drawable.barcelona));
        cityList.add(new City("Amsterdam", getString(R.string.amsterdam), R.drawable.amsterdam));
        cityList.add(new City("Rome", getString(R.string.rome), R.drawable.rome));
        cityList.add(new City("Vienna", getString(R.string.vienna), R.drawable.vienna));
        cityList.add(new City("Milan", getString(R.string.milan), R.drawable.milan));


        pager = (ViewPager) findViewById(R.id.viewpager);

        for(int i= 0; i< 12; i++) {
            CityFragment fragment = CityFragment.newInstance(cityList.get(i));
            fragments.add(fragment);
        }

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                Fragment fragment = adapter.getRegisteredFragment(i);

                View view = fragment.getView().findViewById(R.id.imageView);

                if (view != null) {
                    view.setTranslationX(i2 / 2);
                }

                Fragment fragment2 = adapter.getRegisteredFragment(i+1);

                if(fragment2!=null) {

                    View view2 = fragment2.getView().findViewById(R.id.imageView);

                    if (view2 != null) {
                        view2.setTranslationX(-(view.getWidth() - i2) / 2);
                    }
                }


            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        pager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
