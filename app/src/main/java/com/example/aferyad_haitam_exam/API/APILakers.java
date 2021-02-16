package com.example.aferyad_haitam_exam.API;

import com.example.aferyad_haitam_exam.Model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APILakers {
    @GET("lakers")
    Call<Result> getLakers();
}
