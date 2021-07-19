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


The task was very simple. I was tried to implement using Test Driven Development (TDD). Also, I have applied few known design patterns as follows:-

**1.Builder**  
**2.SingleTone**  
**3.Visitor Design Pattern**  

Most of the application text was defined as resource "application_en_GB.properties"  so that it can be localized in a different language.

The app is designed as loose coupling. It can be easily expanded.

