package parallax.scroll.swipe.effect;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;

import parallax.scroll.swipe.effect.adapter.ViewPagerAdapter;
import parallax.scroll.swipe.effect.fragment.PlaceFragment;
import parallax.scroll.swipe.effect.model.Place;


public class MainActivity extends FragmentActivity implements PlaceFragment.OnFragmentInteractionListener {

    private ViewPager pager;

    private ArrayList<Fragment> fragments = new ArrayList<>();

    private ArrayList<Place>  placeList = new ArrayList<>();

    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeList.add(new Place("London", "", R.drawable.london));
        placeList.add(new Place("Bangkok", "", R.drawable.bangkok));
        placeList.add(new Place("Paris", "", R.drawable.paris));
        placeList.add(new Place("Singapore", "", R.drawable.singapore));
        placeList.add(new Place("New York", "", R.drawable.newyork));
        placeList.add(new Place("Istanbul", "", R.drawable.istanbul));
        placeList.add(new Place("Hong kong", "", R.drawable.hongkong));
        placeList.add(new Place("Barcelona", "", R.drawable.barcelona));
        placeList.add(new Place("Amsterdam", "", R.drawable.amsterdam));
        placeList.add(new Place("Rome", "", R.drawable.barcelona));
        placeList.add(new Place("Vienna", "", R.drawable.vienna));
        placeList.add(new Place("Milan", "", R.drawable.milan));


        pager = (ViewPager) findViewById(R.id.viewpager);

        for(int i= 0; i< 12; i++) {
            PlaceFragment fragment = PlaceFragment.newInstance(placeList.get(i));
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
