select ProductName,OrderDate,
dateadd(day,3,OrderDate) as 'Pay Due',
dateadd(month,1,OrderDate) as 'Deliver Due'
from Orders