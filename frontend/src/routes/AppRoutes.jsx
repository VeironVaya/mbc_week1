import React from 'react';
import { Routes, Route } from 'react-router-dom';
import MainLayout from '../layouts/MainLayout';
import InputReportPage from '../pages/InputReportPage';
import SeeReportPage from '../pages/SeeReportPage';

const AppRoutes = () => {
  return (
    <Routes>
      <Route element={<MainLayout />}>
        <Route path="/" element={<InputReportPage />} />
        <Route path="/see-report" element={<SeeReportPage />} />
      </Route>
    </Routes>
  );
};

export default AppRoutes;
