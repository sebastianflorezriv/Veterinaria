package com.softcaribbean.Veterinaria.mensajes;

public record ResponseMessage<T> (

        int code,
        String message,
        T data

){

}

