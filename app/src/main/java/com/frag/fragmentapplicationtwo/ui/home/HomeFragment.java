package com.frag.fragmentapplicationtwo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.frag.fragmentapplicationtwo.R;
import com.frag.fragmentapplicationtwo.adapter.AdapterStudent;
import com.frag.fragmentapplicationtwo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    static List<Student> studentList = new ArrayList<>();

    private RecyclerView recycler_view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recycler_view = root.findViewById(R.id.recycler_view);

        // Adding all the contacts object in list
        Student student = new Student("manish", "kapan", 23, "Male");
        studentList = student.getStudentList();
        if (studentList.isEmpty()) {
            studentList.add(new Student("manish", "kapan", 23, "Male"));
           // studentList.add(new Student("mahesh", "jorpati", 29, "male"));
            student.setStudentList(studentList);
        }
        AdapterStudent studentAdapter = new AdapterStudent(getActivity(), studentList);
        recycler_view.setAdapter(studentAdapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }
}