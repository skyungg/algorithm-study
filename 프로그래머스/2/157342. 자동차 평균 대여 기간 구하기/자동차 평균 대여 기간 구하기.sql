-- 코드를 입력하세요
# SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE)), 2) AS AVERAGE_DURATION
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE AVG(DATEDIFF(END_DATE, START_DATE)) >= 6
# ORDER BY AVERAGE_DURATION DESC, CAR_ID;

# SELECT CAR_ID
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE CAR_ID = () AND DATEDIFF(END_DATE, START_DATE) >= 6;


        
SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE)+1), 1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY CAR_ID 
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC;