package Algorithm;

public class Pgms_Test230526_SQL_Saltlux {
    public static void main(String[] args) {

        /*
        SQL문제 해설 모음

        SQL 5번
        -- 코드를 입력하세요
        SELECT ID, NAME,
            (SELECT COUNT(BRANCH_ID) - 1 FROM EMPLOYEES WHERE BRANCH_ID = ORG.BRANCH_ID) AS NUMCOWORKER
        FROM EMPLOYEES ORG
        ORDER BY ID ASC;

        SQL 6번
        -- 코드를 입력하세요
        SELECT BRANCH_ID, SUM(PRICE) AS 매출액
        FROM EMPLOYEES E
        JOIN SELLINGS S ON E.ID = S.EMPLOYEE_ID
        GROUP BY BRANCH_ID
        ORDER BY SUM(PRICE) DESC, BRANCH_ID ASC

         */
    }
}
