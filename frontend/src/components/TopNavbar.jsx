import React from 'react';
import { Link } from 'react-router-dom';

const TopNavbar = () => {
  return (
    <nav className="bg-gray-800 text-white p-4 flex gap-4">
      <Link to="/">Input Report</Link>
      <Link to="/see-report">See Report</Link>
    </nav>
  );
};

export default TopNavbar;
