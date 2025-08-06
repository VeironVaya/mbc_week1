import React, { useState } from 'react';
import axios from 'axios';

const InputReportPage = () => {
  const [form, setForm] = useState({
    name: '',
    age: '',
    position: '',
    positionJob: '',
    report: '',
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/v1/employees', form);
      alert('Report submitted!');
      setForm({ name: '', age: '', position: '', positionJob: '', report: '' });
    } catch (err) {
      alert('Error submitting report');
    }
  };

  return (
    <div className="max-w-md mx-auto">
      <h2 className="text-xl font-bold mb-4">Input Report</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        {["name", "age", "position", "positionJob", "report"].map((field) => (
          <input
            key={field}
            type={field === "age" ? "number" : "text"}
            name={field}
            placeholder={field}
            value={form[field]}
            onChange={handleChange}
            className="w-full p-2 border rounded"
            required
          />
        ))}
        <button type="submit" className="bg-blue-600 text-white px-4 py-2 rounded">Submit</button>
      </form>
    </div>
  );
};

export default InputReportPage;
