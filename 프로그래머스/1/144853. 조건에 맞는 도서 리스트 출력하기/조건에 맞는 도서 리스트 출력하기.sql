-- 코드를 입력하세요 
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, "%Y-%m-%d") AS PUBLISHED_DATE
FROM BOOK
WHERE CATEGORY = "인문" AND SUBSTRING(PUBLISHED_DATE, 1, 4) = "2021"
ORDER BY PUBLISHED_DATE;