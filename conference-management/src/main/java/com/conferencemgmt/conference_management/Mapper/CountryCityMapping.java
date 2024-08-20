package com.conferencemgmt.conference_management.Mapper;


import com.conferencemgmt.conference_management.Enum.CityOfResidence;
import com.conferencemgmt.conference_management.Enum.CountryOfResidence;

import java.util.*;

public class CountryCityMapping {

    private static final Map<CountryOfResidence, List<CityOfResidence>> countryCityMap = new HashMap<>();

    static {
        // Initialize the map with countries and their cities
        countryCityMap.put(CountryOfResidence.MOROCCO, Arrays.asList(
                CityOfResidence.CASABLANCA,
                CityOfResidence.RABAT,
                CityOfResidence.MARRAKECH,
                CityOfResidence.FES,
                CityOfResidence.TANGIER,
                CityOfResidence.AGADIR,
                CityOfResidence.OUJDA,
                CityOfResidence.MEKNES,
                CityOfResidence.ESSAOUIRA,
                CityOfResidence.TETOUAN
        ));

        countryCityMap.put(CountryOfResidence.USA, Arrays.asList(
                CityOfResidence.NEW_YORK,
                CityOfResidence.LOS_ANGELES,
                CityOfResidence.CHICAGO,
                CityOfResidence.HOUSTON,
                CityOfResidence.PHOENIX,
                CityOfResidence.PHILADELPHIA,
                CityOfResidence.SAN_ANTONIO,
                CityOfResidence.SAN_DIEGO,
                CityOfResidence.DALLAS,
                CityOfResidence.SAN_JOSE
        ));

        countryCityMap.put(CountryOfResidence.CANADA, Arrays.asList(
                CityOfResidence.TORONTO,
                CityOfResidence.MONTREAL,
                CityOfResidence.VANCOUVER,
                CityOfResidence.CALGARY,
                CityOfResidence.EDMONTON,
                CityOfResidence.OTTAWA,
                CityOfResidence.WINNIPEG,
                CityOfResidence.HALIFAX,
                CityOfResidence.VICTORIA,
                CityOfResidence.QUEBEC_CITY
        ));

        countryCityMap.put(CountryOfResidence.UK, Arrays.asList(
                CityOfResidence.LONDON,
                CityOfResidence.BIRMINGHAM,
                CityOfResidence.MANCHESTER,
                CityOfResidence.GLASGOW,
                CityOfResidence.LIVERPOOL,
                CityOfResidence.LEEDS,
                CityOfResidence.SHEFFIELD,
                CityOfResidence.BRISTOL,
                CityOfResidence.EDINBURGH,
                CityOfResidence.COVENTRY
        ));

        countryCityMap.put(CountryOfResidence.FRANCE, Arrays.asList(
                CityOfResidence.PARIS,
                CityOfResidence.MARSEILLE,
                CityOfResidence.LYON,
                CityOfResidence.TOULOUSE,
                CityOfResidence.NICE,
                CityOfResidence.NANTES,
                CityOfResidence.MONTPELLIER,
                CityOfResidence.STRASBOURG,
                CityOfResidence.BORDEAUX,
                CityOfResidence.LILLE
        ));

        countryCityMap.put(CountryOfResidence.GERMANY, Arrays.asList(
                CityOfResidence.BERLIN,
                CityOfResidence.MUNICH,
                CityOfResidence.FRANKFURT,
                CityOfResidence.COLOGNE,
                CityOfResidence.STUTTGART,
                CityOfResidence.DUSSELDORF,
                CityOfResidence.HAMBURG,
                CityOfResidence.LEIPZIG,
                CityOfResidence.DRESDEN,
                CityOfResidence.NUREMBERG
        ));

        countryCityMap.put(CountryOfResidence.AUSTRALIA, Arrays.asList(
                CityOfResidence.SYDNEY,
                CityOfResidence.MELBOURNE,
                CityOfResidence.BRISBANE,
                CityOfResidence.PERTH,
                CityOfResidence.ADELAIDE,
                CityOfResidence.CANBERRA,
                CityOfResidence.HOBART,
                CityOfResidence.DARWIN,
                CityOfResidence.GOLD_COAST,
                CityOfResidence.SUNSHINE_COAST
        ));

        countryCityMap.put(CountryOfResidence.INDIA, Arrays.asList(
                CityOfResidence.MUMBAI,
                CityOfResidence.DELHI,
                CityOfResidence.BENGALURU,
                CityOfResidence.KOLKATA,
                CityOfResidence.CHENNAI,
                CityOfResidence.HYDERABAD,
                CityOfResidence.AHMEDABAD,
                CityOfResidence.PUNE,
                CityOfResidence.JAIPUR,
                CityOfResidence.LUCKNOW
        ));

        countryCityMap.put(CountryOfResidence.CHINA, Arrays.asList(
                CityOfResidence.BEIJING,
                CityOfResidence.SHANGHAI,
                CityOfResidence.GUANGZHOU,
                CityOfResidence.SHENZHEN,
                CityOfResidence.CHENGDU,
                CityOfResidence.HANGZHOU,
                CityOfResidence.NINGBO,
                CityOfResidence.WUHAN,
                CityOfResidence.XIAN,
                CityOfResidence.SUZHOU
        ));

        countryCityMap.put(CountryOfResidence.JAPAN, Arrays.asList(
                CityOfResidence.TOKYO,
                CityOfResidence.OSAKA,
                CityOfResidence.NAGOYA,
                CityOfResidence.KOBE,
                CityOfResidence.FUKUOKA,
                CityOfResidence.HOKKAIDO,
                CityOfResidence.HIROSHIMA,
                CityOfResidence.KUMAMOTO,
                CityOfResidence.OITA,
                CityOfResidence.NAGASAKI
        ));

        countryCityMap.put(CountryOfResidence.BRAZIL, Arrays.asList(
                CityOfResidence.SAO_PAULO,
                CityOfResidence.RIO_DE_JANEIRO,
                CityOfResidence.BRASILIA,
                CityOfResidence.SALVADOR,
                CityOfResidence.FORTALEZA,
                CityOfResidence.BELEM,
                CityOfResidence.RECIFE,
                CityOfResidence.CURITIBA,
                CityOfResidence.PORTO_ALEGRE,
                CityOfResidence.MACEIO
        ));

        countryCityMap.put(CountryOfResidence.SOUTH_AFRICA, Arrays.asList(
                CityOfResidence.JOHANNESBURG,
                CityOfResidence.CAPE_TOWN,
                CityOfResidence.DURBAN,
                CityOfResidence.PRETORIA,
                CityOfResidence.PORT_ELIZABETH,
                CityOfResidence.BLOEMFONTEIN,
                CityOfResidence.EAST_LONDON,
                CityOfResidence.NELSPRUIT,
                CityOfResidence.RUSTENBURG,
                CityOfResidence.KIMBERLEY
        ));
    }

    public static List<CityOfResidence> getCitiesByCountry(CountryOfResidence country) {
        return countryCityMap.getOrDefault(country, Collections.emptyList());
    }
}

