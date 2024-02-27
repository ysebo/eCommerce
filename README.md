   # Welcome to Our eCommerce application 
#### 🛋️🏡✨


[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
## Table of Contents
- [Installation](#installation)
- [High-level description](#high-level_description)
- [Architectural concepts](#architectural_concepts)


## Installation

### Prerequisites
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) (version x.x or higher)
- [Maven](https://maven.apache.org/download.cgi)

## High-level description
Product Service: Manages product information, including adding, editing, deleting, and searching for products.
Review Service: Manages product reviews, including adding, editing, deleting, and retrieving them.
User Service: Handles user authentication, registration, and account management.
Shopping Cart Service: Manages users' shopping carts, allowing them to add, update, and remove items.
Order Service: Processes orders, including creating, managing, and tracking orders.
Payment Service: Handles payment processing securely for online orders.
Favorites Service: Allows users to add products to their favorites list for future reference.

## Architectural concepts
Improved Scalability: Each service can be scaled independently based on its individual needs.
Increased Fault Tolerance: If one service fails, the others can continue to function, minimizing downtime and impact on users.
Enhanced Development and Deployment: Independent services can be developed, tested, and deployed independently, leading to faster development cycles.

## Getting Started

To get started with the project, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/ysebo/eCommerce.git
### Navigate to the project directory 
 ```bash
 cd eCommerce
 ```
### Install dependencies:
 ```bash
npm install
 ```
Set up environment variables:
Create a .env file in the root directory.
Define environment variables such as database connection URI, JWT secret, and any other necessary configurations.
Run the application:
 ```bash
npm start
 ```

