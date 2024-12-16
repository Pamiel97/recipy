package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.ShoppingList;
import org.generation.italy.recipy.model.entities.Recipe;

public interface OrderingService {
    //gestione lista della spesa che ritorna una shoppingList
    ShoppingList createShoppingListFor(Recipe recipe);
}
