package com.phuongsala.data.entity

import com.google.gson.annotations.SerializedName

data class WeatherForecastResponse(
    @SerializedName("cnt") val cnt: Int,
    @SerializedName("list") val weathers: List<WeatherInfoResponse>
)

data class WeatherInfoResponse(
    @SerializedName("dt") val dt: Long,
    @SerializedName("temp") val temp: TempResponse,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("weather") val weathers: List<WeatherDescResponse>
)

data class TempResponse(
    @SerializedName("day") val day: Float,
    @SerializedName("min") val min: Float,
    @SerializedName("max") val max: Float,
    @SerializedName("night") val night: Float,
    @SerializedName("eve") val eve: Float,
    @SerializedName("morn") val morn: Float,
)

data class WeatherDescResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)

fun getSampleWeatherForecastResponse() = "{\n" +
        "  \"city\": {\n" +
        "    \"id\": 1580578,\n" +
        "    \"name\": \"Ho Chi Minh City\",\n" +
        "    \"coord\": {\n" +
        "      \"lon\": 106.6667,\n" +
        "      \"lat\": 10.8333\n" +
        "    },\n" +
        "    \"country\": \"VN\",\n" +
        "    \"population\": 0,\n" +
        "    \"timezone\": 25200\n" +
        "  },\n" +
        "  \"cod\": \"200\",\n" +
        "  \"message\": 0.1098522,\n" +
        "  \"cnt\": 7,\n" +
        "  \"list\": [\n" +
        "    {\n" +
        "      \"dt\": 1633233600,\n" +
        "      \"sunrise\": 1633214517,\n" +
        "      \"sunset\": 1633257763,\n" +
        "      \"temp\": {\n" +
        "        \"day\": 302.04,\n" +
        "        \"min\": 297.18,\n" +
        "        \"max\": 303.12,\n" +
        "        \"night\": 297.22,\n" +
        "        \"eve\": 299.06,\n" +
        "        \"morn\": 297.18\n" +
        "      },\n" +
        "      \"feels_like\": {\n" +
        "        \"day\": 306.57,\n" +
        "        \"night\": 298.14,\n" +
        "        \"eve\": 300.06,\n" +
        "        \"morn\": 298.12\n" +
        "      },\n" +
        "      \"pressure\": 1009,\n" +
        "      \"humidity\": 75,\n" +
        "      \"weather\": [\n" +
        "        {\n" +
        "          \"id\": 501,\n" +
        "          \"main\": \"Rain\",\n" +
        "          \"description\": \"moderate rain\",\n" +
        "          \"icon\": \"10d\"\n" +
        "        }\n" +
        "      ],\n" +
        "      \"speed\": 2.63,\n" +
        "      \"deg\": 192,\n" +
        "      \"gust\": 3.6,\n" +
        "      \"clouds\": 64,\n" +
        "      \"pop\": 1,\n" +
        "      \"rain\": 16.03\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": 1633320000,\n" +
        "      \"sunrise\": 1633300915,\n" +
        "      \"sunset\": 1633344126,\n" +
        "      \"temp\": {\n" +
        "        \"day\": 300.97,\n" +
        "        \"min\": 296.82,\n" +
        "        \"max\": 302.87,\n" +
        "        \"night\": 298.04,\n" +
        "        \"eve\": 301.96,\n" +
        "        \"morn\": 296.86\n" +
        "      },\n" +
        "      \"feels_like\": {\n" +
        "        \"day\": 304.38,\n" +
        "        \"night\": 299.04,\n" +
        "        \"eve\": 306.57,\n" +
        "        \"morn\": 297.69\n" +
        "      },\n" +
        "      \"pressure\": 1008,\n" +
        "      \"humidity\": 77,\n" +
        "      \"weather\": [\n" +
        "        {\n" +
        "          \"id\": 501,\n" +
        "          \"main\": \"Rain\",\n" +
        "          \"description\": \"moderate rain\",\n" +
        "          \"icon\": \"10d\"\n" +
        "        }\n" +
        "      ],\n" +
        "      \"speed\": 2.79,\n" +
        "      \"deg\": 167,\n" +
        "      \"gust\": 5.17,\n" +
        "      \"clouds\": 100,\n" +
        "      \"pop\": 0.83,\n" +
        "      \"rain\": 3.22\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": 1633406400,\n" +
        "      \"sunrise\": 1633387314,\n" +
        "      \"sunset\": 1633430489,\n" +
        "      \"temp\": {\n" +
        "        \"day\": 298.6,\n" +
        "        \"min\": 297.2,\n" +
        "        \"max\": 298.78,\n" +
        "        \"night\": 297.51,\n" +
        "        \"eve\": 298.78,\n" +
        "        \"morn\": 297.49\n" +
        "      },\n" +
        "      \"feels_like\": {\n" +
        "        \"day\": 299.55,\n" +
        "        \"night\": 298.48,\n" +
        "        \"eve\": 299.72,\n" +
        "        \"morn\": 298.43\n" +
        "      },\n" +
        "      \"pressure\": 1009,\n" +
        "      \"humidity\": 90,\n" +
        "      \"weather\": [\n" +
        "        {\n" +
        "          \"id\": 501,\n" +
        "          \"main\": \"Rain\",\n" +
        "          \"description\": \"moderate rain\",\n" +
        "          \"icon\": \"10d\"\n" +
        "        }\n" +
        "      ],\n" +
        "      \"speed\": 2.93,\n" +
        "      \"deg\": 193,\n" +
        "      \"gust\": 4.79,\n" +
        "      \"clouds\": 100,\n" +
        "      \"pop\": 1,\n" +
        "      \"rain\": 10.16\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": 1633492800,\n" +
        "      \"sunrise\": 1633473713,\n" +
        "      \"sunset\": 1633516853,\n" +
        "      \"temp\": {\n" +
        "        \"day\": 299.73,\n" +
        "        \"min\": 296.73,\n" +
        "        \"max\": 302.18,\n" +
        "        \"night\": 297.33,\n" +
        "        \"eve\": 300.65,\n" +
        "        \"morn\": 296.73\n" +
        "      },\n" +
        "      \"feels_like\": {\n" +
        "        \"day\": 299.73,\n" +
        "        \"night\": 298.31,\n" +
        "        \"eve\": 304.28,\n" +
        "        \"morn\": 297.65\n" +
        "      },\n" +
        "      \"pressure\": 1007,\n" +
        "      \"humidity\": 84,\n" +
        "      \"weather\": [\n" +
        "        {\n" +
        "          \"id\": 501,\n" +
        "          \"main\": \"Rain\",\n" +
        "          \"description\": \"moderate rain\",\n" +
        "          \"icon\": \"10d\"\n" +
        "        }\n" +
        "      ],\n" +
        "      \"speed\": 3.44,\n" +
        "      \"deg\": 162,\n" +
        "      \"gust\": 6.91,\n" +
        "      \"clouds\": 100,\n" +
        "      \"pop\": 1,\n" +
        "      \"rain\": 12.12\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": 1633579200,\n" +
        "      \"sunrise\": 1633560113,\n" +
        "      \"sunset\": 1633603217,\n" +
        "      \"temp\": {\n" +
        "        \"day\": 298.5,\n" +
        "        \"min\": 296.55,\n" +
        "        \"max\": 298.5,\n" +
        "        \"night\": 296.55,\n" +
        "        \"eve\": 297.18,\n" +
        "        \"morn\": 296.97\n" +
        "      },\n" +
        "      \"feels_like\": {\n" +
        "        \"day\": 299.49,\n" +
        "        \"night\": 297.43,\n" +
        "        \"eve\": 298.12,\n" +
        "        \"morn\": 297.97\n" +
        "      },\n" +
        "      \"pressure\": 1007,\n" +
        "      \"humidity\": 92,\n" +
        "      \"weather\": [\n" +
        "        {\n" +
        "          \"id\": 500,\n" +
        "          \"main\": \"Rain\",\n" +
        "          \"description\": \"light rain\",\n" +
        "          \"icon\": \"10d\"\n" +
        "        }\n" +
        "      ],\n" +
        "      \"speed\": 3.26,\n" +
        "      \"deg\": 325,\n" +
        "      \"gust\": 6.74,\n" +
        "      \"clouds\": 100,\n" +
        "      \"pop\": 1,\n" +
        "      \"rain\": 7.28\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": 1633665600,\n" +
        "      \"sunrise\": 1633646513,\n" +
        "      \"sunset\": 1633689582,\n" +
        "      \"temp\": {\n" +
        "        \"day\": 299.61,\n" +
        "        \"min\": 296.28,\n" +
        "        \"max\": 302.51,\n" +
        "        \"night\": 297.97,\n" +
        "        \"eve\": 301.47,\n" +
        "        \"morn\": 296.28\n" +
        "      },\n" +
        "      \"feels_like\": {\n" +
        "        \"day\": 299.61,\n" +
        "        \"night\": 298.91,\n" +
        "        \"eve\": 305.55,\n" +
        "        \"morn\": 297.16\n" +
        "      },\n" +
        "      \"pressure\": 1008,\n" +
        "      \"humidity\": 81,\n" +
        "      \"weather\": [\n" +
        "        {\n" +
        "          \"id\": 500,\n" +
        "          \"main\": \"Rain\",\n" +
        "          \"description\": \"light rain\",\n" +
        "          \"icon\": \"10d\"\n" +
        "        }\n" +
        "      ],\n" +
        "      \"speed\": 2.84,\n" +
        "      \"deg\": 276,\n" +
        "      \"gust\": 5.35,\n" +
        "      \"clouds\": 88,\n" +
        "      \"pop\": 0.99,\n" +
        "      \"rain\": 4.64\n" +
        "    },\n" +
        "    {\n" +
        "      \"dt\": 1633752000,\n" +
        "      \"sunrise\": 1633732913,\n" +
        "      \"sunset\": 1633775947,\n" +
        "      \"temp\": {\n" +
        "        \"day\": 300.33,\n" +
        "        \"min\": 297.11,\n" +
        "        \"max\": 300.33,\n" +
        "        \"night\": 297.56,\n" +
        "        \"eve\": 299.11,\n" +
        "        \"morn\": 297.11\n" +
        "      },\n" +
        "      \"feels_like\": {\n" +
        "        \"day\": 303.83,\n" +
        "        \"night\": 298.54,\n" +
        "        \"eve\": 299.11,\n" +
        "        \"morn\": 298.07\n" +
        "      },\n" +
        "      \"pressure\": 1008,\n" +
        "      \"humidity\": 85,\n" +
        "      \"weather\": [\n" +
        "        {\n" +
        "          \"id\": 501,\n" +
        "          \"main\": \"Rain\",\n" +
        "          \"description\": \"moderate rain\",\n" +
        "          \"icon\": \"10d\"\n" +
        "        }\n" +
        "      ],\n" +
        "      \"speed\": 3.82,\n" +
        "      \"deg\": 242,\n" +
        "      \"gust\": 8.58,\n" +
        "      \"clouds\": 94,\n" +
        "      \"pop\": 0.96,\n" +
        "      \"rain\": 17.37\n" +
        "    }\n" +
        "  ]\n" +
        "}"
