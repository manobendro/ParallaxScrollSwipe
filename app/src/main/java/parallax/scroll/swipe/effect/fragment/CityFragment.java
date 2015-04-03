package parallax.scroll.swipe.effect.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import parallax.scroll.swipe.effect.R;
import parallax.scroll.swipe.effect.customview.ObservableScrollView;
import parallax.scroll.swipe.effect.model.City;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CityFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "city";


    // TODO: Rename and change types of parameters
    private City city;
    private ImageView imageView;
    private TextView nameTxtVw;
    private TextView descriptionTxtVw;
    private ObservableScrollView scrollView;


    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param city Parameter 1.
     * @return A new instance of fragment CityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CityFragment newInstance(City city) {
        CityFragment fragment = new CityFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, city);
        fragment.setArguments(args);
        return fragment;
    }

    public CityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            city = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView);

        imageView.setImageResource(city.getImageResourceId());

        nameTxtVw = (TextView) view.findViewById(R.id.name);

        nameTxtVw.setText(city.getName());

        descriptionTxtVw = (TextView) view.findViewById(R.id.description);

        descriptionTxtVw.setText(city.getDescription());

        scrollView = (ObservableScrollView) view.findViewById(R.id.scrollView);

        scrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {

                View view = scrollView.findViewById(R.id.imageView);

                if(view!=null){
                    view.setTranslationY(scrollView.getScrollY() / 2);
                }

            }
        });

        return  view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
