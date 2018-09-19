select Name as Customers from Customers
where Customers.Id not in (
    select distinct CustomerId from Orders
)