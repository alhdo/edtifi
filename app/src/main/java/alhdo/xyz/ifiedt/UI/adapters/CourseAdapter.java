package alhdo.xyz.ifiedt.UI.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import alhdo.xyz.ifiedt.R;
import alhdo.xyz.ifiedt.core.Course;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> implements Filterable {
    Context mContext;
    List<Course> mCourseList = new ArrayList<>();
    List<Course> mCourseListFiltered;

    public CourseAdapter(Context mContext){
        this.mContext = mContext;
    }

    public void setCourseList(List<Course> mCourseList){
        this.mCourseList=mCourseList;
        this.mCourseListFiltered = mCourseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_course, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = mCourseList.get(position);

        holder.mCourseHours.setText(new StringBuilder().append(course.getHours()).append(" Hours").toString());
        holder.mCourseName.setText(course.getName());
        holder.mCourseID.setText(new StringBuilder().append("ID : ").append(course.getID()).toString());
        if(course.getPlan()!=null){
            holder.mCoursePlan.setVisibility(View.VISIBLE);
        }else{
            holder.mCoursePlan.setVisibility(View.INVISIBLE);
            holder.pointPlan.setVisibility(View.INVISIBLE);
        }

        if(course.getTeacherName()!=null){
            holder.mCourseTeacher.setText(course.getTeacherName());
        }else{
            holder.mCourseTeacher.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return mCourseListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()){
                    mCourseListFiltered = mCourseList;
                }else{
                    List<Course> filteredList = new ArrayList<>();
                    for(Course row:mCourseList){
                        if(row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getID().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(row);
                        }
                    }
                    mCourseListFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mCourseListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mCourseListFiltered = (ArrayList<Course>)results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView mCourseName;

        @BindView(R.id.courseHours)
        TextView mCourseHours;


        @BindView(R.id.courseID)
        TextView mCourseID;

        @BindView(R.id.coursePlan)
        TextView mCoursePlan;

        @BindView(R.id.courseTeacher)
        TextView mCourseTeacher;

        @BindView(R.id.viewPlan)
        View pointPlan;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
