import Product from "./product.js";

export default interface OrderItem {
    product: Product,
    quantity: number
}