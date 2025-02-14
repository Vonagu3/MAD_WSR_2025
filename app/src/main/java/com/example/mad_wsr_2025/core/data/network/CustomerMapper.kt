package com.example.mad_wsr_2025.core.data.network

import com.example.mad_wsr_2025.core.data.network.model.CustomerSerializable
import com.example.mad_wsr_2025.core.data.network.model.ProductImage
import com.example.mad_wsr_2025.core.data.network.model.ProductImageSerializable
import com.example.mad_wsr_2025.core.data.network.model.ProductInfoSerializable
import com.example.mad_wsr_2025.domain.Customer
import com.example.mad_wsr_2025.domain.ProductInfo

//fun Customer.toCustomerSerializable(): CustomerSerializable {
//    return CustomerSerializable(
//        id = id,
//        name = name
//    )
//}
//
//fun CustomerSerializable.toCustomer(): Customer {
//    return Customer(
//        id = id,
//        name = name
//    )
//}
//
//fun ProductInfo.toProductInfoSerializable(): ProductInfoSerializable {
//    return ProductInfoSerializable(id, name, price, description, images, categoryId)
//}
//
//fun ProductInfoSerializable.toProductInfo(): ProductInfo {
//    return ProductInfo(id, name, price, description, images, categoryId)
//}

fun ProductInfoSerializable.toProductInfo() = ProductInfo(
    id = id,
    name = name,
    price = price,
    description = description,
    categoryId = categoryId,
)


//fun ProductInfoWithImagesSerializable.toProductInfoWithImage() = ProductInfoWithImages(
//    id = id,
//    name = name,
//    price = price,
//    description = description,
//    categoryId = categoryId,
//    images = images.map { it.toProductImage() },
//)


fun ProductImageSerializable.toProductImage() = ProductImage(
    id = id,
    url = url,
)