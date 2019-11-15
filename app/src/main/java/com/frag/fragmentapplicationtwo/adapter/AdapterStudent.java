package com.frag.fragmentapplicationtwo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.frag.fragmentapplicationtwo.R;
import com.frag.fragmentapplicationtwo.model.Student;

import java.util.List;

public class AdapterStudent extends RecyclerView.Adapter<AdapterStudent.ContactsViewHolder> {
    Context context;
    List<Student> studentList;
    int imageid;

    public AdapterStudent(Context context, List<Student> eSoftwaricaList) {
        this.context = context;
        this.studentList = eSoftwaricaList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contentview, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, final int position) {

        final Student student = studentList.get(position);
        String gender = student.getGender();
        if (gender.equals("Female")) {
            imageid = R.drawable.female;
        } else if (gender.equals("Male")) {
            imageid = R.drawable.boys;
        } else if (gender.equals("Others")) {
            imageid = R.drawable.third;
        }

        int age = student.getAge();

        holder.img2.setImageResource(imageid);
        holder.txtname.setText(student.getName());
        holder.txtage.setText(String.valueOf(age));
        holder.txtaddress.setText(student.getAddress());
        holder.txtgender.setText(student.getGender());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        private TextView txtgender, txtname, txtage, txtaddress;
        private ImageView img2;
        private Button btnDelete;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            img2 = itemView.findViewById(R.id.imageView2);
            txtgender = itemView.findViewById(R.id.txtGender);
            txtname = itemView.findViewById(R.id.textName);
            txtage = itemView.findViewById(R.id.txtage);
            txtaddress = itemView.findViewById(R.id.TXTAddress);
            btnDelete = itemView.findViewById(R.id.buttonDelete);

        }
    }
}
