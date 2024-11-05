-- OrderDao:
-- Insert given order along with order details.

-- Fetch all orders in descending order of time.
SELECT * FROM PIZZA_ORDERS
    ORDER BY ORDERTIME DESC;
-- Fetch order of given id.
SELECT * FROM PIZZA_ORDERS
WHERE ID="?";

-- LoginDao:
-- Insert new customer.
INSERT INTO PIZZA_CUSTOMERS (NAME, PASSWORD, MOBILE, ADDRESS, EMAIL)
VALUES(?,?,?,?);
-- Fetch customer by email.
SELECT * FROM PIZZA_CUSTOMERS WHERE EMAIL="?";

-- MenuDao
-- Fetch Types i.e. Veg & NonVeg
SELECT TYPE FROM PIZZA_ITEMS;
-- Fetch Sub-Categories (see requirements)
SELECT CATEGORY FROM PIZZA_ITEMS WHERE TYPE="?";
-- Fetch Items (Pizzas) of given Type & Sub-Categories (see requirements)
SELECT * FROM PIZZA_ITEMS WHERE TYPE="?" AND CATEGORY="?";
-- Fetch Item of given Id
SELECT * FROM PIZZA_ITEMS WHERE ID="?";
-- Fetch ItemPrice of given Id
SELECT PRICE FROM PIZZA_ITEMS WHERE ID="?";
