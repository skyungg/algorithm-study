-- 코드를 작성해주세요
select count(ID) as FISH_COUNT
FROM FISH_INFO
WHERE DATE_FORMAT(TIME, '%Y') = '2021';

