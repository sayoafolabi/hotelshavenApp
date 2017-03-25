package com.haven.hotels.hotelshaven;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AfolabSa on 25/03/2017.
 */

public class DataValidation
{
    final Pattern UK_POSTCODE = Pattern.compile("^(([gG][iI][rR] {0,}0[aA]{2})|((([a-pr-uwyzA-PR-UWYZ][a-hk-yA-HK-Y]?[0-9][0-9]?)" +
            "|(([a-pr-uwyzA-PR-UWYZ][0-9][a-hjkstuwA-HJKSTUW])" +
            "|([a-pr-uwyzA-PR-UWYZ][a-hk-yA-HK-Y][0-9][abehmnprv-yABEHMNPRV-Y]))) " +
            "{0,}[0-9][abd-hjlnp-uw-zABD-HJLNP-UW-Z]{2}))$");

    final Pattern US_POSTCODE = Pattern.compile("^[0-9]{5}(?:-[0-9]{4})?$");

    Date today, parseDate;
    SimpleDateFormat dateFormat;


    public boolean isEmpty(String data)
    {
        return data.isEmpty();
    }

    public boolean isUkPostcode(String data)
    {
        Matcher m = UK_POSTCODE.matcher(data);
        if(!m.matches())
        {
            return false;
        }

        return true;
    }

    public boolean isUsPostcode(String data)
    {
        Matcher m = US_POSTCODE.matcher(data);
        if(!m.matches())
        {
            return false;
        }

        return true;
    }

    public Date getToday()
    {
        today = new Date();
        return today;
    }

    public boolean isTodayOrAfter(Date date)
    {
        if (!(date.equals(getToday()) || date.after(getToday())))
        {
            return false;
        }

        return true;
    }

    public boolean checkOutDateGreaterThanCheckInDate(Date checkin, Date checkOut)
    {
        if (!(checkOut.after(checkin)))
        {
            return false;
        }

        return true;
    }

    public Date convertStringToDate(String dateString)
    {
        dateFormat = new SimpleDateFormat("dd MMM yy", Locale.US);

        try
        {
            parseDate = dateFormat.parse(dateString);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return parseDate;
    }
}
