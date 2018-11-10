package alhdo.xyz.ifiedt.UI.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.events.calendar.views.EventsCalendar;

import org.jetbrains.annotations.Nullable;

import java.util.Calendar;

import alhdo.xyz.ifiedt.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EdtFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EdtFragment extends Fragment implements EventsCalendar.Callback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.eventsCalendar)
    EventsCalendar eventsCalendar;

    public EdtFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EdtFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EdtFragment newInstance(String param1, String param2) {
        EdtFragment fragment = new EdtFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_edt, container, false);
        ButterKnife.bind(this, view);
        Calendar today = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        eventsCalendar.setToday(today);
        eventsCalendar.setSelectionMode(eventsCalendar.getSINGLE_SELECTION());
        eventsCalendar.setMonthRange(today,end);
        eventsCalendar.setCallback(this);

        end.add(Calendar.YEAR,2);
        return view;
    }

    @Override
    public void onDayLongPressed(@Nullable Calendar calendar) {

    }

    @Override
    public void onDaySelected(@Nullable Calendar calendar) {

    }

    @Override
    public void onMonthChanged(@Nullable Calendar calendar) {

    }
}
