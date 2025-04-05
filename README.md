# 🧃 Vending Machine System

This is a multi-role vending machine management system built using Java and Gradle. It supports roles including **Customer**, **Seller**, **Cashier**, and **Owner**, each with their own features and responsibilities.

---

## 🚀 How to Run

Ensure you are in the correct working directory:

```bash
cd 
gradle run        # to start the application
gradle test       # to run the test suite

# 📋 User Stories – Vending Machine

## 👤 Customer

- View last 5 purchased products
- Pay with cash or credit card
- Get returned change
- Cancel transactions
- Create account / login
- Choose product to buy

## 🧍 Seller

- Add / remove product
- Modify product info (name, code, inventory)
- View product info & sales summary
- Check if product reaches max quantity

## 🏦 Cashier

- Modify number of coins/notes
- View available coins/notes
- Get summary of transactions

## 👑 Owner

- Add/remove users (Seller / Cashier / Owner)
- Modify all product info
- View all usernames
- View canceled transaction reports
- Monitor idle activity >2 minutes and cancel
