import { useEffect, useState } from "react";
import API from "../api/api";

import {
  Chart as ChartJS,
  BarElement,
  CategoryScale,
  LinearScale,
  Tooltip,
  Legend
} from "chart.js";

import { Bar } from "react-chartjs-2";

ChartJS.register(
  BarElement,
  CategoryScale,
  LinearScale,
  Tooltip,
  Legend
);

function Dashboard() {

  const [stats, setStats] = useState({
    totalRevenue: 0,
    totalOrders: 0,
    totalItemsSold: 0
  });

  useEffect(() => {
    API.get("/dashboard/stats")
      .then(res => setStats(res.data))
      .catch(err => console.log(err));
  }, []);

  const data = {
    labels: ["Revenue", "Orders", "Items Sold"],
    datasets: [
      {
        label: "Sales Data",
        data: [
          stats.totalRevenue,
          stats.totalOrders,
          stats.totalItemsSold
        ],
        backgroundColor: ["green", "blue", "orange"]
      }
    ]
  };

  return (
    <div style={{padding:"20px"}}>

      <h2>Dashboard</h2>

      <p>Total Revenue: ₹{stats.totalRevenue}</p>
      <p>Total Orders: {stats.totalOrders}</p>
      <p>Total Items Sold: {stats.totalItemsSold}</p>

      <div style={{width:"500px"}}>
        <Bar data={data} />
      </div>

    </div>
  );
}

export default Dashboard;