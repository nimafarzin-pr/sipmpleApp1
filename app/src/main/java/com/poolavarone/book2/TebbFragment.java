package com.poolavarone.book2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.poolavarone.book2.Adapter.PersonAdapter;
import com.poolavarone.book2.Database.DataBase;
import com.poolavarone.book2.Model.Person;

import java.util.List;

public class TebbFragment extends Fragment {
    View view;

RecyclerView recyclerView;
PersonAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.recycler_home, container,false);

         setupViews();
         return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setupViews(){
        recyclerView =(RecyclerView) view.findViewById(R.id.recycler_home_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//context in fragment is getactiviry
        DataBase db =new DataBase(getActivity());
        List<Person> personList = db.getTebb();
        adapter = new PersonAdapter(getActivity(),personList);
        recyclerView.setAdapter(adapter);

    }


}
