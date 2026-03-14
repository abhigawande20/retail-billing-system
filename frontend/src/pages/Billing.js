import { useState } from "react";
import API from "../api/api";

function Billing() {

  const [cart, setCart] = useState([]);

  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [quantity, setQuantity] = useState(1);
  const [customerName, setCustomerName] = useState("");

  const addItem = () => {

    if (!name || !price) {
      alert("Enter product details");
      return;
    }

    const newItem = {
      productId: Date.now().toString(),
      name: name,
      price: parseFloat(price),
      quantity: parseInt(quantity)
    };

    setCart([...cart, newItem]);

    setName("");
    setPrice("");
    setQuantity(1);
  };

  const subtotal = cart.reduce(
    (sum, item) => sum + item.price * item.quantity,
    0
  );

  const tax = subtotal * 0.05;
  const total = subtotal + tax;

  const placeOrder = () => {

    const order = {
      customerId: "123",
      customerName: customerName,
      items: cart
    };

    API.post("/orders", order)
      .then(res => {

        const orderId = res.data.id;

        window.open(
          "http://localhost:8080/api/orders/invoice/" + orderId
        );

        setCart([]);

      })
      .catch(err => {
        console.log(err);
        alert("Order failed");
      });
  };

  return (

    <div style={{padding:"20px"}}>

      <h2>Billing Dashboard</h2>

      <input
        placeholder="Customer Name"
        value={customerName}
        onChange={(e)=>setCustomerName(e.target.value)}
      />

      <h3>Add Product</h3>

      <input
        placeholder="Product Name"
        value={name}
        onChange={(e)=>setName(e.target.value)}
      />

      <input
        placeholder="Price"
        value={price}
        onChange={(e)=>setPrice(e.target.value)}
      />

      <input
        placeholder="Qty"
        value={quantity}
        onChange={(e)=>setQuantity(e.target.value)}
      />

      <button onClick={addItem}>Add Item</button>

      <hr/>

      <h3>Cart</h3>

      {cart.map(item => (
        <div key={item.productId}>
          {item.name} × {item.quantity} = ₹{item.price * item.quantity}
        </div>
      ))}

      <hr/>

      <p>Subtotal: ₹{subtotal}</p>
      <p>Tax: ₹{tax}</p>
      <h3>Total: ₹{total}</h3>

      <button
        onClick={placeOrder}
        style={{
          padding:"10px",
          background:"green",
          color:"white",
          border:"none"
        }}
      >
        Generate Bill
      </button>

    </div>
  );
}

export default Billing;