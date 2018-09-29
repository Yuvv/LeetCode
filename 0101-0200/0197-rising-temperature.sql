select w1.Id
from Weather w1, Weather w2
where adddate(w1.RecordDate, -1) = w2.RecordDate and w1.Temperature > w2.Temperature