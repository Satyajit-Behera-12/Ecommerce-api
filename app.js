const API_BASE = "http://localhost:8080/api";

document.getElementById("userForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const userData = {
    name: document.getElementById("userName").value,
    email: document.getElementById("userEmail").value,
    password: document.getElementById("userPassword").value,
  };

  const res = await fetch(`${API_BASE}/users`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(userData),
  });

  if (res.ok) {
    alert("User created successfully!");
    document.getElementById("userForm").reset();
  } else {
    alert("Failed to create user");
  }
});

document.getElementById("productForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const productData = {
    name: document.getElementById("productName").value,
    description: document.getElementById("productDescription").value,
    price: parseFloat(document.getElementById("productPrice").value),
  };

  const res = await fetch(`${API_BASE}/products`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(productData),
  });

  if (res.ok) {
    alert("Product added!");
    document.getElementById("productForm").reset();
    loadProducts();
  } else {
    alert("Error adding product.");
  }
});
async function loadProducts() {
  const res = await fetch(`${API_BASE}/products`);
  const data = await res.json();
  const table = document.querySelector("#productTable tbody");
  table.innerHTML = "";
  data.forEach(p => {
    const row = `<tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.description}</td>
      <td>${p.price}</td>
    </tr>`;
    table.innerHTML += row;
  });
}

window.onload = loadProducts;
