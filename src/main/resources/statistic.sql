select count(id), site, date_trunc('month', created_date) as month
from mytable
where created_date > now()  - interval '1' year
group by month, site
order by month
