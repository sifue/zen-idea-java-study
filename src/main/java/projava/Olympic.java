/*
「プロになるJava」サンプル
https://gihyo.jp/book/2022/978-4-297-12685-8

Yusuke Yamamoto 2022 copyright reserved.
License: CC0 1.0 Universal
*/
package projava;

public class Olympic {

    static void main(String[] args) {
        new Olympic().isSummerOlympicYear(2014);
    }

    /**
     * 渡された西暦年が夏季近代オリピックの開催日であるかどうか判定する
     * @param year 西暦年
     * @return 夏季オリンピック開催年であればtrue
     * @throws IllegalArgumentException まだイリンピック開催が確定していない年を渡した場合
     */
    public boolean isSummerOlympicYear(int year) {
        if (2032 < year) {
            throw new IllegalArgumentException("2032年までをサポートしています。入力: " + year);
        }
        return year % 4 == 0;
    }
}