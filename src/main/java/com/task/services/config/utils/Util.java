package com.task.services.config.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
    private Util() {
        super();
    }

    public static String toJsonString(Object rq) {
        try {
            return new ObjectMapper().writeValueAsString(rq);
        } catch (Exception e) {
            return rq.toString();
        }
    }
}

