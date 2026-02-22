package clients.data;

import java.util.Map;
import models.CityCookies;

public class CityStorage {

  public static final Map<String, CityCookies> CITY_STORAGE = Map.of(
      "moscow", new CityCookies("Moscow", "f1c3c4f0-3426-4cda-8449-e5d326e02f97"),
      "bajmak", new CityCookies("Bajmak", "5ba940c9-911a-11ea-8456-00155d80e803"),
      "london", new CityCookies(null, null)
  );
}
