/* Write your PL/SQL query statement below */
SELECT player_id ,to_char(MIN(event_date)) first_login FROM  Activity GROUP BY player_id 