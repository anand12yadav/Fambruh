package com.example.admin.fambruh;

public class MomentStoriesData {
    private int StoriesThumbnail;
    private int StoriesThumbnail2;
    private int StoriesThumbnail3;

    public MomentStoriesData() {
    }

    public MomentStoriesData(int storiesThumbnail, int storiesThumbnail2, int storiesThumbnail3) {
        StoriesThumbnail = storiesThumbnail;
        StoriesThumbnail2= storiesThumbnail2;
        StoriesThumbnail3= storiesThumbnail3;
    }

    public int getStoriesThumbnail() {
        return StoriesThumbnail;
    }

    public void setStoriesThumbnail(int storiesThumbnail) {
        StoriesThumbnail = storiesThumbnail;
    }

    public int getStoriesThumbnail2() {
        return StoriesThumbnail2;
    }

    public void setStoriesThumbnail2(int storiesThumbnail2) {
        StoriesThumbnail2 = storiesThumbnail2;
    }

    public int getStoriesThumbnail3() {
        return StoriesThumbnail3;
    }

    public void setStoriesThumbnail3(int storiesThumbnail3) {
        StoriesThumbnail3 = storiesThumbnail3;
    }
}
