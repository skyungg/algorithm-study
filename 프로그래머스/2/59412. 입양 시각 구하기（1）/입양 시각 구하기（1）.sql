-- 코드를 입력하세요
SELECT HOUR(DATETIME) AS HOUR, COUNT(*)
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) BETWEEN "09" AND "19"
GROUP BY HOUR
ORDER BY HOUR;