import { useEffect, useState } from "react";
import API from "../api/api";

function Products() {

  const [products, setProducts] = useState([]);

  useEffect(() => {
    API.get("/products")
      .then(res => setProducts(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div style={{padding:"20px"}}>
      <h2>Products</h2>

      {products.map(p => (
        <div key={p.id} style={{
          border:"1px solid #ddd",
          padding:"10px",
          marginBottom:"10px",
          borderRadius:"5px"
        }}>
          <h3>{p.name}</h3>
          <p>Price: ₹{p.price}</p>
          <p>Stock: {p.stock}</p>
        </div>
      ))}

    </div>
  );
}

export default Products;