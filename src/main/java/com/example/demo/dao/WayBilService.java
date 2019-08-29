package com.example.demo.dao;

import com.example.demo.entity.WayBil;
import com.google.common.collect.Lists;
import ir.huri.jcal.JalaliCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Component
public class WayBilService {

    @Autowired
    WayBilRepository wayBilRepository;

    public List<WayBil> getAllWayBil() {
        List<WayBil> wayBils = Lists.newArrayList(wayBilRepository.findAll());
        return wayBils;
    }

    public WayBil getById(WayBil wayBil) {
        Optional<WayBil> list = wayBilRepository.findById(wayBil.getId());
        if (!list.isPresent())
            return null;
        else {
            list.get().setId(wayBil.getId());
            return list.get();
        }
    }

    public boolean insertWayBil(WayBil wayBil) {
        boolean result;
        // for status !: CLEAR SOON
        wayBil.setStatus("02");

        if (!wayBil.getsStartDate().equals("")) {
            // first convert from string to date
            wayBil.setSendDate(convertStringToDate(wayBil.getsStartDate()));
        }
        if (!wayBil.getsFinishDate().equals("")) {
            // second convert from string to date
            wayBil.setReceivedDate(convertStringToDate(wayBil.getsFinishDate()));
        }
        WayBil saveWayBil = null;
        try {
            saveWayBil = wayBilRepository.save(wayBil);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


        if (saveWayBil != null)
            result = true;
        else
            result = false;
        System.out.println(result);
        return result;
    }

    public boolean updateWayBil(WayBil wayBil) {
        boolean result;
        // for status !: CLEAR SOON
        wayBil.setStatus("02");

        if (!wayBil.getsStartDate().equals("")) {
            // first convert from string to date
            wayBil.setSendDate(convertStringToDate(wayBil.getsStartDate()));
        }
        if (!wayBil.getsFinishDate().equals("")) {
            // second convert from string to date
            wayBil.setReceivedDate(convertStringToDate(wayBil.getsFinishDate()));
        }

        WayBil save = wayBilRepository.save(wayBil);
        if (save.equals(null))
            return false;
        else
            return true;
    }

    public boolean deleteWayBil(WayBil wayBil) {
        wayBilRepository.deleteById(wayBil.getId());
        return true;
    }

    public List<WayBil> convertGeorgianToPersian(List<WayBil> wayBilList) {
        for (WayBil wayBil : wayBilList) {
            if (wayBil.getSendDate() != null) {
                wayBil.setsStartDate(convertDateToString(wayBil.getSendDate()));
            }
            if (wayBil.getReceivedDate() != null) {
                wayBil.setsFinishDate(convertDateToString(wayBil.getReceivedDate()));
            }
        }
        return wayBilList;
    }

    public WayBil prepareForAdd() {
        WayBil wayBil = new WayBil();
        Date date = convertStringToDate(getCurrentDate());
        wayBil.setCreateDate(date);
        wayBil.setsCreateDate(getCurrentDate());
        return wayBil;
    }

    public WayBil convertGeorgianToPersian(WayBil wayBil) {
        if (wayBil.getSendDate() != null) {
            wayBil.setsStartDate(convertDateToString(wayBil.getSendDate()));
        }
        if (wayBil.getReceivedDate() != null) {
            wayBil.setsFinishDate(convertDateToString(wayBil.getReceivedDate()));
        }
        return wayBil;
    }

    public String convertDateToString(Date date) {
        JalaliCalendar jalaliCalendar = new JalaliCalendar(date);
        String string = jalaliCalendar.toString();
        return string;
    }

    public Date convertStringToDate(String string) {
        String year;
        String month;
        String day;
        JalaliCalendar jalaliCalendar = new JalaliCalendar();
        String[] arrStr = string.split("/");
        year = arrStr[0];
        month = arrStr[1];
        day = arrStr[2];
        jalaliCalendar.setDay(Integer.valueOf(day));
        jalaliCalendar.setMonth(Integer.valueOf(month));
        jalaliCalendar.setYear(Integer.valueOf(year));
        Timestamp timestamp = new Timestamp(jalaliCalendar.toGregorian().getTimeInMillis());
        return timestamp;
    }

    public String getCurrentDate() {
        JalaliCalendar jalaliCalendar = new JalaliCalendar();
        int year = jalaliCalendar.getYear();
        int month = jalaliCalendar.getMonth();
        int day = jalaliCalendar.getDay();
        String date = String.valueOf(year).concat("/")
                .concat(String.valueOf(month)).concat("/")
                .concat(String.valueOf(day));
        return date;
    }

}
