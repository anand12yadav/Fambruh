package com.example.admin.fambruh;

public class Profiles {

    private int Thumbnail;
    private int Thumbnail2;
    private int Thumbnail3;

    public Profiles() {
    }

    public Profiles(int thumbnail,int thumbnail2,int thumbnail3) {
        Thumbnail = thumbnail;
        Thumbnail2 = thumbnail2;
        Thumbnail3 = thumbnail3;
   }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public int getThumbnail2() {
        return Thumbnail2;
    }

    public void setThumbnail2(int thumbnail2) {
        Thumbnail2 = thumbnail2;
    }

    public int getThumbnail3() {
        return Thumbnail3;
    }

    public void setThumbnail3(int thumbnail3) {
        Thumbnail3 = thumbnail3;
    }
}

