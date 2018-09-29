package com.rasin.hackerrank.com.rasin.woowa;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solution {

    public static String solution(String S) {
        // write your code in Java SE 8
        String[] arr = S.split("\n");
        List<Photo> photos = new ArrayList<Photo>();
        Map<String, List<Photo>> cityTable = new HashMap<String, List<Photo>>();
        for(String record : arr){
            String[] data = record.split(",");
            Photo photo = new Photo(data[0].trim(), data[1].trim(), data[2].trim());
            photos.add(photo);

            List<Photo> cityPhotos = cityTable.get(photo.getCity());
            if(cityPhotos == null) {
                cityPhotos = new ArrayList<Photo>();
                cityTable.put(photo.getCity(), cityPhotos);
            }
            cityPhotos.add(photo);
        }

        for(String city : cityTable.keySet()){
            List<Photo> cityPhotos = cityTable.get(city);
            Collections.sort(cityPhotos, new PhotoDateComparator());
            int length = String.valueOf(cityPhotos.size()).length();
            for(int i = 1; i <= cityPhotos.size(); i++){
                String order = String.format("%0" + length + "d", i);
                cityPhotos.get(i-1).setOrder(order);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Photo p : photos){
            sb.append(p.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public static class Photo {
        String city;
        String ext;
        LocalDateTime time;
        String order;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        public Photo(String name, String city, String time){
            this.city = city;
            this.ext = name.substring(name.lastIndexOf("."));
            this.time = LocalDateTime.parse(time, formatter);
        }

        public String getCity(){
            return this.city;
        }

        public LocalDateTime getTime(){
            return this.time;
        }

        public void setOrder(String order){
            this.order = order;
        }

        @Override
        public String toString() {
            return city + order + ext;
        }
    }

    public static class PhotoDateComparator implements Comparator<Photo> {
        public int compare(Photo p1, Photo p2) {
            return p1.getTime().compareTo(p2.getTime());
        }
    }


    public static void main(String[] args) {
        solution ("photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11");

    }
}
