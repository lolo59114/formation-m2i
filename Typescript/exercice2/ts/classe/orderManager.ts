import Order, { Status } from "../interface/order.js";

export default class OrderManager {
    private orders: Order[];

    constructor() {
        this.orders = [];
    }

    public addOrder(order: Order) {
        this.orders.push(order);
    }

    public getOrderById(id: string): Order {
        return this.orders.find((order) => order.id === id);
    }

    public updateOrderStatus(id: string, status: Status): void {
        this.orders.find((order) => order.id === id).status = status;
    }

    public listOrdersByStatus(status: Status): Order[] {
        return this.orders.filter((order) => order.status === status);
    }

    public removeOrder(id: string): void {
        let index: number = this.orders.findIndex((order) => order.id === id);
        if(index > -1) {
            this.orders.splice(index, 1);
        }
    }
}