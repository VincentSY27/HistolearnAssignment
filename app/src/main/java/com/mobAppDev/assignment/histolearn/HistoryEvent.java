package com.mobAppDev.assignment.histolearn;

import java.util.List;

//getters and setters for Historical Events
public class HistoryEvent {
    private String year;
    private String text;
    private String html;
    private String no_year_html;
    private List<LinksBean> links;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getNo_year_html() {
        return no_year_html;
    }

    public void setNo_year_html(String no_year_html) {
        this.no_year_html = no_year_html;
    }

    public List<LinksBean> getLinks() {
        return links;
    }

    public void setLinks(List<LinksBean> links) {
        this.links = links;
    }

    public static class LinksBean {


        private String title;
        private String link;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
