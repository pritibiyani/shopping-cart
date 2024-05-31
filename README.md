# Advanced Shopping Cart System

This project is a comprehensive shopping cart system built with Java, Spring Boot, and Gradle.

## Features

### 1. Add Items to the Cart with Item Variation

This feature allows users to add items to their shopping cart. Each item may have variations (such as size, color, etc.), and the system is designed to handle these variations.

### 2. Remove Item from the Cart

This feature allows users to remove items from their shopping cart.

### 3. Complex Price Calculation with Discounts and Promotions

This feature calculates the total price of the items in the cart. The calculation logic should be able to handle the following scenarios:

- **Multiple Discounts**: The system should be able to apply multiple discounts to an item. For example, an item could have a 10% category discount and a 5% member discount. The system should apply these discounts in a sequence that gives the customer the best price.

- **Promotional Codes**: The system should allow customers to enter promotional codes that can provide a fixed amount or percentage discount on the total cart value or on specific items.

- **Quantity Discounts**: The system should offer discounts for buying certain quantities of an item. For example, "buy one get one free" or "buy two get 50% off the third".

This feature requires a well-designed calculation engine that can handle these complex scenarios in a straightforward and efficient manner. The engine should be flexible enough to easily add or modify calculation rules as business requirements change.


## Good to Have

### Wishlist Functionality

This feature allows users to add items to a wishlist for future purchase.

### Product Reviews and Ratings

This feature allows users to review and rate the products they have purchased.

### Order History and Reorder Functionality

This feature allows users to view their past orders and easily reorder items.

### Advanced Search and Filter Options

This feature allows users to search for products and filter the results based on various criteria such as price, category, brand, etc.

## Getting Started

To get started with this project, you'll need to have Java, Spring Boot, and Gradle installed on your machine.