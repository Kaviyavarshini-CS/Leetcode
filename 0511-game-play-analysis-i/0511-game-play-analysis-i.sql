# Write your MySQL query statement below
SELECT player_id, min(event_date) AS first_login
from Activity group by player_id ;