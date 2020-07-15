package com.poolavarone.book2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.poolavarone.book2.Adapter.PersonAdapter;
import com.poolavarone.book2.Adapter.favAdapter;
import com.poolavarone.book2.Database.DataBase;
import com.poolavarone.book2.Model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonFragment extends Fragment {
    EditText edittext;
    View view;
    TextView name;
    List<Person> personList;
    private final static String LOGIN = "login";
    favAdapter adapter;
    RecyclerView recyclerView;
    LinearLayout linearLayout;
    LinearLayout lin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.person_fragment, container, false);
        setupviews();
        setdata();
        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().trim().isEmpty()) {
                    setdata();
                } else {
                    removBackground();
                    filter(s.toString());
                }
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupviews() {
        edittext = view.findViewById(R.id.person_search);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerID_person_fragment);
        linearLayout = (LinearLayout) view.findViewById(R.id.profile_background);
        lin = (LinearLayout) view.findViewById(R.id.search_backfav);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));//context in fragment is getactiviry
        DataBase db = new DataBase(getActivity());
        List<Person> personList = db.getFavDaro();
        if (personList.isEmpty()) {
            showBackground();
        } else {
            removBackground();
        }
        adapter = new favAdapter(getActivity(), personList);
        recyclerView.setAdapter(adapter);


    }


    private void filter(String text) {
        List<Person> filterlist = new ArrayList<>();
        for (Person person : personList) {
            if (person.getName().toLowerCase().contains(text.toLowerCase()) || person.getField().toLowerCase().contains(text.toLowerCase())) {
                filterlist.add(person);
        }
        adapter.filterlist(filterlist);
    }
}
    public void setdata() {
        DataBase db = new DataBase(getActivity());
        personList = db.getFavDaro();
        adapter = new favAdapter(getActivity(), personList);
        recyclerView.setAdapter(adapter);

    }

    private void showBackground() {

        linearLayout.setVisibility(view.VISIBLE);
        recyclerView.setVisibility(view.GONE);
    }

    private void removBackground() {
        linearLayout.setVisibility(view.GONE);
        recyclerView.setVisibility(view.VISIBLE);
    }
}
