package com.example.android31.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android31.data.models.character.CharacterDto;

public class Resource<T> {

    @NonNull public final Status status;
    @NonNull public final T data;
    @NonNull public final String message;

    public Resource(@NonNull Status status, @NonNull T data, @NonNull String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }


    public static <T> Resource<T> success(@NonNull T data){
        return  new Resource<T>(Status.SUCCESS,data, null);
    }
    public static <T> Resource<T> error(String msg ,@Nullable T data){
        return  new Resource<>(Status.ERROR,data, msg);
    }
    public static <T> Resource<T> loading(@Nullable T data){
        return  new Resource<>(Status.LOADING,data, null);
    }



    public enum Status{
        SUCCESS,
        ERROR,
        LOADING
    }

}
