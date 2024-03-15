
![Screenshot 2024-03-13 082004](https://github.com/ysebo/eCommerce/assets/147805133/55dcf7fb-3538-45c7-86cb-ee3c59526c90)

   ## Welcome to eCommerce application


[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
## Table of Contents
- [Installation](#installation)
- [High-level_description](#high-level_description)
- [Architectural_concepts](#architectural_concepts)


## Installation

### Prerequisites
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) (version x.x or higher)
- [Maven](https://maven.apache.org/download.cgi)

## High-level_description
- Product Service: Manages product information, including adding, editing, deleting, and searching for products.<br>

- Review Service: Manages product reviews, including adding, editing, deleting, and retrieving them.<br>

- User Service: Handles user authentication, registration, and account management.<br>

- Shopping Cart Service: Manages users' shopping carts, allowing them to add, update, and remove items.<br>

- Order Service: Processes orders, including creating, managing, and tracking orders.<br>

- Payment Service: Handles payment processing securely for online orders.<br>

 - Favorites Service: Allows users to add products to their favorites list for future reference.<br>


## Architectural_concepts
- Improved Scalability: Each service can be scaled independently based on its individual needs.<br>

- Increased Fault Tolerance: If one service fails, the others can continue to function, minimizing downtime and impact on users.<br>

- Enhanced Development and Deployment: Independent services can be developed, tested, and deployed independently, leading to faster development cycles.<br>


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

