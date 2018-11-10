package alhdo.xyz.ifiedt.UI.fragments;


import android.os.Bundle;

import alhdo.xyz.ifiedt.UI.adapters.CourseAdapter;
import alhdo.xyz.ifiedt.core.Course;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.events.calendar.views.EventsCalendar;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import alhdo.xyz.ifiedt.R;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseFragment extends Fragment implements Toolbar.OnMenuItemClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.mRecylerCourse)
    RecyclerView mRecyclerCourse;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    private LinearLayoutManager mLinearLayoutManager;
    private CourseAdapter mCourseAdapter;
    private List<Course> mCourseList = new ArrayList<>();

    public CourseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseFragment newInstance(String param1, String param2) {
        CourseFragment fragment = new CourseFragment();
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
        View view= inflater.inflate(R.layout.fragment_course, container, false);
        ButterKnife.bind(this,view);
        mToolbar.inflateMenu(R.menu.options_menu);
        mToolbar.setTitle("Courses");
        init();

        return view;
    }

    private void init(){
        populateCourseExample();
        mCourseAdapter = new CourseAdapter(getActivity());
        mCourseAdapter.setCourseList(mCourseList);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mLinearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerCourse.setLayoutManager(mLinearLayoutManager);
        mRecyclerCourse.setItemAnimator(new DefaultItemAnimator());
        mRecyclerCourse.setAdapter(mCourseAdapter);

        Menu menu = mToolbar.getMenu();
        mToolbar.setOnMenuItemClickListener(this);

    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//    }

    private void populateCourseExample(){
        Course c1 = new Course("UX","UNIX",60);
        c1.setTeacherName("Mr Quang");
        c1.setPlan("YES");
        mCourseList.add(c1);
        Course c2 = new Course("VIET", "Vietnamien", 40);
        c2.setTeacherName("Mrs Thu");
        c2.setPlan("YES");
        mCourseList.add(c2);

        Course c3 = new Course("IA", "IA & SMA", 60);
        c3.setTeacherName("Mr Vinh");
//        c3.setPlan();
        mCourseList.add(c3);
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                SearchView searchView = (SearchView)item.getActionView();
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        mCourseAdapter.getFilter().filter(query);
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        mCourseAdapter.getFilter().filter(newText);
//                        Toast.makeText(getActivity(), newText, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

                return true;
        }
        return false;
    }
}
