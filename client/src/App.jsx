import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

const Home = React.lazy(() => import('./pages/Home'));
const Cart = React.lazy(() => import('./pages/Cart'));
const Product = React.lazy(() => import('./pages/Product'));
const ProductList = React.lazy(() => import('./pages/ProductList'));
const Register = React.lazy(() => import('./pages/Register'));
const Login = React.lazy(() => import('./pages/Login'));

const App = () => {
  return (
    <BrowserRouter>
      <React.Suspense
        fallback={
          <div
            style={{
              height: '100vh',
              width: '100vw',
              display: 'grid',
              placeContent: 'center',
            }}
          >
            <h1>Loading...</h1>
          </div>
        }
      >
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='product' element={<Product />} />
          <Route path='product-list' element={<ProductList />} />
          <Route path='register' element={<Register />} />
          <Route path='login' element={<Login />} />
          <Route path='cart' element={<Cart />} />
        </Routes>
      </React.Suspense>
    </BrowserRouter>
  );
};

export default App;
