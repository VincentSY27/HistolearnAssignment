package com.mobAppDev.assignment.histolearn;


import java.util.List;

//getters and setters for History Today
public class HistoryToday {

    private String date;
    private String url;
    private DataBean data;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<HistoryEvent> Events;

        public List<HistoryEvent> getEvents() {
            return Events;
        }

        public void setEvents(List<HistoryEvent> Events) {
            this.Events = Events;
        }






    }
}
