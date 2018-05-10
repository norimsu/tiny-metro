package io.naraplatform.share.domain;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import io.naraplatform.share.util.date.DateFormatUtil;
import io.naraplatform.share.util.date.DateUtil;
import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;
import io.naraplatform.share.util.string.StringUtil;

public class DatePair implements JsonSerializable {
    //
    private String zoneId;
    private String startDate;
    private String endDate;

    public DatePair() {
        //
    }

    public DatePair(ZoneId zoneId, LocalDate startDate) {
        //
        this(zoneId.getId(), startDate, null);
    }

    public DatePair(ZoneId zoneId, LocalDate startDate, LocalDate endDate) {
        //
        this(zoneId.getId(), startDate, endDate);
    }

    public DatePair(String zoneId, LocalDate startDate, LocalDate endDate) {
        //
        this.zoneId = zoneId;
        this.startDate = startDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        if (endDate == null) {
            this.endDate = null;
        } else {
            this.endDate = endDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }

    public DatePair(String zoneId, String startDate, String endDate) {
        //
        this.zoneId = zoneId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DatePair(LocalDate startDate, int days) {
        //
        this.zoneId = ZoneId.systemDefault().getId();
        this.startDate = startDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.endDate = startDate.plusDays(days).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public DatePair(String startDateStr, int days) {
        //
        this.zoneId = ZoneId.systemDefault().getId();
        this.startDate = startDateStr;
        LocalDate start = LocalDate.parse(startDateStr);
        this.endDate = start.plusDays(days).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static DatePair getSample() {
        //
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(10L);

        DatePair sample = new DatePair(zoneId, startDate, endDate);

        return sample;
    }

    public int getPeriodMonth() {
        //
        if (StringUtil.isEmpty(startDate) || StringUtil.isEmpty(endDate)) return 0;
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        Period period = Period.between(start, end);
        return period.getMonths();
    }

    public static DatePair fromJson(String json) {
        //
        return JsonUtil.fromJson(json, DatePair.class);
    }

    public boolean hasEndDate() {
        //
        if(this.endDate != null) {
            return true;
        }

        return false;
    }

    public int getStartYear() {
        //
        if (startDate == null) return 0;
        LocalDate start = LocalDate.parse(startDate);
        return start.getYear();
    }

    public int getStartMonthValue() {
        //
        if (startDate == null) return 0;
        LocalDate start = LocalDate.parse(startDate);
        return start.getMonthValue();
    }

    public int getEndYear() {
        //
        if (endDate == null) return 0;
        LocalDate end = LocalDate.parse(endDate);
        return end.getYear();
    }

    public int getEndMonthValue() {
        //
        if (endDate == null) return 0;
        LocalDate end = LocalDate.parse(endDate);
        return end.getMonthValue();
    }

    public boolean contains(LocalDate date) {
        //
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        return (start.isEqual(date) || start.isBefore(date)) && (end.isEqual(date) || end.isAfter(date));
    }
    
    public boolean isValid() {
        //
        if (!ZoneId.getAvailableZoneIds().contains(zoneId)) return false;
        try {
            DateUtil.parseDate(startDate, DateFormatUtil.ISO_DATE_FORMAT.getPattern());
            DateUtil.parseDate(endDate, DateFormatUtil.ISO_DATE_FORMAT.getPattern());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final DatePair datePair = (DatePair) o;

        return Objects.equals(zoneId, datePair.zoneId)
            && Objects.equals(startDate, datePair.startDate)
            && Objects.equals(endDate, datePair.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zoneId, startDate, endDate);
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
        System.out.println(getSample().getPeriodMonth());

        LocalDate now = LocalDate.now();
        LocalDate yesterday = now.minusDays(1);
        LocalDate tomorrow = now.plusDays(1);

        DatePair datePair = new DatePair(ZoneId.systemDefault().getId(), yesterday, tomorrow);

        System.out.println(datePair);
        System.out.println(datePair.contains(LocalDate.now()));
        System.out.println(datePair.contains(LocalDate.now().minusDays(1)));
        System.out.println(datePair.contains(LocalDate.now().minusDays(2)));
        System.out.println(datePair.contains(LocalDate.now().plusDays(1)));
        System.out.println(datePair.contains(LocalDate.now().plusDays(2)));

    }
}
