class ShoppingService {

    getListName() {
        return "My Shopping List"
    }

    getShoppingList() {
        return [
            {
                id: 1,
                title: '5 lb sack of potatoes',
                quantity: 1,
                isComplete: false
            },
            {
                id: 2,
                title: 'Frozen Pizza',
                quantity: 4,
                isComplete: false
            },
            {
              id: 3,
              title: '1 gallon pkg Organic Milk',
              quantity: 1,
              isComplete: false
          },
          {
              id: 4,
              title: '1.5 lbs pkg Ground Turkey',
              quantity: 2,
              isComplete: true
          },
          {
              id: 5,
              title: 'Red Bell Pepper',
              quantity: 4,
              isComplete: true
          },
          {
              id: 6,
              title: '1 lbs pkg Organic Cashew',
              quantity: 2,
              isComplete: false
          },
          {
              id: 7,
              title: '2 lbs pkg Gala Apples',
              quantity: 1,
              isComplete: false
          },
          {
              id: 8,
              title: '16 oz Barilla Cellentani Pasta',
              quantity: 2,
              isComplete: false
          },
          {
              id: 9,
              title: 'Bunch of Organic Broccoli',
              quantity: 3,
              isComplete: false
          },
          {
              id: 10,
              title: '5.3 oz Chobany Blueberry Yogurt',
              quantity: 4,
              isComplete: true
          },
        ];
    }
}