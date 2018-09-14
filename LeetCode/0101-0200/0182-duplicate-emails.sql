select a.Email from (
    select Email, count(*) as cnt from Person group by Email having cnt > 1
) a