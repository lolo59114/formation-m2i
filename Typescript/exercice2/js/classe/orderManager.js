export default class OrderManager {
    constructor() {
        this.orders = [];
    }
    addOrder(order) {
        this.orders.push(order);
    }
    getOrderById(id) {
        return this.orders.find((order) => order.id === id);
    }
    updateOrderStatus(id, status) {
        this.orders.find((order) => order.id === id).status = status;
    }
    listOrdersByStatus(status) {
        return this.orders.filter((order) => order.status === status);
    }
    removeOrder(id) {
        let index = this.orders.findIndex((order) => order.id === id);
        if (index > -1) {
            this.orders.splice(index, 1);
        }
    }
}
