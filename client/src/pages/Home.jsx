import React from 'react';
import useSWR from 'swr';
import Announcement from '../components/Announcement';
import Categories from '../components/Categories';
import Footer from '../components/Footer';
import Navbar from '../components/Navbar';
import Newsletter from '../components/Newsletter';
import Products from '../components/Products';
import Slider from '../components/Slider';

const fetchPopularList = (url) => fetch(url).then((r) => r.json());

const Home = () => {
  const { data } = useSWR(
    'http://localhost:8080/api/v1/products/popular',
    fetchPopularList
  );
  
  const products = data?.map((i) => ({ slug: i.slug, img: i.images[0].src }));
  console.log(data);

  return (
    <div>
      <Announcement />
      <Navbar />
      <Slider />
      <Categories />
      <Products products={products || []} />
      <Newsletter />
      <Footer />
    </div>
  );
};

export default Home;
