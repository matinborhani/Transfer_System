//package com.example.demo.service;
//
//import com.example.demo.database.WayBilJDBCTemplate;
//import com.example.demo.entity.ValueLookup;
//import com.example.demo.entity.WayBil;
//import ir.huri.jcal.JalaliCalendar;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.List;
//
//@Component
//@Service
//public class WayBilDAO {
//    @Autowired
//    WayBilJDBCTemplate jdbcTemplate;
//
//    public List<WayBil> getAllWayBil(){
//        List<WayBil> wayBils = jdbcTemplate.getWayBils();
//        wayBils = convertGeorgianToPersian(wayBils);
//        // convert Greorgian Calender to Persian Calender
//        return wayBils;
//    }
//
//    public WayBil getWayBilWithID(WayBil wayBil){
//        long id = wayBil.getId();
//        wayBil = jdbcTemplate.getWayBil(id);
//        // for car tag
//        String[] str = wayBil.getCarTag().split("/");
//            wayBil.setFirstPart_carTag(str[0]);
//            wayBil.setLetterPart_carTag(str[1]);
//            wayBil.setSecondPart_carTag(str[2]);
//            wayBil.setLastPart_carTag(str[3]);
//
//        // because id remove
//        wayBil.setId(id);
//        return wayBil;
//    }
//
//    public void insertWayBil(WayBil wayBil){
//        if (!wayBil.getsStartDate().equals("")) {
//            // first convert from string to date
//            wayBil.setSendDate(convertStringToDate(wayBil.getsStartDate()));
//        }
//        if (!wayBil.getsFinishDate().equals("")){
//            // second convert from string to date
//            wayBil.setReceivedDate(convertStringToDate(wayBil.getsFinishDate()));
//        }
//        // create car tag with Firstpart & letter & second & last part
//        if (!wayBil.getLetterPart_carTag().equals("")) {
//            wayBil.setCarTag(createCarTag(wayBil));
//        }
//        jdbcTemplate.insertWayBil(wayBil);
//    }
//
//    public void updateWayBil(WayBil wayBil){
//        if (!wayBil.getsStartDate().equals("")) {
//            // first convert from string to date
//            wayBil.setSendDate(convertStringToDate(wayBil.getsStartDate()));
//        }
//        if (!wayBil.getsFinishDate().equals("")){
//            // second convert from string to date
//            wayBil.setReceivedDate(convertStringToDate(wayBil.getsFinishDate()));
//        }
//        // create car tag with Firstpart & letter & second & last part
//        if (!wayBil.getLetterPart_carTag().equals("")) {
//            wayBil.setCarTag(createCarTag(wayBil));
//        }
//        jdbcTemplate.updateWayBil(wayBil);
//    }
//
//    public void deleteWayBil(WayBil wayBil){
//        jdbcTemplate.deleteWayBil(wayBil.getId());
//    }
//
//    public List<ValueLookup> getLookupGoods(){
////        List<String> stringList = new ArrayList<>();
//        List<ValueLookup> lkpGoods = jdbcTemplate.get_LKP_GOODS();
////        for (ValueLookup lkp:lkpGoods){
////            stringList.add(lkp.getDesFarsi());
////        }
//        return lkpGoods;
//    }
//
//    public List<ValueLookup> getLookupStatus(){
////        List<String> stringList = new ArrayList<>();
//        List<ValueLookup> lkpStatus = jdbcTemplate.get_LKP_STATUS();
////        for (ValueLookup lkp:lkpStatus){
////            stringList.add(lkp.getDesFarsi());
////
////        }
//        return lkpStatus;
//    }
//
//    public List<ValueLookup> getLookupCars(){
////        List<String> stringList = new ArrayList<>();
//        List<ValueLookup> lkpCar = jdbcTemplate.get_LKP_CAR();
////        for (ValueLookup lkp:lkpStatus){
////            stringList.add(lkp.getDesFarsi());
////
////        }
//        return lkpCar;
//    }
//    public List<ValueLookup> getLookupCarTag(){
////        List<String> stringList = new ArrayList<>();
//        List<ValueLookup> lkpCarTag = jdbcTemplate.get_LKP_CAR_TAGS();
////        for (ValueLookup lkp:lkpStatus){
////            stringList.add(lkp.getDesFarsi());
////
////        }
//        return lkpCarTag;
//    }
//
//
//    public Date convertStringToDate(String string){
//        String year;
//        String month;
//        String day;
//        JalaliCalendar jalaliCalendar = new JalaliCalendar();
//        String [] arrStr= string.split("/");
//        year = arrStr[0];
//        month = arrStr[1];
//        day = arrStr[2];
//        jalaliCalendar.setDay(Integer.valueOf(day));
//        jalaliCalendar.setMonth(Integer.valueOf(month));
//        jalaliCalendar.setYear(Integer.valueOf(year));
//        Timestamp timestamp = new Timestamp(jalaliCalendar.toGregorian().getTimeInMillis());
//        return timestamp;
//    }
//
//    public List<WayBil> convertGeorgianToPersian(List<WayBil> wayBilList){
//        for (WayBil wayBil:wayBilList){
//            if (wayBil.getSendDate() != null) {
//                wayBil.setsStartDate(convertDateToString(wayBil.getSendDate()));
//            }
//            if (wayBil.getReceivedDate() != null) {
//                wayBil.setsFinishDate(convertDateToString(wayBil.getReceivedDate()));
//            }
//        }
//        return wayBilList;
//    }
//
//    public WayBil convertGeorgianToPersian(WayBil wayBil){
//        if (wayBil.getSendDate() != null) {
//            wayBil.setsStartDate(convertDateToString(wayBil.getSendDate()));
//        }
//        if (wayBil.getReceivedDate() != null) {
//            wayBil.setsFinishDate(convertDateToString(wayBil.getReceivedDate()));
//        }
//        return wayBil;
//    }
//
//    public String convertDateToString (Date date){
//        JalaliCalendar jalaliCalendar = new JalaliCalendar(date);
//        String string = jalaliCalendar.toString();
//        return string;
//    }
//
//    public  String createCarTag(WayBil wayBil){
//
//        String carTag = wayBil.getFirstPart_carTag()  + "/"+ wayBil.getLetterPart_carTag()+ "/"
//                + wayBil.getSecondPart_carTag() + "/" + wayBil.getLastPart_carTag();
//        return carTag;
//    }
//
//    public LookupForm loadingForm(){
//        LookupForm lookupForm = new LookupForm();
//        lookupForm.setLkpStatus(getLookupStatus());
////        lookupForm.setLkpGoods(getLookupGoods());
//        return lookupForm;
//    }
//
//}
