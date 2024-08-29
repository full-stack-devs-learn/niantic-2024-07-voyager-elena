/*
1.	Pizza Shack sells the best pizza in town.

	When customers are ready to order, they should
	be able to see a list of toppings that are 
	included on each type of pizza.

	getToppings("Hawaiian") => ["Ham","Pineapple","Mushroom"]
	getToppings("Cowboy") => ["Pepperoni", "Sausage", "Beef"]
	getToppings("Supreme") => ["Pepperoni", "Sausage", "Pepper", "Onion", "Black Olives"]
	getToppings("Vegetarian") => ["Spinach", "Zucchini", "Mushroom", "Artichoke", "Tomato", "Onion"]
	getToppings("Cheese") => ["Cheese"]

*/

class Pizza {
	constructor(name, toppings) {
		this.name = name;
		this.toppings = toppings;
	}
}

const pizzaData = [
	new Pizza('Hawaiian', ['Ham', 'Pineapple', 'Mushroom']),
	new Pizza('Cowboy', ['Pepperoni', 'Sausage', 'Beef']),
	new Pizza('Supreme', ['Pepperoni', 'Sausage', 'Pepper', 'Onion', 'Black Olives']),
	new Pizza('Vegetarian', ['Spinach', 'Zucchini', 'Mushroom', 'Artichoke', 'Tomato', 'Onion']),
	new Pizza('Cheese', ['Cheese']),
];

const getToppings = pizzaName => {
	const pizzaToppings = pizzaData.find(item => item.name.toUpperCase() === pizzaName.toUpperCase())?.toppings;
	return pizzaToppings || [];
};





/*
2.	Pizza Shack sells the best pizza in town.

	When a customer places an order we make the pizza.
	the makePizza function should return a 
	pizza object with a name, and the list of toppings.

	makePizza("Hawaiian") => {
								name: "Hawaiian",
								toppings: ["Ham","Pineapple","Mushroom"]
							}

*/

const makePizza = pizzaName => pizzaData.find(item => item.name.toUpperCase() === pizzaName.toUpperCase()) || {};




/*
3.	Pizza Shack sells the best custom pizza in town.

	If a customer wants to order a custom pizza they
	can order up to 3 toppings. The makeCustom function
	should create the new pizza as follows...

	makeCustom("chicken") => 
					{
						name: "Custom",
						toppings: ["chicken"]
					}

	makeCustom("chicken", "mushroom") => 
					{
						name: "Custom",
						toppings: ["chicken", "mushroom"]
					}

	makeCustom("chicken", "mushroom", "artichokes") => 
					{
						name: "Custom",
						toppings: ["chicken", "mushroom", "artichokes"]
					}

	// a custom order with no toppings is not allowed an should return
	// an empty object
	makeCustom() => {}

*/

const makeCustom = (topping1 = '', topping2 = '', topping3 = '') => {
	// console.log(arguments);
	// interesting, arguments is not defined for arrow function
	const pizzaName = 'Custom';

	if (topping1 && topping2 && topping3) {
		return new Pizza(pizzaName, [topping1, topping2, topping3]);
	} else if (topping1 && topping2) {
		return new Pizza(pizzaName, [topping1, topping2]);
	} else if (topping1) {
		return new Pizza(pizzaName, [topping1]);
	}

	return {};
}




/*
4.	Customers may want to order multiple pizzas on a single order.

	When a customer places an order you should create an order object.
	This includes the customer name, and an array of all the pizzas
	that they have ordered.

	createOrder("Gary", true, false, false, false, false) => 
		{
			customer: "Gary",
			pizzas: [
				{
					name: "Hawaiian",
					toppings: [
						"Ham",
						"Pineapple",
						"Mushroom"
					]
				}
			]
		}
	

	createOrder("Gary", true, false, false, false, true) => 
		{
			customer: "Gary",
			pizzas: [
				{
					name: "Hawaiian",
					toppings: [
						"Ham",
						"Pineapple",
						"Mushroom"
					]
				},
				{
					name: "Cheese",
					toppings: [
						"Cheese"
					]
				}
			]
		}


*/

class PizzaOrder {
	constructor(customer, pizzas) {
		this.customer = customer;
		this.pizzas = pizzas;
	}
}



const createOrder = (customer, pizza1 = false, pizza2 = false, pizza3 = false, pizza4 = false, pizza5 = false) => {
	pizzaArr = [pizza1, pizza2, pizza3, pizza4, pizza5];
	
	if (pizzaArr.filter(el => el).length === 0) {
		return {};
	} 

	const order = new PizzaOrder(customer, []);
	
	for (let i = 0; i < pizzaArr.length; i++) {
		if (pizzaArr[i]) {
			order.pizzas.push(pizzaData[i]);
		}
	}

	return order;		
};


