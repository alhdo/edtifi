package alhdo.xyz.ifiedt.UI.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import alhdo.xyz.ifiedt.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseDayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseDayFragment extends Fragment implements EdtFragment.OnDaySelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.dateFragment)
    TextView dateFragment;
    public CourseDayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseDayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseDayFragment newInstance(String param1, String param2) {
        CourseDayFragment fragment = new CourseDayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        EdtFragment fragment = (EdtFragment) getParentFragment();
        assert fragment != null;
        fragment.setOnDaySelectedListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_course_day, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onDaySelected(Calendar calendar) {
        Date date = calendar.getTime();
        Toast.makeText(getActivity(), new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH).format(date), Toast.LENGTH_SHORT).show();
        dateFragment.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH).format(date));
    }
}
