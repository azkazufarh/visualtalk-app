package com.azkazhanif.visualtalk.Domain;

public class NotificationDomain {
    private String titleNotif, subtitleNotif;

    public NotificationDomain(String titleNotif, String subtitleNotif ) {
        this.titleNotif = titleNotif;
        this.subtitleNotif = subtitleNotif;
    }

    public String getTitleNotif() {
        return titleNotif;
    }

    public void setTitleNotif(String titleNotif) {
        this.titleNotif = titleNotif;
    }

    public String getSubtitleNotif() {
        return subtitleNotif;
    }

    public void setSubtitleNotif(String subtitleNotif) {
        this.subtitleNotif = subtitleNotif;
    }

}
