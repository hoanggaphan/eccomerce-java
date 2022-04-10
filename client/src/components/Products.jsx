import styled from 'styled-components';
import Product from './Product';

const Container = styled.div`
  padding: 20px;
  display: flex;
  flex-wrap: wrap;
  column-gap: 15px;
  row-gap: 25px;
  justify-content: ${(props) => props.justifyContent || 'flex-start'};
`;

const Products = ({ products, justifyContent }) => {
  return (
    <Container justifyContent={justifyContent}>
      {products?.map((item) => (
        <Product item={item} key={item.slug} />
      ))}
    </Container>
  );
};

export default Products;
