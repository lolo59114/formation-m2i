import OrderManager from "./classe/orderManager.js";
import Customer from "./interface/customer.js";
import Order, { Status } from "./interface/order.js";
import OrderItem from "./interface/orderItem.js";
import Product from "./interface/product.js";

let orderCpt: number = 0;
function createOrder(customer: Customer, items: OrderItem[]): Order {
    orderCpt++;
    items.forEach((item) => item.product.stock -= item.quantity);
    let order: Order = {
        id: orderCpt.toString(),
        customer: customer,
        items: items,
        status: "en attente"
    }
    return order;
}

function calculateTotal(order: Order): number {
    return order.items.reduce((acc: number, curr: OrderItem) => acc + curr.quantity * curr.product.price, 0);
}

let loic: Customer = {
    id: 1,
    name: "Loic",
    email: "blabl@blae"
};

let products: Product[] = [
    {id: 1,name: "jeu vidéo",price: 12,stock: 40},
    {id: 1,name: "livre",price: 5.99,stock: 30},
    {id: 1,name: "téléphone",price: 200,stock: 12},
    {id: 1,name: "gameboy",price: 50,stock: 10},
];

let orders: OrderItem[] = [
    {quantity: 3, product: products[0]},
    {quantity: 2, product: products[1]},
    {quantity: 1, product: products[2]},
    {quantity: 1, product: products[3]}
]

let orderManager: OrderManager = new OrderManager();
let order: Order = createOrder(loic, [orders[0], orders[1]]);
let order2: Order = createOrder(loic, [orders[2], orders[3]])
console.log(order);
console.log(calculateTotal(order).toFixed(2));
console.log(order2);
console.log(calculateTotal(order2).toFixed(2));
console.log("livre : " + JSON.stringify(products[1]));
orderManager.addOrder(order);
console.log(orderManager);
orderManager.addOrder(order2);
console.log(orderManager);
console.log("récup de la commande 1: " + JSON.stringify(orderManager.getOrderById("1")));

orderManager.updateOrderStatus("1", "expédiée");
console.log("expédition de la commande 1...");
console.log("liste des commandes expédiées: " + JSON.stringify(orderManager.listOrdersByStatus("expédiée")));

orderManager.removeOrder("1");
console.log("order 1 bien supprimé !");
console.log(orderManager);