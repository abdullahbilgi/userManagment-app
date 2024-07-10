import { useState } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import Navbar from "./layout/Navbar.jsx";
import Home from "./pages/Home.jsx";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import AddUser from "./users/AddUser.jsx";
import EditUser from "./users/EditUser.jsx";
import ViewUser from "./users/ViewUser.jsx";

function App() {
  document.title = "User Managment App";

  return (
    <>
      <Router>
        <Navbar />

        <Routes>
          <Route exect path="/" element={<Home />} />
          <Route exect path="/adduser" element={<AddUser />} />
          <Route exect path="/edituser/:id" element={<EditUser />} />
          <Route exect path="/viewuser/:id" element={<ViewUser />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
