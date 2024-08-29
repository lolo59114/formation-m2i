import Customer from "./customer.js";
import OrderItem from "./orderItem.js";

export type Status = "en attente" | "expédiée" | "livrée";
export default interface Order {
    id: string,
    customer: Customer,
    items: OrderItem[],
    status: Status
}