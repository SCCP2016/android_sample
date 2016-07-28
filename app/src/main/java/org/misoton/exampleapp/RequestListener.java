package org.misoton.exampleapp;

import retrofit.RetrofitError;

public interface RequestListener<T> {
    void onSuccess(T response);
    void onFailure(RetrofitError error);
}
