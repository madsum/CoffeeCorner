# Charlene's Coffee Corner App

This is a Java console app. It simulates a real-life cafe ordering process. The app displays the following list:-    

====================================================        
CHARLENE'S COFFEE CORNER MENU
1. Coffee Small Price: 2.50 CHF
2. Coffee Medium Price: 3.00 CHF
3. Coffee Large Price: 3.50 CHF
4. Freshly squeezed orange juice 0.25l Price: 3.95 CHF
5. Bacon Roll Price: 4.50 CHF
   Extras:-
6. Extra Milk Price: 0.30 CHF
7. Foamed Milk Price: 0.50 CHF
8. Special Roast Coffee Price: 2.50 CHF
   Enter 0 (zero) for the payment:
   Please enter the menu number 0 to 8:  
     
=====================================================

Users can select the menu by the number.

It has few discount conditions given such as:-

1. It offers a customer stamp card, where every 5th beverage is for free.

2. If a customer orders a beverage and a snack, one of the extra's is free.


I tried to develop using Test Driven Development (TDD). Also, I have applied few known design patterns as follows:-

**1.Builder**  
**2.SingleTone**  
**3.Visitor Design Pattern**  

Most of the application text was defined as resource "application_en_GB.properties"  so that it can be localized in a different language easily.

The app is designed as loose coupling. It can be easily expanded.  

## Application execution and testing
Java's main class is defined in **CoffeeCornerClient** class. Any Java IDE can run this main class. It is a console app so it prompts users inputs. Just enter a menu item number such as 1, 2 , 3, 4 , etc. Once all the order is selected you have to enter 0 (zero) for the payment.

I have implemented an integration type of end-to-end test class CoffeeCornerClientIT. It can be found in JUnit's test package org.example.integration.

You can quickly check the application's all the features such as:-
* Give free drink on every 5th purchase
* Give 1 free extra when beverage and a snack in the same order
* Order all times each


p.s: To see the free drink logic you have to make 4 purchases in the same application execution time. Because I was not allowed to use any kind of data storage system as a database.

