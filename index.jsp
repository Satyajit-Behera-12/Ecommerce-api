<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Simple E-Commerce</title>
  <style>
    body { font-family: Arial; padding: 20px; }
    input, button { margin: 5px; }
    .section { margin-top: 20px; border-top: 1px solid #ccc; padding-top: 10px; }
  </style>
</head>
<body>
  <h1>Simple E-Commerce Frontend</h1>

  <!-- LOGIN SECTION -->
  <div class="section">
    <h2>Login</h2>
    <input type="text" id="username" placeholder="Username">
    <input type="password" id="password" placeholder="Password">
    <button onclick="login()">Login</button>
    <p id="loginStatus"></p>
  </div>

  <!-- PRODUCTS SECTION -->
  <div class="section" id="productSection" style="display: none;">
    <h2>Products</h2>
    <button onclick="fetchProducts()">Load Products</button>
    <ul id="productList"></ul>
  </div>

  <!-- CART SECTION -->
  <div class="section" id="cartSection" style="display: none;">
    <h2>Your Cart</h2>
    <button onclick="viewCart()">View Cart</button>
    <ul id="cartList"></ul>
  </div>

  <script>
    let token = '';

    function login() {
      const user = document.getElementById("username").value;
      const pass = document.getElementById("password").value;

      fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username: user, password: pass })
      })
      .then(res => res.json())
      .then(data => {
        if (data.token) {
          token = data.token;
          document.getElementById("loginStatus").innerText = "Login successful!";
          document.getElementById("productSection").style.display = "block";
          document.getElementById("cartSection").style.display = "block";
        } else {
          document.getElementById("loginStatus").innerText = "Login failed!";
        }
      });
    }

    function fetchProducts() {
      fetch("http://localhost:8080/customer/products", {
        headers: { "Authorization": "Bearer " + token }
      })
      .then(res => res.json())
      .then(products => {
        const list = document.getElementById("productList");
        list.innerHTML = "";
        products.forEach(p => {
          const li = document.createElement("li");
          li.innerHTML = `${p.name} - $${p.price} 
            <button onclick="addToCart(${p.id})">Add to Cart</button>`;
          list.appendChild(li);
        });
      });
    }

    function addToCart(productId) {
      fetch(`http://localhost:8080/customer/cart/${productId}?quantity=1`, {
        method: "POST",
        headers: { "Authorization": "Bearer " + token }
      }).then(() => alert("Added to cart"));
    }

    function viewCart() {
      fetch("http://localhost:8080/customer/cart", {
        headers: { "Authorization": "Bearer " + token }
      })
      .then(res => res.json())
      .then(items => {
        const list = document.getElementById("cartList");
        list.innerHTML = "";
        items.forEach(i => {
          const li = document.createElement("li");
          li.innerText = `${i.product.name} x ${i.quantity}`;
          list.appendChild(li);
        });
      });
    }
  </script>
</body>
</html>
