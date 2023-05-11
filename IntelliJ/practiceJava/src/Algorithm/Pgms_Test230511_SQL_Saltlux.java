package Algorithm;

public class Pgms_Test230511_SQL_Saltlux {
    public static void main(String[] args) {
        /*
        SQL문제 해설 모음

        SQL 5번
        -- 코드를 입력하세요
        SELECT ID, CAST((LENGTH(TAGS) - LENGTH(REPLACE(TAGS, '"', ''))) / 2 AS signed integer) as cnt
        FROM YOUTUBES
        GROUP BY ID
        ORDER BY ID ASC

        SQL 6번
        -- 코드를 입력하세요
        SELECT SUM(PRICE)
        FROM SELLINGS
        WHERE CREATED_AT >= '2016-11-01' AND CREATED_AT < '2016-12-01'

         */
    }
}
