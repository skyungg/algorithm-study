-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM 
    (SELECT B.ANIMAL_ID, DATEDIFF(B.DATETIME, A.DATETIME) AS TIME, B.NAME
     FROM ANIMAL_INS A JOIN ANIMAL_OUTS B
     ON A.ANIMAL_ID = B.ANIMAL_ID
     ORDER BY TIME DESC
     LIMIT 2
    ) AS ANIMAL_TB;