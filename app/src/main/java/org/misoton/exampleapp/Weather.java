package org.misoton.exampleapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// JSONを読み込むためのクラス
// 特別な設定をしない限り、フィールド名はJSONの要素と同じでなければならない。

// フィールドにない要素は無視する。
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    public List<DayWeather> list;
}
