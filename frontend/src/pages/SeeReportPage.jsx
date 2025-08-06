import React, { useEffect, useState } from 'react';
import axios from 'axios';

const SeeReportPage = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/employees')
      .then(res => setEmployees(res.data.employees))
      .catch(() => alert('Failed to fetch employees'));
  }, []);

  return (
    <div className="max-w-4xl mx-auto">
      <h2 className="text-xl font-bold mb-4">Employee Reports</h2>
      {employees.map(emp => (
        <div key={emp.idEmployee} className="border p-4 mb-2 rounded shadow">
          <p><strong>Name:</strong> {emp.name}</p>
          <p><strong>Age:</strong> {emp.age}</p>
          <p><strong>Position:</strong> {emp.position}</p>
          <p><strong>Job:</strong> {emp.positionJob}</p>
          <p><strong>Report:</strong> {emp.report}</p>
        </div>
      ))}
    </div>
  );
};

export default SeeReportPage;
