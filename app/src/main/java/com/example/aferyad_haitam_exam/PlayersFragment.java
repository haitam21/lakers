package com.example.aferyad_haitam_exam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.aferyad_haitam_exam.API.APILakers;
import com.example.aferyad_haitam_exam.Model.Coach;
import com.example.aferyad_haitam_exam.Model.Player;
import com.example.aferyad_haitam_exam.Model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayersFragment extends Fragment {
    ArrayList<Player> players=new ArrayList<>();
    RecyclerView recyclerView;
    AdapterRVPlayer adapterRVPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlayersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayersFragment newInstance(String param1, String param2) {
        PlayersFragment fragment = new PlayersFragment();
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
        final View view= inflater.inflate(R.layout.fragment_players, container, false);
        recyclerView=view.findViewById(R.id.rvPlayers);
        adapterRVPlayer=new AdapterRVPlayer(view.getContext(),players);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapterRVPlayer);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://android.busin.fr/api")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APILakers apiLakers=retrofit.create(APILakers.class);

        Call<Result> call=apiLakers.getLakers();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(!response.isSuccessful()){

                }else{
                    Result result=response.body();
                    preparView(result.getPlayers(), view);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return view;
    }

    private void preparView(List<Player> plays, View view) {
        players.clear();
        for(Player player:plays){
            players.add(player);
            adapterRVPlayer=new AdapterRVPlayer(view.getContext(),players);
            recyclerView.setAdapter(adapterRVPlayer);
        }
    }
}