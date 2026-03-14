import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav style={{
      background: "#222",
      padding: "10px",
      display: "flex",
      gap: "20px"
    }}>

      <Link to="/" style={{color:"white"}}>Dashboard</Link>
      <Link to="/products" style={{color:"white"}}>Products</Link>
      <Link to="/customers" style={{color:"white"}}>Customers</Link>
      <Link to="/billing" style={{color:"white"}}>Billing</Link>
      <Link to="/orders" style={{color:"white"}}>Orders</Link>

    </nav>
  );
}

export default Navbar;