import { useEffect, useState } from "react";
import API from "../api/api";

function Orders() {

  const [orders, setOrders] = useState([]);

  useEffect(() => {
    API.get("/orders")
      .then(res => setOrders(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div style={{padding:"20px"}}>

      <h2>Orders</h2>

      {orders.map(order => (

        <div
          key={order.id}
          style={{
            border:"1px solid #ddd",
            padding:"10px",
            marginBottom:"10px"
          }}
        >

          <h3>Order ID: {order.id}</h3>

          {order.items.map(item => (
            <div key={item.productId}>
              {item.name} × {item.quantity}
            </div>
          ))}

          <p>Subtotal: ₹{order.subtotal}</p>
          <p>Tax: ₹{order.tax}</p>
          <h4>Total: ₹{order.total}</h4>

          <button
            onClick={() =>
              window.open(
                "http://localhost:8080/api/orders/invoice/" + order.id
              )
            }
          >
            Download Invoice
          </button>

        </div>

      ))}

    </div>
  );
}

export default Orders;