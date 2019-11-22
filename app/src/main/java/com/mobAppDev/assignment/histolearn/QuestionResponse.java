package com.mobAppDev.assignment.histolearn;

import java.util.List;

public class QuestionResponse {
    private int response_code;
    private List<QuestionBean> results;

    public int getResponse_code() {
        return response_code;
    }


    public List<QuestionBean> getResults() {
        return results;
    }

}
