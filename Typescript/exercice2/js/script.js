import OrderManager from "./classe/orderManager.js";
let orderCpt = 0;
function createOrder(customer, items) {
    orderCpt++;
    items.forEach((item) => item.product.stock -= item.quantity);
    let order = {
        id: orderCpt.toString(),
        customer: customer,
        items: items,
        status: "en attente"
    };
    return order;
}
function calculateTotal(order) {
    return order.items.reduce((acc, curr) => acc + curr.quantity * curr.product.price, 0);
}
let loic = {
    id: 1,
    name: "Loic",
    email: "blabl@blae"
};
let products = [
    { id: 1, name: "jeu vidéo", price: 12, stock: 40 },
    { id: 1, name: "livre", price: 5.99, stock: 30 },
    { id: 1, name: "téléphone", price: 200, stock: 12 },
    { id: 1, name: "gameboy", price: 50, stock: 10 },
];
let orders = [
    { quantity: 3, product: products[0] },
    { quantity: 2, product: products[1] },
];
let orderManager = new OrderManager();
let order = createOrder(loic, [orders[0], orders[1]]);
let order2 = createOrder(loic, []);
console.log(JSON.stringify(order));
console.log(calculateTotal(order).toFixed(2));
console.log("livre : " + JSON.stringify(products[1]));
orderManager.addOrder(order);
console.log(orderManager);
