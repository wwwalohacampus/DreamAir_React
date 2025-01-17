import React from 'react'
import { useNavigate } from 'react-router-dom'
import * as products from '../../apis/product'
import ProductInsertForm from '../../components/product/ProductInsertForm'
import Header from '../../components/fragment/Header'
import Adminfooter from '../../components/fragment/Adminfooter'
import Adminsidebar from '../../components/fragment/Adminsidebar'

const ProductInsertContainer = () => {

  const navigate = useNavigate()

  const onInsert = async (productId, routeNo, name, productCat, productPrice, departure, destination, description, unitsInStock) => {
    try {
      const Product = {
        productId,
        routeNo, 
        name, 
        productCat, 
        productPrice, 
        departure, 
        destination, 
        description, 
        unitsInStock,
      }
      const response = await products.product_insert(Product) 
      alert('등록 완료')
      console.log(response.data);

      navigate('/product')
    } catch(e) {
      console.log(e);
    }
  }

  return (
    <>
    <Header/>
    <div className='d-flex'>
        <Adminsidebar/>
        <ProductInsertForm onInsert={onInsert}/>
    </div>
    <Adminfooter/>  
    </>
  )
}

export default ProductInsertContainer